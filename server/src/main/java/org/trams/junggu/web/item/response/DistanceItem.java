package org.trams.junggu.web.item.response;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.trams.junggu.web.common.Utils;

public class DistanceItem  implements ResonseItem{
	
	private List<FormItem> main = new ArrayList<>();

	public List<FormItem> getMain() {
		return main;
	}

	public void setMain(List<FormItem> main) {
		this.main = main;
	}

	@Override
	public String toJSONString() {
		JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	    try {
		    jsonArray.add(Utils.getArrayJson(main,"main"));
		    responseDetailsJson.put("distance", jsonArray);
		} catch (Exception e) {
		}

	    return responseDetailsJson.toJSONString();
	}
	
	@Override
	public void parserJson(String json) {
		try {
			this.setMain(Utils.ConvertJsonTo_List_FormItem(json, "distance", "main"));
		} catch (Exception e) {
			
		}
		
		
	}

	public DistanceItem() {
		super();
	}

	@Override
	public void parserJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}

	public DistanceItem(List<FormItem> main) {
		super();
		this.main = main;
	}

	public void parserArray(String[] val) {
		List<FormItem> mainVal = new ArrayList<>();
		for (int i = 0; i < val.length; i++) {
			try {
				if(val[i] != null){
					String str = val[i];
					String[] value = str.split("_");
					String itemKey = Utils.getStringFromArray(value,0);
					String itemVal = Utils.getStringFromArray(value,1);
					String itemName = Utils.getStringFromArray(value,2);
					FormItem formItem = new FormItem(itemKey,itemVal,itemName);
					mainVal.add(formItem);
				}
			} catch (Exception e) {
			}
		}
		this.setMain(mainVal);
	}
}

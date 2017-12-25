package org.trams.junggu.web.item.response;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.trams.junggu.web.common.Utils;
import org.trams.junggu.web.listitem.StoreListItem;

public class MainGoodService implements ResonseItem{

	private List<FormItem> main1 = new ArrayList<>();
	private List<FormItem> main2 = new ArrayList<>();
	private List<FormItem> main3 = new ArrayList<>();
	private List<FormItem> main4 = new ArrayList<>();
	

	@Override
	public String toJSONString() {
		JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	    jsonArray.add(Utils.getArrayJson(main1,"main1"));
	    jsonArray.add(Utils.getArrayJson(main2,"main2"));
	    jsonArray.add(Utils.getArrayJson(main3,"main3"));
	    jsonArray.add(Utils.getArrayJson(main4,"main4"));
	    responseDetailsJson.put("main_good_service", jsonArray);
	    return responseDetailsJson.toJSONString();
	}
	@Override
	public void parserJson(String json) {
		this.setMain1(Utils.ConvertJsonTo_List_FormItem(json, "main_good_service", "main1"));
		this.setMain2(Utils.ConvertJsonTo_List_FormItem(json, "main_good_service", "main2"));
		this.setMain3(Utils.ConvertJsonTo_List_FormItem(json, "main_good_service", "main3"));
		this.setMain4(Utils.ConvertJsonTo_List_FormItem(json, "main_good_service", "main4"));
		
	}

	public void parserArray(List<String[]> val) {
		
		List<List<FormItem>> mainVal = new ArrayList<>();
		mainVal.add(main1);
		mainVal.add(main2);
		mainVal.add(main3);
		mainVal.add(main4); 
		 
		
		for (int i = 0; i < mainVal.size(); i++) {
			
			List<FormItem> listVal = new ArrayList<>();
			for (int j = 0; j < val.get(i).length; j++) {
				try {
					if(val.get(i)[j] != null){
						String str = val.get(i)[j];
						String[] value = str.split("_");
						String itemKey = Utils.getStringFromArray(value,0);
						String itemVal = Utils.getStringFromArray(value,1);
						String itemName = Utils.getStringFromArray(value,2);
						
						FormItem formItem = new FormItem(itemKey,itemVal,itemName);
						listVal.add(formItem);
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			List<FormItem> item = mainVal.get(i);
			item.addAll(listVal);
			mainVal.set(i, item);
		}
		
		
		for (int i = 0; i < mainVal.size(); i++) {
			
		}
	}
	
	@Override
	public void parserJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}

	public List<FormItem> getMain1() {
		return main1;
	}

	public void setMain1(List<FormItem> main1) {
		this.main1 = main1;
	}

	public List<FormItem> getMain2() {
		return main2;
	}

	public void setMain2(List<FormItem> main2) {
		this.main2 = main2;
	}

	public List<FormItem> getMain3() {
		return main3;
	}

	public void setMain3(List<FormItem> main3) {
		this.main3 = main3;
	}

	public List<FormItem> getMain4() {
		return main4;
	}

	public void setMain4(List<FormItem> main4) {
		this.main4 = main4;
	}

	public void parserArray(String[] val) {
		// TODO Auto-generated method stub
		
	}

	
	
}

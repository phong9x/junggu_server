package org.trams.junggu.web.item.response;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.trams.junggu.web.common.Utils;

public class PurposeNoteItem  implements ResonseItem{
	
	private List<FormItem> main1 = new ArrayList<>();
	private List<FormItem> main2 = new ArrayList<>();
	private List<FormItem> main3 = new ArrayList<>();

	@Override
	public String toJSONString() {
		JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	    try {
		    jsonArray.add(Utils.getArrayJson(main1,"main1"));
		    jsonArray.add(Utils.getArrayJson(main2,"main2"));
		    jsonArray.add(Utils.getArrayJson(main3,"main3"));
		    responseDetailsJson.put("purpose_note", jsonArray);
		} catch (Exception e) {
		}

	    return responseDetailsJson.toJSONString();
	}
	
	public void parserArray(List<String[]> val) {
		
		List<List<FormItem>> mainVal = new ArrayList<>();
		mainVal.add(main1);
		mainVal.add(main2);
		mainVal.add(main3); 
		
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
	public void parserJson(String json) {
		this.setMain1(Utils.ConvertJsonTo_List_FormItem(json, "purpose_note", "main1"));
		this.setMain2(Utils.ConvertJsonTo_List_FormItem(json, "purpose_note", "main2"));
		this.setMain3(Utils.ConvertJsonTo_List_FormItem(json, "purpose_note", "main3"));
				
	}

	@Override
	public void parserJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}
	 
	public void parserArray(String[] val1,String[] val2,String[] val3) {
		List<FormItem> mainVal1 = new ArrayList<>();
		for (int i = 0; i < val1.length; i++) {
			try {
				if(val1[i] != null){
					String str = val1[i];
					String[] value = str.split("_");
					String itemKey = Utils.getStringFromArray(value,0);
					String itemVal = Utils.getStringFromArray(value,1);
					String itemName = Utils.getStringFromArray(value,2);
					
					FormItem formItem = new FormItem(itemKey,itemVal,itemName);
					mainVal1.add(formItem);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		this.setMain1(mainVal1);
		
		
		List<FormItem> mainVal2 = new ArrayList<>();
		for (int i = 0; i < val2.length; i++) {
			try {
				if(val2[i] != null){
					String str = val2[i];
					String[] value = str.split("_");
					String itemKey = Utils.getStringFromArray(value,0);
					String itemVal = Utils.getStringFromArray(value,1);
					String itemName = Utils.getStringFromArray(value,2);
					
					FormItem formItem = new FormItem(itemKey,itemVal,itemName);
					mainVal2.add(formItem);
				}
			} catch (Exception e) {
			}
		}
		this.setMain2(mainVal2);
		
		List<FormItem> mainVal3 = new ArrayList<>();
		for (int i = 0; i < val1.length; i++) {
			try {
				if(val3[i] != null){
					String str = val1[i];
					String[] value = str.split("_");
					String itemKey = Utils.getStringFromArray(value,0);
					String itemVal = Utils.getStringFromArray(value,1);
					String itemName = Utils.getStringFromArray(value,2);
					
					FormItem formItem = new FormItem(itemKey,itemVal,itemName);
					mainVal1.add(formItem);
				}
			} catch (Exception e) {
			}
		}
		this.setMain3(mainVal3);
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
}

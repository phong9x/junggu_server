package org.trams.junggu.web.item.response;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.trams.junggu.web.common.Utils;
import org.trams.junggu.web.listitem.StoreListItem;

public class StaffToHelp implements ResonseItem{

	private List<FormItem> main  = new ArrayList<>();
	private List<FormItem> helpToGet = new ArrayList<>();
	private List<FormItem> justHelp   = new ArrayList<>();

	@Override
	public String toJSONString() {
		JSONObject responseDetailsJson = new JSONObject();
		try {
		    JSONArray jsonArray = new JSONArray();
		    jsonArray.add(Utils.getArrayJson(main,"main"));
		    jsonArray.add(Utils.getArrayJson(helpToGet,"help_to_get"));
		    jsonArray.add(Utils.getArrayJson(justHelp,"just_help"));
		    
		    responseDetailsJson.put("staff_to_help", jsonArray);
		} catch (Exception e) {
		}
	    return responseDetailsJson.toJSONString();
	}
	 
	public void parserArray(List<String[]> val) {
		
		List<List<FormItem>> mainVal = new ArrayList<>();
		mainVal.add(main);
		mainVal.add(helpToGet);
		mainVal.add(justHelp);
		 
		for (int i = 0; i < mainVal.size(); i++) {
			
			List<FormItem> listVal = new ArrayList<>();
			for (int j = 0; j < val.get(i).length; j++) {
				try {
					if(val.get(i)[j] != null){
						String str = val.get(i)[j];
						String[] value = str.split("_");
						String itemKey = Utils.getStringFromArray(value,0);
						String itemVal = Utils.getStringFromArray(value,1);
						String itemName = Utils.getStringFromArray(value,2).replace("^", ",");
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
		this.setMain(Utils.ConvertJsonTo_List_FormItem(json, "staff_to_help", "main"));
		this.setHelpToGet(Utils.ConvertJsonTo_List_FormItem(json, "staff_to_help", "help_to_get"));
		this.setJustHelp(Utils.ConvertJsonTo_List_FormItem(json, "staff_to_help", "just_help"));
	}

	@Override
	public void parserJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}

	public List<FormItem> getMain() {
		return main;
	}

	public void setMain(List<FormItem> main) {
		this.main = main;
	}

	public List<FormItem> getHelpToGet() {
		return helpToGet;
	}

	public void setHelpToGet(List<FormItem> helpToGet) {
		this.helpToGet = helpToGet;
	}

	public List<FormItem> getJustHelp() {
		return justHelp;
	}

	public void setJustHelp(List<FormItem> justHelp) {
		this.justHelp = justHelp;
	}

	public void parserArray(String[] val) {
		// TODO Auto-generated method stub
		
	}
}

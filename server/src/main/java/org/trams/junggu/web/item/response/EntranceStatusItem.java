package org.trams.junggu.web.item.response;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.trams.junggu.web.common.Utils;

public class EntranceStatusItem implements ResonseItem{
	
	private List<FormItem> main = new ArrayList<>();
	private List<FormItem> lift  = new ArrayList<>();
	private List<FormItem> door   = new ArrayList<>();
	private List<FormItem> wideOfDoor = new ArrayList<>();

	public List<FormItem> getMain() {
		return main;
	}

	public void setMain(List<FormItem> main) {
		this.main = main;
	}

	public List<FormItem> getLift() {
		return lift;
	}

	public void setLift(List<FormItem> lift) {
		this.lift = lift;
	}

	public List<FormItem> getDoor() {
		return door;
	}

	public void setDoor(List<FormItem> door) {
		this.door = door;
	}
	public List<FormItem> getWideOfDoor() {
		return wideOfDoor;
	}

	public void setWideOfDoor(List<FormItem> wideOfDoor) {
		this.wideOfDoor = wideOfDoor;
	}

	@Override
	public String toJSONString() {
		JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	    
	    try {
		    jsonArray.add(Utils.getArrayJson(main,"main"));
		    jsonArray.add(Utils.getArrayJson(lift,"lift"));
		    jsonArray.add(Utils.getArrayJson(door,"door"));
		    jsonArray.add(Utils.getArrayJson(wideOfDoor,"wide_of_door"));
		    responseDetailsJson.put("entrance_status", jsonArray);
		} catch (Exception e) {
		}

	    return responseDetailsJson.toJSONString();
	}

	@Override
	public void parserJson(String json) {
		this.setMain(Utils.ConvertJsonTo_List_FormItem(json, "entrance_status", "main"));
		this.setLift(Utils.ConvertJsonTo_List_FormItem(json, "entrance_status", "lift"));
		this.setDoor(Utils.ConvertJsonTo_List_FormItem(json, "entrance_status", "door"));
		this.setWideOfDoor(Utils.ConvertJsonTo_List_FormItem(json, "entrance_status", "wide_of_door"));
	}

	@Override
	public void parserJson(JSONObject json) {
	}

	public void parserArray(List<String[]> val) {
		
		List<List<FormItem>> mainVal = new ArrayList<>();
		mainVal.add(main);
		mainVal.add(lift);
		mainVal.add(door);
		mainVal.add(wideOfDoor);
		 
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
}

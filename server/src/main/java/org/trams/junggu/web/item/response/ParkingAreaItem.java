package org.trams.junggu.web.item.response;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.trams.junggu.web.common.Utils;

public class ParkingAreaItem  implements ResonseItem{
	private List<FormItem> main = new ArrayList<>();
	private List<FormItem> parkingLotArea = new ArrayList<>();
	private List<FormItem> parkingLotDefector = new ArrayList<>();
	private List<FormItem> distance = new ArrayList<>();

	
	public List<FormItem> getMain() {
		return main;
	}

	public void setMain(List<FormItem> main) {
		this.main = main;
	}

	public List<FormItem> getParkingLotArea() {
		return parkingLotArea;
	}

	public void setParkingLotArea(List<FormItem> parkingLotArea) {
		this.parkingLotArea = parkingLotArea;
	}



	public List<FormItem> getParkingLotDefector() {
		return parkingLotDefector;
	}

	public void setParkingLotDefector(List<FormItem> parkingLotDefector) {
		this.parkingLotDefector = parkingLotDefector;
	}

	public List<FormItem> getDistance() {
		return distance;
	}

	public void setDistance(List<FormItem> distance) {
		this.distance = distance;
	}

	@Override
	public String toJSONString() {
		JSONObject responseDetailsJson = new JSONObject();
		try {
		    JSONArray jsonArray = new JSONArray();
		    
		    jsonArray.add(Utils.getArrayJson(main,"main"));
		    jsonArray.add(Utils.getArrayJson(parkingLotArea,"parking_lot_area"));
		    jsonArray.add(Utils.getArrayJson(parkingLotDefector,"parking_lot_defector"));
		    jsonArray.add(Utils.getArrayJson(distance,"distance"));
		    responseDetailsJson.put("parking_area", jsonArray);
		} catch (Exception e) {
		}

	    return responseDetailsJson.toJSONString();
	}

	@Override
	public void parserJson(String json) {
		this.setMain(Utils.ConvertJsonTo_List_FormItem(json, "parking_area", "main"));
		String str=Utils.ConvertJsonTo_List_FormItem(json, "parking_area", "parking_lot_defector").toString();
		this.setParkingLotArea(Utils.ConvertJsonTo_List_FormItem(json, "parking_area", "parking_lot_area"));
		this.setParkingLotDefector(Utils.ConvertJsonTo_List_FormItem(json, "parking_area", "parking_lot_defector"));
		this.setDistance(Utils.ConvertJsonTo_List_FormItem(json, "parking_area", "distance"));
	}

	@Override
	public void parserJson(JSONObject json) {
	}

	public void parserArray(List<String[]> val) {
		
		List<List<FormItem>> mainVal = new ArrayList<>();
		mainVal.add(main);
		mainVal.add(parkingLotArea);
		mainVal.add(parkingLotDefector);
		mainVal.add(distance);
		 
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
}

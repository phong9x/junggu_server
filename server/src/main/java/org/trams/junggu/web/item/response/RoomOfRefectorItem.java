package org.trams.junggu.web.item.response;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.trams.junggu.web.common.Utils;
import org.trams.junggu.web.listitem.StoreListItem;

public class RoomOfRefectorItem implements ResonseItem{

	private List<FormItem> main = new ArrayList<>();
	private List<FormItem> positionOfRoom  = new ArrayList<>();
	private List<FormItem> roomDefector   = new ArrayList<>();
	private List<FormItem> interiorWheelchair  = new ArrayList<>();
	private List<FormItem> interiorSpaceScouter  = new ArrayList<>();
	private List<FormItem> interiorSpaceStair = new ArrayList<>();
	private List<FormItem> hireManual  = new ArrayList<>();
	private List<FormItem> areaOfToilette  = new ArrayList<>();
	private List<FormItem> strapInToilette     = new ArrayList<>();
	private List<FormItem> foodCourt = new ArrayList<>();
	private List<FormItem> inInteriorSpace   = new ArrayList<>();
	private List<FormItem> brailleNotice    = new ArrayList<>();
	
	

	@Override
	public String toJSONString() {
		JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	    jsonArray.add(Utils.getArrayJson(main,"main"));
	    jsonArray.add(Utils.getArrayJson(positionOfRoom,"position_of_room"));
	    jsonArray.add(Utils.getArrayJson(roomDefector,"room_defector"));
	    jsonArray.add(Utils.getArrayJson(interiorWheelchair,"interior_wheelchair"));
	    jsonArray.add(Utils.getArrayJson(interiorSpaceScouter,"interior_space_scouter"));
	    jsonArray.add(Utils.getArrayJson(interiorSpaceStair,"interior_space_stair"));
	    jsonArray.add(Utils.getArrayJson(hireManual,"hire_manual"));
	    jsonArray.add(Utils.getArrayJson(areaOfToilette,"area_of_toilette"));
	    jsonArray.add(Utils.getArrayJson(strapInToilette,"strap_in_toilette"));
	    jsonArray.add(Utils.getArrayJson(foodCourt,"food_court"));
	    jsonArray.add(Utils.getArrayJson(inInteriorSpace,"in_interior_space"));
	    jsonArray.add(Utils.getArrayJson(brailleNotice,"braille_notice"));
	    responseDetailsJson.put("room_of_refector", jsonArray);
	    return responseDetailsJson.toJSONString();
        
	}
	public void parserArray(List<String[]> val) {
		
		List<List<FormItem>> mainVal = new ArrayList<>();
		mainVal.add(main);
		mainVal.add(positionOfRoom);
		mainVal.add(roomDefector);
		mainVal.add(interiorWheelchair);
		mainVal.add(interiorSpaceScouter);
		mainVal.add(interiorSpaceStair);
		mainVal.add(hireManual);
		mainVal.add(areaOfToilette);
		mainVal.add(strapInToilette);
		mainVal.add(foodCourt);
		mainVal.add(inInteriorSpace);
		mainVal.add(brailleNotice);
		
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
		
		this.setMain(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "main"));
		this.setPositionOfRoom(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "position_of_room"));
		this.setRoomDefector(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "room_defector"));
		this.setInteriorWheelchair(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "interior_wheelchair"));
		this.setInteriorSpaceStair(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "interior_space_stair"));
		this.setInteriorSpaceScouter(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "interior_space_scouter"));
		this.setHireManual(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "hire_manual"));
		this.setAreaOfToilette(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "area_of_toilette"));
		this.setStrapInToilette(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "strap_in_toilette"));
		this.setFoodCourt(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "food_court"));
		this.setInInteriorSpace(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "in_interior_space"));
		this.setBrailleNotice(Utils.ConvertJsonTo_List_FormItem(json, "room_of_refector", "braille_notice"));
	}

	@Override
	public void parserJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}

	public RoomOfRefectorItem() {
		super();
	}
	public RoomOfRefectorItem(List<FormItem> main, List<FormItem> positionOfRoom, List<FormItem> roomDefector,
			List<FormItem> interiorWheelchair, List<FormItem> interiorSpaceScouter, List<FormItem> interiorSpaceStair,
			List<FormItem> hireManual, List<FormItem> areaOfToilette, List<FormItem> strapInToilette,
			List<FormItem> foodCourt, List<FormItem> inInteriorSpace, List<FormItem> brailleNotice) {
		super();
		this.main = main;
		this.positionOfRoom = positionOfRoom;
		this.roomDefector = roomDefector;
		this.interiorWheelchair = interiorWheelchair;
		this.interiorSpaceScouter = interiorSpaceScouter;
		this.interiorSpaceStair = interiorSpaceStair;
		this.hireManual = hireManual;
		this.areaOfToilette = areaOfToilette;
		this.strapInToilette = strapInToilette;
		this.foodCourt = foodCourt;
		this.inInteriorSpace = inInteriorSpace;
		this.brailleNotice = brailleNotice;
	}
	public List<FormItem> getMain() {
		return main;
	}

	public void setMain(List<FormItem> main) {
		this.main = main;
	}

	public List<FormItem> getPositionOfRoom() {
		return positionOfRoom;
	}

	public void setPositionOfRoom(List<FormItem> positionOfRoom) {
		this.positionOfRoom = positionOfRoom;
	}

	public List<FormItem> getRoomDefector() {
		return roomDefector;
	}

	public void setRoomDefector(List<FormItem> roomDefector) {
		this.roomDefector = roomDefector;
	}

	public List<FormItem> getInteriorWheelchair() {
		return interiorWheelchair;
	}

	public void setInteriorWheelchair(List<FormItem> interiorWheelchair) {
		this.interiorWheelchair = interiorWheelchair;
	}

	public List<FormItem> getInteriorSpaceScouter() {
		return interiorSpaceScouter;
	}

	public void setInteriorSpaceScouter(List<FormItem> interiorSpaceScouter) {
		this.interiorSpaceScouter = interiorSpaceScouter;
	}

	public List<FormItem> getInteriorSpaceStair() {
		return interiorSpaceStair;
	}

	public void setInteriorSpaceStair(List<FormItem> interiorSpaceStair) {
		this.interiorSpaceStair = interiorSpaceStair;
	}

	public List<FormItem> getHireManual() {
		return hireManual;
	}

	public void setHireManual(List<FormItem> hireManual) {
		this.hireManual = hireManual;
	}

	public List<FormItem> getAreaOfToilette() {
		return areaOfToilette;
	}

	public void setAreaOfToilette(List<FormItem> areaOfToilette) {
		this.areaOfToilette = areaOfToilette;
	}

	public List<FormItem> getStrapInToilette() {
		return strapInToilette;
	}

	public void setStrapInToilette(List<FormItem> strapInToilette) {
		this.strapInToilette = strapInToilette;
	}

	public List<FormItem> getFoodCourt() {
		return foodCourt;
	}

	public void setFoodCourt(List<FormItem> foodCourt) {
		this.foodCourt = foodCourt;
	}

	public List<FormItem> getInInteriorSpace() {
		return inInteriorSpace;
	}

	public void setInInteriorSpace(List<FormItem> inInteriorSpace) {
		this.inInteriorSpace = inInteriorSpace;
	}

	public List<FormItem> getBrailleNotice() {
		return brailleNotice;
	}

	public void setBrailleNotice(List<FormItem> brailleNotice) {
		this.brailleNotice = brailleNotice;
	}

	public void parserArray(String[] val) {
		// TODO Auto-generated method stub
		
	}

	
}

package org.trams.junggu.web.item.response;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.trams.junggu.web.common.Utils;
import org.trams.junggu.web.listitem.StoreListItem;

public class ToiletteForDefector implements ResonseItem{

	private List<FormItem> main = new ArrayList<>();
	private List<FormItem> toiletteGender  = new ArrayList<>();
	private List<FormItem> entranceDoor   = new ArrayList<>();
	private List<FormItem> normalToilette   = new ArrayList<>();
	private List<FormItem> numberOfBuildingPlaced  = new ArrayList<>();
	private List<FormItem> positionOfToilette  = new ArrayList<>();
	private List<FormItem> brailleNotice   = new ArrayList<>();
	private List<FormItem> numberOfBuildingDefector = new ArrayList<>();
	private List<FormItem> position  = new ArrayList<>();
	private List<FormItem> genderNeutral  = new ArrayList<>();
	private List<FormItem> doorStatus  = new ArrayList<>();
	private List<FormItem> spaceInside = new ArrayList<>();
	private List<FormItem> handleNextUrinal  = new ArrayList<>();
	private List<FormItem> handleNextCloset  = new ArrayList<>();
	private List<FormItem> cleaning = new ArrayList<>();
	@Override
	public String toJSONString() {
		JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	    jsonArray.add(Utils.getArrayJson(main,"main"));
	    jsonArray.add(Utils.getArrayJson(toiletteGender,"toilette_gender"));
	    jsonArray.add(Utils.getArrayJson(entranceDoor,"entrance_door"));
	    jsonArray.add(Utils.getArrayJson(normalToilette,"normal_toilette"));
	    jsonArray.add(Utils.getArrayJson(numberOfBuildingPlaced,"number_of_building_placed"));
	    jsonArray.add(Utils.getArrayJson(positionOfToilette,"position_of_toilette"));
	    jsonArray.add(Utils.getArrayJson(brailleNotice,"braille_notice"));
	    jsonArray.add(Utils.getArrayJson(numberOfBuildingDefector,"number_of_building_defector"));
	    jsonArray.add(Utils.getArrayJson(position,"position"));
	    jsonArray.add(Utils.getArrayJson(genderNeutral,"gender_neutral"));
	    jsonArray.add(Utils.getArrayJson(doorStatus,"door_status"));
	    jsonArray.add(Utils.getArrayJson(spaceInside ,"space_inside"));
	    jsonArray.add(Utils.getArrayJson(handleNextUrinal,"handle_next_urinal"));
	    jsonArray.add(Utils.getArrayJson(handleNextCloset,"handle_next_closet"));
	    jsonArray.add(Utils.getArrayJson(cleaning,"cleaning"));
	    responseDetailsJson.put("toilette_for_defector", jsonArray);
	    return responseDetailsJson.toJSONString();
        
	}
	
	public void parserArray(List<String[]> val) {
		
		List<List<FormItem>> mainVal = new ArrayList<>();
		mainVal.add(main);
		mainVal.add(toiletteGender);
		mainVal.add(entranceDoor);
		mainVal.add(normalToilette);
		mainVal.add(numberOfBuildingPlaced);
		mainVal.add(positionOfToilette);
		mainVal.add(brailleNotice);
		mainVal.add(numberOfBuildingDefector);
		mainVal.add(position);
		mainVal.add(genderNeutral);
		mainVal.add(doorStatus);
		mainVal.add(spaceInside);
		mainVal.add(handleNextUrinal);
		mainVal.add(handleNextCloset);
		mainVal.add(cleaning);
		
		 
		
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
		this.setMain(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "main"));
		this.setToiletteGender(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "toilette_gender"));
		this.setEntranceDoor(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "entrance_door"));
		this.setNormalToilette(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "normal_toilette"));
		this.setNumberOfBuildingPlaced(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "number_of_building_placed"));
		this.setPositionOfToilette(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "position_of_toilette"));
		this.setBrailleNotice(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "braille_notice"));
		this.setNumberOfBuildingDefector(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "number_of_building_defector"));
		this.setPosition(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "position"));
		this.setGenderNeutral(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "gender_neutral"));
		this.setDoorStatus(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "door_status"));
		this.setSpaceInside(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "space_inside"));
		this.setHandleNextUrinal(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "handle_next_urinal"));
		this.setHandleNextCloset(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "handle_next_closet"));
		this.setCleaning(Utils.ConvertJsonTo_List_FormItem(json, "toilette_for_defector", "cleaning"));
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


	public List<FormItem> getToiletteGender() {
		return toiletteGender;
	}

	public void setToiletteGender(List<FormItem> toiletteGender) {
		this.toiletteGender = toiletteGender;
	}

	public List<FormItem> getEntranceDoor() {
		return entranceDoor;
	}

	public void setEntranceDoor(List<FormItem> entranceDoor) {
		this.entranceDoor = entranceDoor;
	}

	public List<FormItem> getNormalToilette() {
		return normalToilette;
	}

	public void setNormalToilette(List<FormItem> normalToilette) {
		this.normalToilette = normalToilette;
	}

	

	public List<FormItem> getNumberOfBuildingPlaced() {
		return numberOfBuildingPlaced;
	}

	public void setNumberOfBuildingPlaced(List<FormItem> numberOfBuildingPlaced) {
		this.numberOfBuildingPlaced = numberOfBuildingPlaced;
	}

	public List<FormItem> getPositionOfToilette() {
		return positionOfToilette;
	}

	public void setPositionOfToilette(List<FormItem> positionOfToilette) {
		this.positionOfToilette = positionOfToilette;
	}

	public List<FormItem> getNumberOfBuildingDefector() {
		return numberOfBuildingDefector;
	}

	public void setNumberOfBuildingDefector(List<FormItem> numberOfBuildingDefector) {
		this.numberOfBuildingDefector = numberOfBuildingDefector;
	}

	public List<FormItem> getPosition() {
		return position;
	}

	public void setPosition(List<FormItem> position) {
		this.position = position;
	}

	public List<FormItem> getGenderNeutral() {
		return genderNeutral;
	}

	public void setGenderNeutral(List<FormItem> genderNeutral) {
		this.genderNeutral = genderNeutral;
	}

	public List<FormItem> getDoorStatus() {
		return doorStatus;
	}

	public void setDoorStatus(List<FormItem> doorStatus) {
		this.doorStatus = doorStatus;
	}

	public List<FormItem> getHandleNextUrinal() {
		return handleNextUrinal;
	}

	public void setHandleNextUrinal(List<FormItem> handleNextUrinal) {
		this.handleNextUrinal = handleNextUrinal;
	}

	public List<FormItem> getHandleNextCloset() {
		return handleNextCloset;
	}

	public void setHandleNextCloset(List<FormItem> handleNextCloset) {
		this.handleNextCloset = handleNextCloset;
	}

	public List<FormItem> getCleaning() {
		return cleaning;
	}

	public void setCleaning(List<FormItem> cleaning) {
		this.cleaning = cleaning;
	}

	public List<FormItem> getBrailleNotice() {
		return brailleNotice;
	}

	public void setBrailleNotice(List<FormItem> brailleNotice) {
		this.brailleNotice = brailleNotice;
	}
	
	public List<FormItem> getSpaceInside() {
		return spaceInside;
	}

	public void setSpaceInside(List<FormItem> spaceInside) {
		this.spaceInside = spaceInside;
	}

	public void parserArray(String[] val) {
		// TODO Auto-generated method stub
	}
	
	
}

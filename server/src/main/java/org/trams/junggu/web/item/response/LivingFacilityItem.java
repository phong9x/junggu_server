package org.trams.junggu.web.item.response;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.trams.junggu.web.common.Utils;

public class LivingFacilityItem implements ResonseItem{
	private List<FormItem> main = new ArrayList<>();
	private List<FormItem> space  = new ArrayList<>();
	private List<FormItem> elevatorWheelChair  = new ArrayList<>();
	private List<FormItem> elevatorWhichScouter   = new ArrayList<>();
	private List<FormItem> buttonForDefectorDanger = new ArrayList<>();
	private List<FormItem> brailleNoticeBoard  = new ArrayList<>();

	@Override
	public String toJSONString() {
		JSONObject responseDetailsJson = new JSONObject();
		try {
		    JSONArray jsonArray = new JSONArray();

		    jsonArray.add(Utils.getArrayJson(main,"main"));
		    jsonArray.add(Utils.getArrayJson(space,"space"));
		    jsonArray.add(Utils.getArrayJson(elevatorWheelChair,"elevator_wheel_chair"));
		    jsonArray.add(Utils.getArrayJson(elevatorWhichScouter,"elevator_which_scouter"));
		    jsonArray.add(Utils.getArrayJson(buttonForDefectorDanger,"button_for_defector_danger"));
		    jsonArray.add(Utils.getArrayJson(brailleNoticeBoard,"braille_notice_board"));
		     
		    responseDetailsJson.put("living_facility", jsonArray);
		} catch (Exception e) {
		}

	    return responseDetailsJson.toJSONString();
	}

	@Override
	public void parserJson(String json) {
		this.setMain(Utils.ConvertJsonTo_List_FormItem(json, "living_facility", "main"));
		this.setSpace(Utils.ConvertJsonTo_List_FormItem(json, "living_facility", "space"));
		this.setElevatorWheelChair(Utils.ConvertJsonTo_List_FormItem(json, "living_facility", "elevator_wheel_chair"));
		this.setElevatorWhichScouter(Utils.ConvertJsonTo_List_FormItem(json, "living_facility", "elevator_which_scouter"));
		this.setButtonForDefectorDanger(Utils.ConvertJsonTo_List_FormItem(json, "living_facility", "button_for_defector_danger"));
		this.setBrailleNoticeBoard(Utils.ConvertJsonTo_List_FormItem(json, "living_facility", "braille_notice_board"));
		
	}

	@Override
	public void parserJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}
	
	public void parserArray(List<String[]> val) {
		
		List<List<FormItem>> mainVal = new ArrayList<>();
		mainVal.add(main);
		mainVal.add(space);
		mainVal.add(elevatorWheelChair);
		mainVal.add(elevatorWhichScouter);
		mainVal.add(buttonForDefectorDanger);
		mainVal.add(brailleNoticeBoard);
		 
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
	public List<FormItem> getMain() {
		return main;
	}

	public void setMain(List<FormItem> main) {
		this.main = main;
	}

	public List<FormItem> getElevatorWheelChair() {
		return elevatorWheelChair;
	}

	public void setElevatorWheelChair(List<FormItem> elevatorWheelChair) {
		this.elevatorWheelChair = elevatorWheelChair;
	}

	public List<FormItem> getElevatorWhichScouter() {
		return elevatorWhichScouter;
	}

	public void setElevatorWhichScouter(List<FormItem> elevatorWhichScouter) {
		this.elevatorWhichScouter = elevatorWhichScouter;
	}

	public List<FormItem> getButtonForDefectorDanger() {
		return buttonForDefectorDanger;
	}

	public void setButtonForDefectorDanger(List<FormItem> buttonForDefectorDanger) {
		this.buttonForDefectorDanger = buttonForDefectorDanger;
	}

	public List<FormItem> getBrailleNoticeBoard() {
		return brailleNoticeBoard;
	}

	public void setBrailleNoticeBoard(List<FormItem> brailleNoticeBoard) {
		this.brailleNoticeBoard = brailleNoticeBoard;
	}

	public List<FormItem> getSpace() {
		return space;
	}

	public void setSpace(List<FormItem> space) {
		this.space = space;
	}

}

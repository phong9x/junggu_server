package org.trams.junggu.web.item.response;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.trams.junggu.web.common.Utils;

public class SpaceItem implements ResonseItem{
	private List<FormItem> main = new ArrayList<>();
	private List<FormItem> interiorSpacewheelchairCanUse  = new ArrayList<>();
	private List<FormItem> interiorSpaceScouterCanUse  = new ArrayList<>();
	private List<FormItem> interiorSpaceSStairOrWay = new ArrayList<>();
	private List<FormItem> spaceCanUseByDefectorAndPeople  = new ArrayList<>();
	private List<FormItem> storeServiceTableAndRackForm = new ArrayList<>();
	private List<FormItem> brailleBlockBlinderInside = new ArrayList<>();
	private List<FormItem> brailleNoticeBoardBlinder = new ArrayList<>();
	private List<FormItem> cinemaTheatreWhereDefactor = new ArrayList<>();
	private List<FormItem> placeDefectorInCinemaTheatre = new ArrayList<>();

	@Override
	public String toJSONString() {
		JSONObject responseDetailsJson = new JSONObject();
		try {
		    JSONArray jsonArray = new JSONArray();
		    
		    jsonArray.add(Utils.getArrayJson(main,"main"));
		    jsonArray.add(Utils.getArrayJson(interiorSpacewheelchairCanUse,"interior_space_wheelchair_can_use"));
		    jsonArray.add(Utils.getArrayJson(interiorSpaceScouterCanUse,"interior_space_scouter_can_use"));
		    jsonArray.add(Utils.getArrayJson(interiorSpaceSStairOrWay,"interior_space_stair_or_way"));
		    jsonArray.add(Utils.getArrayJson(spaceCanUseByDefectorAndPeople,"space_can_use_by_defector_and_people"));
		    jsonArray.add(Utils.getArrayJson(storeServiceTableAndRackForm,"store_service_table_and_rack_form"));
		    jsonArray.add(Utils.getArrayJson(brailleBlockBlinderInside,"braille_block_blinder_inside"));
		    jsonArray.add(Utils.getArrayJson(brailleNoticeBoardBlinder,"braille_notice_board_blinder"));
		    jsonArray.add(Utils.getArrayJson(cinemaTheatreWhereDefactor,"cinema_theatre_where_defactor"));
		    jsonArray.add(Utils.getArrayJson(placeDefectorInCinemaTheatre,"place_defector_in_cinema_theatre")); 
		     
		    responseDetailsJson.put("space", jsonArray);
		} catch (Exception e) {
		}

	    return responseDetailsJson.toJSONString();
	}

	@Override
	public void parserJson(String json) {
		this.setMain(Utils.ConvertJsonTo_List_FormItem(json, "space", "main"));
		this.setInteriorSpacewheelchairCanUse(Utils.ConvertJsonTo_List_FormItem(json, "space", "interior_space_wheelchair_can_use"));
		this.setInteriorSpaceScouterCanUse(Utils.ConvertJsonTo_List_FormItem(json, "space", "interior_space_scouter_can_use"));
		this.setInteriorSpaceSStairOrWay(Utils.ConvertJsonTo_List_FormItem(json, "space", "interior_space_stair_or_way"));
		this.setSpaceCanUseByDefectorAndPeople(Utils.ConvertJsonTo_List_FormItem(json, "space", "space_can_use_by_defector_and_people"));
		this.setStoreServiceTableAndRackForm(Utils.ConvertJsonTo_List_FormItem(json, "space", "store_service_table_and_rack_form"));
		this.setBrailleBlockBlinderInside(Utils.ConvertJsonTo_List_FormItem(json, "space", "braille_block_blinder_inside"));
		this.setBrailleNoticeBoardBlinder(Utils.ConvertJsonTo_List_FormItem(json, "space", "braille_notice_board_blinder"));
		this.setCinemaTheatreWhereDefactor(Utils.ConvertJsonTo_List_FormItem(json, "space", "cinema_theatre_where_defactor"));
		this.setPlaceDefectorInCinemaTheatre(Utils.ConvertJsonTo_List_FormItem(json, "space", "place_defector_in_cinema_theatre"));
	}

	@Override
	public void parserJson(JSONObject json) {
 
		
	}
	
	public void parserArray(List<String[]> val) {
		
		List<List<FormItem>> mainVal = new ArrayList<>();
		mainVal.add(main);
		mainVal.add(interiorSpacewheelchairCanUse);
		mainVal.add(interiorSpaceScouterCanUse);
		mainVal.add(interiorSpaceSStairOrWay);
		mainVal.add(spaceCanUseByDefectorAndPeople);
		mainVal.add(storeServiceTableAndRackForm);
		mainVal.add(brailleBlockBlinderInside);
		mainVal.add(brailleNoticeBoardBlinder);
		mainVal.add(cinemaTheatreWhereDefactor);
		mainVal.add(placeDefectorInCinemaTheatre);
		
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

	public List<FormItem> getInteriorSpacewheelchairCanUse() {
		return interiorSpacewheelchairCanUse;
	}

	public void setInteriorSpacewheelchairCanUse(List<FormItem> interiorSpacewheelchairCanUse) {
		this.interiorSpacewheelchairCanUse = interiorSpacewheelchairCanUse;
	}

	public List<FormItem> getInteriorSpaceScouterCanUse() {
		return interiorSpaceScouterCanUse;
	}

	public void setInteriorSpaceScouterCanUse(List<FormItem> interiorSpaceScouterCanUse) {
		this.interiorSpaceScouterCanUse = interiorSpaceScouterCanUse;
	}

	public List<FormItem> getInteriorSpaceSStairOrWay() {
		return interiorSpaceSStairOrWay;
	}

	public void setInteriorSpaceSStairOrWay(List<FormItem> interiorSpaceSStairOrWay) {
		this.interiorSpaceSStairOrWay = interiorSpaceSStairOrWay;
	}

	public List<FormItem> getSpaceCanUseByDefectorAndPeople() {
		return spaceCanUseByDefectorAndPeople;
	}

	public void setSpaceCanUseByDefectorAndPeople(List<FormItem> spaceCanUseByDefectorAndPeople) {
		this.spaceCanUseByDefectorAndPeople = spaceCanUseByDefectorAndPeople;
	}

	public List<FormItem> getStoreServiceTableAndRackForm() {
		return storeServiceTableAndRackForm;
	}

	public void setStoreServiceTableAndRackForm(List<FormItem> storeServiceTableAndRackForm) {
		this.storeServiceTableAndRackForm = storeServiceTableAndRackForm;
	}

	public List<FormItem> getBrailleBlockBlinderInside() {
		return brailleBlockBlinderInside;
	}

	public void setBrailleBlockBlinderInside(List<FormItem> brailleBlockBlinderInside) {
		this.brailleBlockBlinderInside = brailleBlockBlinderInside;
	}

	public List<FormItem> getBrailleNoticeBoardBlinder() {
		return brailleNoticeBoardBlinder;
	}

	public void setBrailleNoticeBoardBlinder(List<FormItem> brailleNoticeBoardBlinder) {
		this.brailleNoticeBoardBlinder = brailleNoticeBoardBlinder;
	}

	public List<FormItem> getCinemaTheatreWhereDefactor() {
		return cinemaTheatreWhereDefactor;
	}

	public void setCinemaTheatreWhereDefactor(List<FormItem> cinemaTheatreWhereDefactor) {
		this.cinemaTheatreWhereDefactor = cinemaTheatreWhereDefactor;
	}

	public List<FormItem> getPlaceDefectorInCinemaTheatre() {
		return placeDefectorInCinemaTheatre;
	}

	public void setPlaceDefectorInCinemaTheatre(List<FormItem> placeDefectorInCinemaTheatre) {
		this.placeDefectorInCinemaTheatre = placeDefectorInCinemaTheatre;
	}

	public void parserArray(String[] val) {
		// TODO Auto-generated method stub
		
	}
}

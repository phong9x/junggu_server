package org.trams.junggu.web.item;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class FacilityDataItem implements JSONAware{
	private String nameOfRelevant;
	private List<String> photos;
	
	public FacilityDataItem() {
		photos = new ArrayList<>();
	}
	public String getNameOfRelevant() {
		return nameOfRelevant;
	}
	public void setNameOfRelevant(String nameOfRelevant) {
		this.nameOfRelevant = nameOfRelevant;
	}
	public List<String> getPhotos() {
		return photos;
	}
	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}
	
	public void addPhoto(String patch){
		if(this.photos != null){
			this.photos.add(patch);
		}
	}
	
	
	@Override
	public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("{");
        
        sb.append("\""+JSONObject.escape("name_of_relevant")+ "\"");
        sb.append(":");
        sb.append("\"" + JSONObject.escape(nameOfRelevant) + "\"");
        
        sb.append(",");
        sb.append("\""+JSONObject.escape("photos")+ "\"");
        sb.append(":");
        sb.append(JSONArray.toJSONString(photos));
        
        sb.append("}");
        
        return sb.toString();
	}
	
	@Override
	public String toJSONString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("{");
        sb.append("\""+JSONObject.escape("name_of_relevant")+ "\"");
        sb.append(":");
        sb.append("\"" + JSONObject.escape(nameOfRelevant) + "\"");
        sb.append(",");
        sb.append("\""+JSONObject.escape("photos")+ "\"");
        sb.append(":");
        sb.append(JSONArray.toJSONString(photos));
        sb.append("}");
        
        return sb.toString();
	}
	
	
}

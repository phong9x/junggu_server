package org.trams.junggu.web.item.response;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.trams.junggu.web.common.Utils;
import org.trams.junggu.web.listitem.StoreListItem;

public class ImageExtend {

	private List<String> photo  = new ArrayList<>();
	private String name ;
	public List<String> getPhoto() {
		return photo;
	}
	public void setPhoto(List<String> photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ImageExtend(List<String> photo, String name) {
		super();
		this.photo = photo;
		this.name = name;
	}
	public ImageExtend() {
		super();
	}
	
	
}

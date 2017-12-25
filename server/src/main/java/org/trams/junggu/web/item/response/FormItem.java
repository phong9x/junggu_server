package org.trams.junggu.web.item.response;

import org.json.simple.JSONObject;

public class FormItem {
	 private String key;
	 private String value;
	 private String name;
	 
	public FormItem() {
		super();
	}
	public FormItem(String key, String value, String name) {
		super();
		this.key = key;
		this.value = value;
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		if(value != null){
			return name;
		}
		return null;
	}
	public JSONObject tojSon() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("key", this.key);
			obj.put("name", this.name);
			obj.put("value", this.value);
		} catch (Exception e) {
		}
		return obj;
	}
}

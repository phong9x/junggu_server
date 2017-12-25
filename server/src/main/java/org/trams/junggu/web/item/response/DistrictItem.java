package org.trams.junggu.web.item.response;

public class DistrictItem {
	private int id;
	private int cityid;
	private String name;
	
	public DistrictItem() {
	}

	public DistrictItem(int id, int cityid, String name) {
		this.id = id;
		this.cityid = cityid;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

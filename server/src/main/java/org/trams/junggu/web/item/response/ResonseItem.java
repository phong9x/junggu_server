package org.trams.junggu.web.item.response;

import org.json.simple.JSONObject;

public interface ResonseItem {
	public String toJSONString(); 
	public void parserJson(String json);
	public void parserJson(JSONObject json);
}

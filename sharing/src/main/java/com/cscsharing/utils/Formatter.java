package com.cscsharing.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import net.sf.json.JSONObject;

public class Formatter {
	
	private static final Log logger = LogFactory.getLog(Formatter.class);
	
	public static JSONObject convertToJSON(String jsonStr){
		logger.debug("Formatter Class, Convert json string to json object: " + jsonStr);
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		String d = jsonObject.getString("d");
		jsonObject = JSONObject.fromObject(d);
		String results = jsonObject.getString("results");
		jsonObject = JSONObject.fromObject(results);
		return jsonObject;
	}
}

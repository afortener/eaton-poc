package com.eaton.px;

import org.json.CDL;
import org.json.JSONArray;

/**
 * Custom transformer class to transform a CSV string to a JSON
 * object array.
 * @author Brian Jimerson
 *
 */
public class CsvTransformer {

	/**
	 * Transforms the CSV payload passed to a JSON array.
	 * @param payload The CSV payload to transform.
	 * @return A JSON array from the CSV, as a string.  The field names in
	 * each JSON object is taken from the first row in the CSV.
	 */
	public String transform(String payload) {
		
		JSONArray payloadAsJson = CDL.toJSONArray(payload);
		if (payloadAsJson.length() > 0) {
			return payloadAsJson.get(0).toString();
		} else {
			return "";
		}
		
	}
	
}

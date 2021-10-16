package com.in28minutes.unittesting.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

	@Test
	public void jsonAssert() throws JSONException {

		String exptectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";//: 1 //space is here
		JSONAssert.assertEquals(exptectedResponse, actualResponse, true);
	}
	
	@Test
	public void jsonAssert_strict_false() throws JSONException {
		
		String exptectedResponse = "{\"id\": 1,\"name\":\"Ball\"}";
		JSONAssert.assertEquals(exptectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssert_withoutEscape() throws JSONException {
		
		String exptectedResponse = "{id: 1, name:Ball }";
		JSONAssert.assertEquals(exptectedResponse, actualResponse, false);
	}

}

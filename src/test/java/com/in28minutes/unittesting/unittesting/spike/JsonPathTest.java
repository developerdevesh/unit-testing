package com.in28minutes.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void learning() {
		String responseFromService="[" + 
				"{\"id\":1000, \"name\":\"pencil\", \"quantity\":5},\r\n" + 
				"{\"id\":1001, \"name\":\"pen\", \"quantity\":10},\r\n" + 
				"{\"id\":1002, \"name\":\"Eraser\", \"quantity\":15}" + 
				"]";
		
		
		DocumentContext context=JsonPath.parse(responseFromService);
		
		int length=context.read("$.length()");
		
		assertThat(length).isEqualTo(3);
		List<Integer> ids=context.read("$..id");
		assertThat(ids).containsExactly(1000,1001,1002);
		System.out.println(context.read("$.[0:2]").toString());//0 include 2 exclude  so print 0 & 1 elements of array
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
 	}

}

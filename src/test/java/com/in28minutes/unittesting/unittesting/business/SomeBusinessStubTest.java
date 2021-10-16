package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
	
		return new int[] {1,2,3};
	}
	
}
class SomeDataServiceOneStub implements SomeDataService{
	
	@Override
	public int[] retrieveAllData() {
		
		return new int[] {5};
	}
	
}
class SomeDataServiceEmptyStub implements SomeDataService{
	
	@Override
	public int[] retrieveAllData() {
		
		return new int[] {};
	}
	
}

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult,"values not matched");

	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult,"values not matched");
		
	}
	
	@Test
	public void calculateSumUsingDataService_one() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneStub());
		
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult,"values not matched");
		
	}

}

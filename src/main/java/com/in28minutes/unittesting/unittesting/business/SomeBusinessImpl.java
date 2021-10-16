package com.in28minutes.unittesting.unittesting.business;

import java.util.Arrays;
import java.util.OptionalInt;

public class SomeBusinessImpl {

	private SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		// 1,2,3,4,5= 1+2+3+4+5
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}

	public int calculateSumUsingDataService() {
		int sum = 0;

		int[] data = someDataService.retrieveAllData();

		for (int value : data) {
			sum += value;
		}

		// someDataService.storeSum(sum);

		return sum;
	}

}

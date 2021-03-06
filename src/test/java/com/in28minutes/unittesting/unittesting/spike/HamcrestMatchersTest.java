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

public class HamcrestMatchersTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12, 15, 45);
		
		//hamcrest
		assertThat(numbers, hasSize(3));
		assertThat(numbers, hasItems(12,15));
		assertThat(numbers, everyItem(greaterThan(10)));
		assertThat("ABCDE", endsWith("CDE"));
		
		
		//assertJ
		assertThat(numbers)
		.hasSize(3)
		.contains(12,15)
		.allMatch(x-> x>10)
		.noneMatch(x-> x<0);
		
		
	}

}

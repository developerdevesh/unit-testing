package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.model.Item;

//@RunWith(MockitoJUnitRunner.class)  --junit4
@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService business = new ItemBusinessService();
	
	@Mock
	private ItemRepository repository = mock(ItemRepository.class);
	

	@Test
	public void calculateSumUsingDataService_empty() {

		when(repository.findAll()).thenReturn(Arrays.asList(new Item(1, "Ball", 5, 10),new Item(2, "Pen", 6, 10)));
		
		List<Item> items=business.retrieveAllItems();
		assertEquals(10, items.get(0).getQuantity());
		assertEquals(6, items.get(1).getPrice());

	}

}

package com.in28minutes.unittesting.unittesting.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.in28minutes.unittesting.unittesting.business.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository repository;
	
	
	@Test
	public void testFindAll() {
		List<Item> items=repository.findAll();
		
		assertEquals(2, items.size());
	}
	
	
}

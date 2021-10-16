package com.in28minutes.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {

	@Autowired
	ItemRepository itemRepository;
	
	public Item retrieveHardcodedItem() {
		return itemRepository.findById(1001).get();
	}
	
	
	
	public List<Item> retrieveAllItems(){
		return itemRepository.findAll();
	}
	
}

package com.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.entity.GroceryItem;

public interface ItemRepository extends MongoRepository<GroceryItem, String> {

	@Query("{name:'?0'}")
	GroceryItem findItemByName(String name);

	List<GroceryItem> findAllByName(String name);

	@Query("{category:'?0'}")
	List<GroceryItem> findAll(String category);

	public long count();

}

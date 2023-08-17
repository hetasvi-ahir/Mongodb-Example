package com.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document("groceryitems")
@Data
@NoArgsConstructor
public class GroceryItem {

	@Id
	private String id;
	private String name;
	private int quantity;
	private String category;

}
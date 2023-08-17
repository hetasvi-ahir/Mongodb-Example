package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.GroceryItem;
import com.demo.repository.ItemRepository;

@RestController
@RequestMapping("/api/v1")
public class GroceryController {
	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/items")
	public List<GroceryItem> getAllEmployees() {
		return itemRepository.findAll();
	}

	@GetMapping("/itemsById")
	public ResponseEntity<Object> getEmployeeById(@RequestParam("name") String name) {
		// GroceryItem item = itemRepository.findItemByName(name);
		Optional<GroceryItem> findById = itemRepository.findById(name);

		if (findById.isPresent()) {
			GroceryItem item = findById.get();

			System.out.println(item);
			return ResponseEntity.ok().body(item);
		}
		return ResponseEntity.ok().body("nothing");

	}

	@GetMapping("/itembyname")
	public ResponseEntity<Object> getItemsByName(@RequestParam("name") String name) {

		GroceryItem findItemByName = itemRepository.findItemByName(name);
		if (findItemByName != null) {

			return ResponseEntity.ok().body(findItemByName);
		}
		return ResponseEntity.ok().body("nothing");

	}

	@GetMapping("/items/name")
	public ResponseEntity<Object> getEmployeeByname(@RequestParam("name") String name) {

		List<GroceryItem> findById = itemRepository.findAllByName(name);

		return ResponseEntity.ok().body(findById);

	}

	@PostMapping("/items")
	public GroceryItem createEmployee(@RequestBody GroceryItem item) {

		return itemRepository.save(item);
	}

	@PutMapping("/items/{id}")
	public ResponseEntity<GroceryItem> updateItem(@PathVariable(value = "id") String itemId,
			@RequestBody GroceryItem itemDetails) {
		GroceryItem item = itemRepository.findItemByName(itemId);
		item.setId(itemId);
		item.setCategory(itemDetails.getCategory());
		item.setName(itemDetails.getName());
		item.setQuantity(item.getQuantity());

		GroceryItem updateItem = itemRepository.findItemByName(itemId);
		return ResponseEntity.ok(updateItem);
	}

	@DeleteMapping("/items/{id}")
	public Map<String, Boolean> deleteItem(@PathVariable(value = "id") String itemId) {
		GroceryItem item = itemRepository.findItemByName(itemId);
		itemRepository.delete(item);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

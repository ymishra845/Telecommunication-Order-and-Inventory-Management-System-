package com.catalog_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog_service.Model.CatalogItem;
import com.catalog_service.services.CatalogService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/catalog-designer")
public class CatalogDesignerController {
	
	@Autowired
	private CatalogService catalogService;
	
	// Update an existing catalog item
	@PutMapping("/{id}")
	public ResponseEntity<CatalogItem> updateCatalogItem(@PathVariable String id, @RequestBody CatalogItem catalogItem) {
	    System.out.println("Received CatalogItem: " + catalogItem);
	    CatalogItem updatedItem = catalogService.updateCatalogItem(id, catalogItem);
	    return ResponseEntity.ok(updatedItem);
	}
}

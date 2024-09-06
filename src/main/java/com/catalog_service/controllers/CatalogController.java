package com.catalog_service.controllers;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catalog_service.Model.CatalogItem;
import com.catalog_service.Model.TechnicalCapability;
import com.catalog_service.services.CatalogService;
import com.catalog_service.services.TechnicalCapabilityService;


@RestController
@RequestMapping(value = "/api/catalog", method = RequestMethod.GET)
public class CatalogController {

	@Autowired
    private final CatalogService catalogService;
	
	 @Autowired
	 private TechnicalCapabilityService technicalCapabilityService;
    
    
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }
    
    @GetMapping
    public ResponseEntity<List<CatalogItem>> getCatlogItem(){
    	
    	List<CatalogItem>Items=catalogService.getAllCatalogItems();
    	return ResponseEntity.ok(Items);
    }
    
   
    
    @GetMapping("/{id}")
    public ResponseEntity<CatalogItem> getCatlogItemById(@PathVariable String id) {
        
    	Optional<CatalogItem> item= catalogService.getCatalogItemById(id);
    	
    	return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("/")
    public ResponseEntity<CatalogItem> addCatalogItem(@RequestBody CatalogItem catalogItem) {
        CatalogItem createdItem = catalogService.addCatalogItem(catalogItem);
        return ResponseEntity.ok(createdItem);
    }
    
 // Update an existing catalog item
    @PutMapping("/{id}")
    public ResponseEntity<CatalogItem> updateCatalogItem(@PathVariable String id, @RequestBody CatalogItem catalogItem) {
        CatalogItem updatedItem = catalogService.updateCatalogItem(id, catalogItem);
        return ResponseEntity.ok(updatedItem);
    }
    
 // Delete a catalog item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatalogItem(@PathVariable String id) {
        catalogService.deleteCatalogItem(id);
        return ResponseEntity.noContent().build();
    }
    
   

    @PostMapping("/link-capability")
    public CatalogItem linkCapabilityToItem(@RequestParam String networkElementId, @RequestBody CatalogItem item) {
        TechnicalCapability capability = technicalCapabilityService.discoverCapability(networkElementId);
        return technicalCapabilityService.linkCapability(item, capability);
    }

	
}

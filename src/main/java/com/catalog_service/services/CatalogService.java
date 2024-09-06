package com.catalog_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog_service.Model.CatalogItem;
import com.catalog_service.repository.CatalogRepository;

@Service
public class CatalogService {
	
	@Autowired
    private final CatalogRepository catalogRepository;
    
    
    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }
    
    public List<CatalogItem> getAllCatalogItems() {
        return catalogRepository.findAll();
    }
    
    public Optional<CatalogItem> getCatalogItemById(String id) {
        return catalogRepository.findById(id);
    }
    
    public CatalogItem addCatalogItem(CatalogItem catalogItem) {
        return catalogRepository.save(catalogItem);
    }
    
    public CatalogItem updateCatalogItem(String id, CatalogItem catalogItem) {
        // Fetch the existing CatalogItem from the database
        Optional<CatalogItem> existingItemOpt = catalogRepository.findById(id);
        
        if (existingItemOpt.isPresent()) {
            CatalogItem existingItem = existingItemOpt.get();
            
            // Only update fields that are not null in the incoming catalogItem
            if (catalogItem.getName() != null) {
                existingItem.setName(catalogItem.getName());
            }
            if (catalogItem.getDescription() != null) {
                existingItem.setDescription(catalogItem.getDescription());
            }
            if (catalogItem.getPrice() != null) {
                existingItem.setPrice(catalogItem.getPrice());
            }
            if (catalogItem.getCategory() != null) {
                existingItem.setCategory(catalogItem.getCategory());
            }
            if (catalogItem.getCapabilities() != null) {
                existingItem.setCapabilities(catalogItem.getCapabilities());
            }
            if (catalogItem.getState() != null) {
                existingItem.setState(catalogItem.getState());
            }
            if (catalogItem.getType() != null) {
                existingItem.setType(catalogItem.getType());
            }
            if (catalogItem.getChildIds() != null) {
                existingItem.setChildIds(catalogItem.getChildIds());
            }
            
            // Save the updated CatalogItem back to the database
            return catalogRepository.save(existingItem);
        } else {
            throw new RuntimeException("CatalogItem with id " + id + " not found");
        }
    }

    
    public void deleteCatalogItem(String id) {
        catalogRepository.deleteById(id);
    }
}
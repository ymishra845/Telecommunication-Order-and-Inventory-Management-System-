package com.catalog_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog_service.Model.CatalogItem;
import com.catalog_service.Model.LifeCycleState;
import com.catalog_service.repository.CatalogRepository;

@Service
public class CatalogLifeCycleService {
	
	@Autowired
	private CatalogRepository catalogRepository;
	
    public CatalogItem transitionState(CatalogItem item, LifeCycleState newState) {
        item.setState(newState);
        return catalogRepository.save(item);
    }
}
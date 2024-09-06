package com.catalog_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.catalog_service.Model.CatalogItem;

@Repository
public interface CatalogRepository extends MongoRepository<CatalogItem, String> {
    // Additional query methods can be defined here if needed
}

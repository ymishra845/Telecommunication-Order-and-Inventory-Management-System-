package com.catalog_service.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.catalog_service.Model.CatalogItem;

@Service
public class ServiceModelService {

    public String createServiceModel(CatalogItem cfs, List<CatalogItem> rfss) {
        if (isAllowedCategory(cfs.getCategory())) {
            List<String> rfsIds = rfss.stream()
                                      .map(CatalogItem::getId)
                                      .collect(Collectors.toList());

            cfs.setChildIds(rfsIds);
            // Logic to save the CFS with its child RFSs in the database could be added here if using a repository.

            return "Order can be proceeded.";
        } else {
            return "Choose different services.";
        }
    }

    private boolean isAllowedCategory(CatalogItem.Category category) {
        return category == CatalogItem.Category.IPTV ||
               category == CatalogItem.Category.INTERNET ||
               category == CatalogItem.Category.VOICE_OVER_IP;
    }
}
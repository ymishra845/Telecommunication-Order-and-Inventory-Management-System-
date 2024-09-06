package com.catalog_service.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.catalog_service.Model.CatalogItem;
import com.catalog_service.Model.TechnicalCapability;

@Service
public class TechnicalCapabilityService {

    // Hardcoded capabilities
    private static final Map<String, TechnicalCapability> capabilities = new HashMap<>();

    static {
        capabilities.put("1", new TechnicalCapability("1", "GPON", "Gigabit-capable Passive Optical Networks"));
        capabilities.put("2", new TechnicalCapability("2", "Internet", "High-speed Internet access"));
        capabilities.put("3", new TechnicalCapability("3", "VoIP", "Voice over IP service"));
    }

    /**
     * Discover technical capabilities by network element ID.
     * 
     * @param networkElementId The ID of the network element.
     * @return The discovered TechnicalCapability.
     */
    public TechnicalCapability discoverCapability(String networkElementId) {
        // Logic to discover technical capabilities using NEI SDK
        // For simplicity, returning a capability based on the networkElementId.
        // In a real-world scenario, this would involve complex logic and SDK calls.
        
        switch (networkElementId) {
            case "NE-GPON":
                return capabilities.get("1"); // GPON
            case "NE-Internet":
                return capabilities.get("2"); // Internet
            case "NE-VoIP":
                return capabilities.get("3"); // VoIP
            default:
                throw new IllegalArgumentException("Unknown Network Element ID: " + networkElementId);
        }
    }

    /**
     * Link a discovered capability to a catalog item.
     * 
     * @param item The CatalogItem to link.
     * @param capability The TechnicalCapability to link to the item.
     * @return The updated CatalogItem with the linked capability.
     */
    public CatalogItem linkCapability(CatalogItem item, TechnicalCapability capability) {
        if (item.getCapabilities() == null) {
            item.setCapabilities(new HashMap<>());
        }
        item.getCapabilities().put(capability.getId(), capability.getName());
        return item;
    }
}

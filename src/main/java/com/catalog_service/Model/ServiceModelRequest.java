package com.catalog_service.Model;

import com.catalog_service.Model.CatalogItem;
import java.util.List;

public class ServiceModelRequest {
    private CatalogItem cfs;
    private List<CatalogItem> rfss;

    // Getters and Setters
    public CatalogItem getCfs() {
        return cfs;
    }

    public void setCfs(CatalogItem cfs) {
        this.cfs = cfs;
    }

    public List<CatalogItem> getRfss() {
        return rfss;
    }

    public void setRfss(List<CatalogItem> rfss) {
        this.rfss = rfss;
    }
}


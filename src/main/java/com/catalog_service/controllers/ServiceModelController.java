package com.catalog_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog_service.Model.CatalogItem;
import com.catalog_service.Model.ServiceModelRequest;
import com.catalog_service.services.ServiceModelService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/service-model")
public class ServiceModelController {

    @Autowired
    private ServiceModelService serviceModelService;

    @PostMapping("/create")
    public ResponseEntity<String> createServiceModel(@RequestBody ServiceModelRequest request) {
        if (request.getCfs() == null) {
            return ResponseEntity.badRequest().body("CFS cannot be null.");
        }
        String message = serviceModelService.createServiceModel(request.getCfs(), request.getRfss());
        return ResponseEntity.ok(message);
    }

}

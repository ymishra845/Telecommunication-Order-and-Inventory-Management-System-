package com.catalog_service.Model;


import java.math.BigDecimal;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "catalog")
@Data
public class CatalogItem {
 
	
	public enum Category {
        IPTV, INTERNET, VOICE_OVER_IP
    }
	
 @Id
 private String id;
 private String name;
 private Map<String, String> capabilities; // Key: Capability ID, Value: Capability Name
 private LifeCycleState state;
 private String type;
 private List<String> childIds;
 public List<String> getChildIds() {
	return childIds;
}
public void setChildIds(List<String> childIds) {
	this.childIds = childIds;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public CatalogItem(String id, String name, Map<String, String> capabilities, LifeCycleState state, String description,
		BigDecimal price, Category category) {
	super();
	this.id = id;
	this.name = name;
	this.capabilities = capabilities;
	this.state = state;
	this.description = description;
	this.price = price;
	this.category = category;
}
public LifeCycleState getState() {
	return state;
}
public void setState(LifeCycleState state) {
	this.state = state;
}
public CatalogItem(Map<String, String> capabilities) {
	super();
	this.capabilities = capabilities;
}
public Map<String, String> getCapabilities() {
	return capabilities;
}
public void setCapabilities(Map<String, String> capabilities) {
	this.capabilities = capabilities;
}
public CatalogItem() {
	super();
	// TODO Auto-generated constructor stub
}
public CatalogItem(String id, String name, String description, BigDecimal price, Category category) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
	this.category = category;
}
@Override
public String toString() {
	return "CatalogItem [id=" + id + ", name=" + name + ", capabilities=" + capabilities + ", state=" + state
			+ ", type=" + type + ", childIds=" + childIds + ", description=" + description + ", price=" + price
			+ ", category=" + category + "]";
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
private String description;
 private BigDecimal price;
 private Category category;
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}

}


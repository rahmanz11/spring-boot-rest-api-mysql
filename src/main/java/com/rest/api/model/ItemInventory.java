package com.rest.api.model;

import javax.persistence.*;

@Entity
@Table(name = "item_inventory")
public class ItemInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer itemNumber;
    private Integer pricePerUnit;
    private Integer availableUnits;
    private Integer weightPerUnitInKg;

    public ItemInventory() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Integer getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Integer pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Integer getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(Integer availableUnits) {
        this.availableUnits = availableUnits;
    }

    public Integer getWeightPerUnitInKg() {
        return weightPerUnitInKg;
    }

    public void setWeightPerUnitInKg(Integer weightPerUnitInKg) {
        this.weightPerUnitInKg = weightPerUnitInKg;
    }
    
}

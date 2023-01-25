package com.rest.api.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item_inventory")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer itemNumber;
    private Integer pricePerUnit;
    private Integer availableUnits;
    private Integer weightPerUnitInKg;
}

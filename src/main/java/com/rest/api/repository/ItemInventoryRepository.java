package com.rest.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.model.ItemInventory;

public interface ItemInventoryRepository extends JpaRepository<ItemInventory, Long> {
    Optional<ItemInventory> findByItemNumber(Integer itemNumber);
}

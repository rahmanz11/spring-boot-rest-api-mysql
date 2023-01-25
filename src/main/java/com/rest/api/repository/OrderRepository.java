package com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}

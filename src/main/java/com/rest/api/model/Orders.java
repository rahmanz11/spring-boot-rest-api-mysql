package com.rest.api.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer itemNumber;
    private Integer orderQuantity;
    private LogisticsCompany logisticsCompany;
    private Integer shippingCostSubtotal;
    private Integer total;

    public Orders() {}

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
    public Integer getOrderQuantity() {
        return orderQuantity;
    }
    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
    public LogisticsCompany getLogisticsCompany() {
        return logisticsCompany;
    }
    public void setLogisticsCompany(LogisticsCompany logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }
    public Integer getShippingCostSubtotal() {
        return shippingCostSubtotal;
    }
    public void setShippingCostSubtotal(Integer shippingCostSubtotal) {
        this.shippingCostSubtotal = shippingCostSubtotal;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
}
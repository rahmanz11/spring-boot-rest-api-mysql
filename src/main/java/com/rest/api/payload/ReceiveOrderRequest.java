package com.rest.api.payload;

import com.rest.api.model.LogisticsCompany;

public class ReceiveOrderRequest {
    private Integer itemNumber;
    private Integer orderQuantity;
    private LogisticsCompany logisticsCompany;

    public ReceiveOrderRequest() {}

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

    
}
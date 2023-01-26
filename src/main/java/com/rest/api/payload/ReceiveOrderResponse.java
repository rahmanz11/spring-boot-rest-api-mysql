package com.rest.api.payload;

public class ReceiveOrderResponse {
    private Integer shippingCostSubTotal;
    private Integer total;

    public ReceiveOrderResponse() {}

    public Integer getShippingCostSubTotal() {
        return shippingCostSubTotal;
    }

    public void setShippingCostSubTotal(Integer shippingCostSubTotal) {
        this.shippingCostSubTotal = shippingCostSubTotal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    
}

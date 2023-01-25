package com.rest.api.payload;

import com.rest.api.model.LogisticsCompany;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ReceiveOrderRequest {
    private Integer itemNumber;
    private Integer orderQuantity;
    private LogisticsCompany logisticsCompany;
}
package com.rest.api.payload;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReceiveOrderResponse {
    private Integer shippingCostSubTotal;
    private Integer total;
}

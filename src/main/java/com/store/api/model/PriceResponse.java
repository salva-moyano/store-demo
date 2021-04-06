package com.store.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PriceResponse {
    private int brandId;
    private String startDate;
    private String endDate;
    private int priceList;
    private int productId;
    private double finalPrice;
}

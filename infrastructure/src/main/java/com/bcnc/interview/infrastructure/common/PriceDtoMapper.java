package com.bcnc.interview.infrastructure.common;

import com.bcnc.interview.domain.model.Price;
import com.bcnc.interview.infrastructure.out.dtos.GetPriceInfoResponse;

/**
 * Class with a method that allows converting from DTO to Price domain model
 */
public class PriceDtoMapper {

    public static GetPriceInfoResponse domainToResponse(Price price) {
        if (price == null) {
            return null;
        }
        return GetPriceInfoResponse.builder()
                .productId(price.getProductId().toString())
                .brandId(price.getBrandId().toString())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice())
                .build();
    }

}

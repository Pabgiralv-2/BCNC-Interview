package com.bcnc.interview.infrastructure.out.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO with the outgoing fields from the endpoint required
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPriceInfoResponse {

    private String productId;
    private String brandId;
    private Long priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;

}
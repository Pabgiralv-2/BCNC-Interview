package com.bcnc.interview.infrastructure.in.rest.dtos;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO with the incoming fields from the endpoint required
 */
@Data
public class GetPriceInfoRequest {

    private LocalDateTime applicationDate;
    private Long productId;
    private Long brandId;

}
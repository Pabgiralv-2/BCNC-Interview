package com.bcnc.interview.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Price domain model
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Price {

  private Long id;
  private Long brandId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Long priceList;
  private Long productId;
  private String priority;
  private BigDecimal price;
  private String currency;

}

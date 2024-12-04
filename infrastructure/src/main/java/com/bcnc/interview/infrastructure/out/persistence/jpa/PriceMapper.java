package com.bcnc.interview.infrastructure.out.persistence.jpa;

import com.bcnc.interview.domain.model.Price;

/**
 * Maps the domain model Price to PriceEntity.
 */
final class PriceMapper {

  private PriceMapper() {}

  static Price toModelEntity(PriceEntity jpaEntity) {
    return Price.builder()
            .id(jpaEntity.getId())
            .brandId(jpaEntity.getBrandId())
            .startDate(jpaEntity.getStartDate())
            .endDate(jpaEntity.getEndDate())
            .priceList(jpaEntity.getPriceList())
            .productId(jpaEntity.getProductId())
            .priority(jpaEntity.getPriority())
            .price(jpaEntity.getPrice())
            .currency(jpaEntity.getCurrency())
            .build();
  }

}

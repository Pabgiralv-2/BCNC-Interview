package com.bcnc.interview.infrastructure.out.persistence.jpa;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;

/**
 * Entity Price class.
 */
@Entity
@Table(name = "PRICES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long brandId;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Long priceList;

  private Long productId;

  private String priority;

  private BigDecimal price;

  @Column(name = "CURR")
  private String currency;

}

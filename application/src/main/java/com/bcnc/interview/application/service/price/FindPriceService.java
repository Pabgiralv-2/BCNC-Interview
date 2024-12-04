package com.bcnc.interview.application.service.price;

import com.bcnc.interview.application.port.in.FindPriceUseCase;
import com.bcnc.interview.application.port.out.persistence.PriceRepository;
import com.bcnc.interview.domain.model.Price;

import java.time.LocalDateTime;

/**
 * Implements the given use case
 */
public class FindPriceService implements FindPriceUseCase {

  private final PriceRepository productRepository;

  public FindPriceService(PriceRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Price getPriceInfoByParams(LocalDateTime applicationDate, Long productId, Long brandId) {
    return productRepository.findByProductIdAndBrandIdAndDateRange(productId, brandId, applicationDate);
  }

}

package com.bcnc.interview.application.port.out.persistence;

import com.bcnc.interview.domain.model.Price;

import java.beans.JavaBean;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Persistence port that abstracts data access. It has the method needed, but it could have more methods
 */
public interface PriceRepository {

  Price findByProductIdAndBrandIdAndDateRange(Long productId, Long brandId, LocalDateTime applicationDate);

}

package com.bcnc.interview.application.port.in;

import com.bcnc.interview.domain.model.Price;

import java.time.LocalDateTime;

/**
 * Interface defining the use case of finding a price by given the parameters. The price found has to match
 * the productId, brandId and the applicationDate given as a parameters has to be between its startDate and
 * endDate. If more than one product are found, the one with the max priority will be returned.
 */
public interface FindPriceUseCase {

  Price getPriceInfoByParams(LocalDateTime applicationDate, Long productId, Long brandId);
}

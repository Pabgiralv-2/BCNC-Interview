package com.bcnc.interview.infrastructure.out.persistence.jpa;

import com.bcnc.interview.application.port.out.persistence.PriceRepository;
import com.bcnc.interview.domain.model.Price;
import com.bcnc.interview.infrastructure.out.exceptions.PriceNotFoundException;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * Persistence adapter: Uses the JPA repository to perform the query needed
 */

@Slf4j
@Repository
public class JpaPriceRepository implements PriceRepository {

    private final JpaPriceSpringDataRepository springDataRepository;

    public JpaPriceRepository(JpaPriceSpringDataRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Price findByProductIdAndBrandIdAndDateRange(Long productId, Long brandId, LocalDateTime applicationDate) {

        log.info("JpaPriceRepository - findByProductIdAndBrandIdAndDateRange - INPUT - Parameters: applicationDate={}, productId={}, brandId={}",
                applicationDate, productId, brandId);

        PriceEntity response = springDataRepository.findProductsByParameters(productId, brandId, applicationDate).orElseThrow(PriceNotFoundException::new);

        log.info("JpaPriceRepository - findByProductIdAndBrandIdAndDateRange - OUTPUT - Returning response with data: productId={}, price={}, startDate={}, endDate={}",
                response.getProductId(), response.getPrice(), response.getStartDate(), response.getEndDate());

        return PriceMapper.toModelEntity(response);
    }
}

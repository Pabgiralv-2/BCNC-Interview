package com.bcnc.interview.infrastructure.out.persistence.jpa;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * PriceEntity JPA repository.
 */
@Repository
public interface JpaPriceSpringDataRepository extends JpaRepository<PriceEntity, String> {

    /**
     * This query retrieves the price that given a productId and brandId both match one on DB and it also finds those
     * in which the given applicationDate is between the startDate and endDate. Then, it orders the results obtained
     * on DESC based on their priority and limits it to 1, so if there are more than one prices, it will only take the
     * one with the max priority
     */
    @Query(value = """
            SELECT *
            FROM PRICES
            WHERE PRODUCT_ID = :productId
              AND BRAND_ID = :brandId
              AND :applicationDate BETWEEN START_DATE AND END_DATE
            ORDER BY CAST(PRIORITY AS INT) DESC
            LIMIT 1
            """, nativeQuery = true)
    Optional<PriceEntity> findProductsByParameters(
            Long productId,
            Long brandId,
            LocalDateTime applicationDate
    );
}

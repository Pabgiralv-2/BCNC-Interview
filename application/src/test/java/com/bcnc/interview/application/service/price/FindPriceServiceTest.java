package com.bcnc.interview.application.service.price;

import com.bcnc.interview.application.port.out.persistence.PriceRepository;
import com.bcnc.interview.domain.model.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * PriceService.java test. Assures its proper functioning
 */
@ExtendWith(MockitoExtension.class)
public class FindPriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private FindPriceService priceService;

    private LocalDateTime applicationDate;
    private Long productId;
    private Long brandId;
    private Price price;

    @BeforeEach
    void setUp() {
        applicationDate = LocalDateTime.of(2020, 6, 14, 15, 30, 0, 0);
        productId = 35455L;
        brandId = 1L;

        price = new Price();
        price.setPriceList(1L);
        price.setProductId(productId);
        price.setBrandId(brandId);
        price.setPrice(BigDecimal.valueOf(25.45));
        price.setCurrency("EUR");
    }

    @Test
    void testGetPriceInfoByParam() {
        when(priceRepository.findByProductIdAndBrandIdAndDateRange(productId, brandId, applicationDate))
                .thenReturn(price);

        Price result = priceService.getPriceInfoByParams(applicationDate, productId, brandId);

        assertNotNull(result);
        assertEquals(productId, result.getProductId());
        assertEquals(brandId, result.getBrandId());
        assertEquals(BigDecimal.valueOf(25.45), result.getPrice());
        assertEquals("EUR", result.getCurrency());

        verify(priceRepository, times(1)).findByProductIdAndBrandIdAndDateRange(productId, brandId, applicationDate);
    }

}

package com.bcnc.interview.infrastructure.integration;

import com.bcnc.interview.infrastructure.in.rest.dtos.GetPriceInfoRequest;
import com.bcnc.interview.infrastructure.out.exceptions.NegativeValueNotAllowedException;
import com.bcnc.interview.infrastructure.out.exceptions.PriceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * This Test performs the requests asked on the test to the given endpoint. It creates the whole Spring context to make
 * sure every component is working the right way. This test also uses its own properties, and it loads its own data on DB
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test1() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.of(2020,6,14,10,0,0);

        mockMvc.perform(get("/products/search")
                        .param("applicationDate", String.valueOf(applicationDate))
                        .param("productId", String.valueOf(35455L))
                        .param("brandId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1L))
                .andExpect(jsonPath("$.productId").value(35455L))
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"));
    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test2() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.of(2020,6,14,16,0,0);

        mockMvc.perform(get("/products/search")
                        .param("applicationDate", String.valueOf(applicationDate))
                        .param("productId", String.valueOf(35455L))
                        .param("brandId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(2L))
                .andExpect(jsonPath("$.productId").value(35455L))
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00"));
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test3() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.of(2020,6,14,21,0,0);

        mockMvc.perform(get("/products/search")
                        .param("applicationDate", String.valueOf(applicationDate))
                        .param("productId", String.valueOf(35455L))
                        .param("brandId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1L))
                .andExpect(jsonPath("$.productId").value(35455L))
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"));
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test4() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.of(2020,6,15,10,0,0);

        mockMvc.perform(get("/products/search")
                        .param("applicationDate", String.valueOf(applicationDate))
                        .param("productId", String.valueOf(35455L))
                        .param("brandId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(3L))
                .andExpect(jsonPath("$.productId").value(35455L))
                .andExpect(jsonPath("$.price").value(30.50))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00"));
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test5() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.of(2020,6,16,21,0,0);

        mockMvc.perform(get("/products/search")
                        .param("applicationDate", String.valueOf(applicationDate))
                        .param("productId", String.valueOf(35455L))
                        .param("brandId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(4L))
                .andExpect(jsonPath("$.productId").value(35455L))
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"));
    }

    // Test checking that PriceNotFoundException is thrown correctly
    @Test
    void testGetPriceInfoByParams_NotFound() throws Exception {

        PriceNotFoundException priceNotFoundException = new PriceNotFoundException();

        // Request with data that does not exit on DB
        mockMvc.perform(get("/products/search")
                        .param("applicationDate", String.valueOf(LocalDateTime.now()))
                        .param("productId", String.valueOf(35455L))
                        .param("brandId", String.valueOf(1L)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(priceNotFoundException.getMessage()))
                .andExpect(jsonPath("$.title").value(priceNotFoundException.getTitle()));
    }

    // Test checking that NegativeValueNotAllowedException is thrown correctly
    @Test
    void testGetPriceInfoByParams_NegativeValue() throws Exception {

        NegativeValueNotAllowedException exception = new NegativeValueNotAllowedException("brandId");

        mockMvc.perform(get("/products/search")
                        .param("applicationDate", String.valueOf(LocalDateTime.now()))
                        .param("productId", String.valueOf(35455L))
                        .param("brandId", String.valueOf(-1)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(exception.getMessage()))
                .andExpect(jsonPath("$.title").value(exception.getTitle()));
    }

    // Test checking that the exception 400 is managed properly
    @Test
    void testGetPriceInfoByParams_BadRequest() throws Exception {

        String wrongDate = "2020-06-14T16:00:0"; //Its missing one 0 at the end

        mockMvc.perform(get("/products/search")
                        .param("applicationDate", wrongDate)
                        .param("productId", String.valueOf(35455L))
                        .param("brandId", String.valueOf(1)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Failed to convert 'applicationDate' with value: '2020-06-14T16:00:0'"))
                .andExpect(jsonPath("$.title").value("400 BAD_REQUEST"));
    }
}
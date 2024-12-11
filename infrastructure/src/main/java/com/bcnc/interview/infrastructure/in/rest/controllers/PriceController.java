package com.bcnc.interview.infrastructure.in.rest.controllers;

import com.bcnc.interview.application.port.in.FindPriceUseCase;
import com.bcnc.interview.domain.model.Price;

import com.bcnc.interview.infrastructure.out.dtos.GetPriceInfoResponse;
import com.bcnc.interview.infrastructure.common.PriceDtoMapper;
import com.bcnc.interview.infrastructure.out.exceptions.NegativeValueNotAllowedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * REST controller for the endpoint required.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class PriceController {

    private final FindPriceUseCase findProductsUseCase;

    @GetMapping("/search")
    public ResponseEntity<GetPriceInfoResponse> getPriceInfoByParams(@RequestParam LocalDateTime applicationDate,
                                                                     @RequestParam Long productId,
                                                                     @RequestParam Long brandId) {

        if(productId <= 0){
            throw new NegativeValueNotAllowedException("productId");
        } else if (brandId <= 0){
            throw new NegativeValueNotAllowedException("brandId");
        }

        Price price = findProductsUseCase.getPriceInfoByParams(applicationDate, productId, brandId);

        return new ResponseEntity<>(PriceDtoMapper.domainToResponse(price), HttpStatus.OK);
    }

}

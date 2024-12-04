package com.bcnc.interview.infrastructure.in.rest.controllers;

import com.bcnc.interview.application.port.in.FindPriceUseCase;
import com.bcnc.interview.domain.model.Price;

import com.bcnc.interview.infrastructure.in.rest.dtos.GetPriceInfoRequest;
import com.bcnc.interview.infrastructure.out.dtos.GetPriceInfoResponse;
import com.bcnc.interview.infrastructure.common.PriceDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for the endpoint required.
 */
@RestController
@RequestMapping("/products")
@Slf4j
public class PriceController {

  private final FindPriceUseCase findProductsUseCase;

  public PriceController(FindPriceUseCase findProductsUseCase) {
    this.findProductsUseCase = findProductsUseCase;
  }

  @GetMapping("/search")
  public ResponseEntity<GetPriceInfoResponse> getPriceInfoByParams(@RequestBody GetPriceInfoRequest request) {

    log.info("PriceController - getPriceInfoByParams - INPUT - Received request with data: applicationDate={}, productId={}, brandId={}",
            request.getApplicationDate(), request.getProductId(), request.getBrandId());

    Price price = findProductsUseCase.getPriceInfoByParams(request.getApplicationDate(), request.getProductId(), request.getBrandId());

    log.info("PriceController - getPriceInfoByParams - OUTPUT - Returning response with data: productId={}, price={}",
            price.getProductId(), price.getPrice());

    return new ResponseEntity<>(PriceDtoMapper.domainToResponse(price), HttpStatus.OK);
  }

}

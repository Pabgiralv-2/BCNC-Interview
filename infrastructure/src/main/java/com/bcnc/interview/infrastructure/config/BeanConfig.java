package com.bcnc.interview.infrastructure.config;

import com.bcnc.interview.application.port.in.FindPriceUseCase;
import com.bcnc.interview.application.port.out.persistence.PriceRepository;
import com.bcnc.interview.application.service.price.FindPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class, it creates the necessary Spring Beans from the service defined in the application module
 */
@Configuration
public class BeanConfig {

  @Autowired
  PriceRepository priceRepository;

  @Bean
  FindPriceUseCase findPriceUseCase() {
    return new FindPriceService(priceRepository);
  }

}

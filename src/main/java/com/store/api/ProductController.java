package com.store.api;

import com.store.api.model.ErrorResponse;
import com.store.api.model.PriceResponse;
import com.store.business.PriceService;
import com.store.business.exception.PriceNotFoundException;
import com.store.business.exception.StoreException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    static final String FORMAT_DATE = "yyyy-MM-dd HH:mm";

    private final PriceService priceService;

    @GetMapping(value="/details")
    private ResponseEntity<PriceResponse> findByCriteria(@RequestParam String dateRange,
                                                                @RequestParam int productId,
                                                                @RequestParam int brandId) throws StoreException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        LocalDateTime dateTime = LocalDateTime.parse(dateRange, formatter);
        PriceResponse pricesResponse =priceService.getProduct(dateTime, productId, brandId);
        return new ResponseEntity<>(pricesResponse, HttpStatus.OK);
    }

    @ExceptionHandler(PriceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlePriceNotFoundException(PriceNotFoundException e) {
        log.error("[Product] Error caused by: {}", e.getMessage());
        return ErrorResponse.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .message(e.getMessage())
                            .build();
    }


    @ExceptionHandler(StoreException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleStoreException(StoreException e) {
        log.error("[Product] Error caused by: {}", e.getMessage());
        return ErrorResponse.builder()
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .message(e.getMessage())
                            .build();
    }

}

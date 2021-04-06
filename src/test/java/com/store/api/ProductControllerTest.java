package com.store.api;

import com.store.StoreApplication;
import com.store.api.model.PriceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = StoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    static final String FORMAT_DATE = "yyyy-MM-dd HH:mm";

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    void test1(){
        String startTimeString = "2020-06-14 00:00:00";
        String endTimeString = "2020-12-31 23:59:59";
        PriceResponse pricesResponse = PriceResponse.builder()
                                                    .brandId(1)
                                                    .startDate(startTimeString)
                                                    .endDate(endTimeString)
                                                    .priceList(1)
                                                    .productId(35455)
                                                    .finalPrice(35.50)
                                                    .build();
        ResponseEntity<PriceResponse> response = testRestTemplate.getForEntity(
                "/product/details?dateRange=2020-06-14 10:00&productId=35455&brandId=1", PriceResponse.class);

        assertEquals(pricesResponse.getBrandId(), response.getBody().getBrandId());
        assertEquals(pricesResponse.getProductId(), response.getBody().getProductId());
        assertEquals(pricesResponse.getStartDate(), response.getBody().getStartDate());
        assertEquals(pricesResponse.getEndDate(), response.getBody().getEndDate());
        assertEquals(pricesResponse.getFinalPrice(), response.getBody().getFinalPrice());

    }

    @Test
    void test2() {
        String startTimeString = "2020-06-14 15:00:00";
        String endTimeString = "2020-06-14 18:30:00";
        PriceResponse pricesResponse = PriceResponse.builder()
                                                    .brandId(1)
                                                    .startDate(startTimeString)
                                                    .endDate(endTimeString)
                                                    .priceList(1)
                                                    .productId(35455)
                                                    .finalPrice(25.45)
                                                    .build();

        ResponseEntity<PriceResponse> response = testRestTemplate.getForEntity(
                "/product/details?dateRange=2020-06-14 16:00 &productId=35455&brandId=1", PriceResponse.class);

        assertEquals(pricesResponse.getBrandId(), response.getBody().getBrandId());
        assertEquals(pricesResponse.getProductId(), response.getBody().getProductId());
        assertEquals(pricesResponse.getStartDate(), response.getBody().getStartDate());
        assertEquals(pricesResponse.getEndDate(), response.getBody().getEndDate());
        assertEquals(pricesResponse.getFinalPrice(), response.getBody().getFinalPrice());

    }

    @Test
    void test3() {
        String startTimeString = "2020-06-14 00:00:00";
        String endTimeString = "2020-12-31 23:59:59";
        PriceResponse pricesResponse = PriceResponse.builder()
                                                    .brandId(1)
                                                    .startDate(startTimeString)
                                                    .endDate(endTimeString)
                                                    .priceList(1)
                                                    .productId(35455)
                                                    .finalPrice(35.50)
                                                    .build();

        ResponseEntity<PriceResponse> response = testRestTemplate.getForEntity(
                "/product/details?dateRange=2020-06-14 21:00 &productId=35455&brandId=1", PriceResponse.class);

        assertEquals(pricesResponse.getBrandId(), response.getBody().getBrandId());
        assertEquals(pricesResponse.getProductId(), response.getBody().getProductId());
        assertEquals(pricesResponse.getStartDate(), response.getBody().getStartDate());
        assertEquals(pricesResponse.getEndDate(), response.getBody().getEndDate());
        assertEquals(pricesResponse.getFinalPrice(), response.getBody().getFinalPrice());

    }

    @Test
    void test4() {
        String startTimeString = "2020-06-15 00:00:00";
        String endTimeString = "2020-06-15 11:00:00";
        PriceResponse pricesResponse = PriceResponse.builder()
                                                    .brandId(1)
                                                    .startDate(startTimeString)
                                                    .endDate(endTimeString)
                                                    .priceList(1)
                                                    .productId(35455)
                                                    .finalPrice(30.50)
                                                    .build();


        ResponseEntity<PriceResponse> response = testRestTemplate.getForEntity(
                "/product/details?dateRange=2020-06-15 10:00 &productId=35455&brandId=1", PriceResponse.class);

        assertEquals(pricesResponse.getBrandId(), response.getBody().getBrandId());
        assertEquals(pricesResponse.getProductId(), response.getBody().getProductId());
        assertEquals(pricesResponse.getStartDate(), response.getBody().getStartDate());
        assertEquals(pricesResponse.getEndDate(), response.getBody().getEndDate());
        assertEquals(pricesResponse.getFinalPrice(), response.getBody().getFinalPrice());

    }

    @Test
    void test5() {
        String startTimeString = "2020-06-15 16:00:00";
        String endTimeString = "2020-12-31 23:59:59";
        PriceResponse pricesResponse =  PriceResponse.builder()
                                                     .brandId(1)
                                                     .startDate(startTimeString)
                                                     .endDate(endTimeString)
                                                     .priceList(1)
                                                     .productId(35455)
                                                     .finalPrice(38.95)
                                                     .build();;

        ResponseEntity<PriceResponse> response = testRestTemplate.getForEntity(
                "/product/details?dateRange=2020-06-15 21:00 &productId=35455&brandId=1", PriceResponse.class);

        assertEquals(pricesResponse.getBrandId(), response.getBody().getBrandId());
        assertEquals(pricesResponse.getProductId(), response.getBody().getProductId());
        assertEquals(pricesResponse.getStartDate(), response.getBody().getStartDate());
        assertEquals(pricesResponse.getEndDate(), response.getBody().getEndDate());
        assertEquals(pricesResponse.getFinalPrice(), response.getBody().getFinalPrice());

    }
}
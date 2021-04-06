package com.store.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "PRICES")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    private BrandEntity brand;
    @Column(name="START_DATE")
    private LocalDateTime startDate;
    @Column(name="END_DATE")
    private LocalDateTime endDate;
    @Column(name="PRICE_LIST")
    private int priceList;
    @Column(name="PRODUCT_ID")
    private int productId;
    @Column(name="PRIORITY")
    private int priority;
    @Column(name="PRICE")
    private double price;
    @Column(name="CURR")
    private String curr;
}

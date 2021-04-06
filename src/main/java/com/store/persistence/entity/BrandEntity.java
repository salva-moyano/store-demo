package com.store.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@Table(name = "BRANDS")
public class BrandEntity {
    @Id
    @Column(name="BRAND_ID")
    private int id;
    private String name;
    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<PriceEntity> prices = new HashSet<>();
}

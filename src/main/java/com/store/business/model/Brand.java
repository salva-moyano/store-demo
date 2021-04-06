package com.store.business.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Brand {
    private int id;
    private String name;
}

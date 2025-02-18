package com.franquicia.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
    private String name;
    private Integer Stock;
}

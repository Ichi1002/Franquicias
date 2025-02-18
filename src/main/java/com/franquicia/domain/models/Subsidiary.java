package com.franquicia.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Subsidiary {
    private String subsidiatyName;
    List<Product> productsList;
}

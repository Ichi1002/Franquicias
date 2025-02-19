package com.franquicia.infrastructure.DTO;

import com.franquicia.domain.models.Product;
import lombok.Getter;

@Getter
public class SubsidiaryProductDto {
    private String franchiseName;
    private String subsidiaryName;
    private Product product;
}

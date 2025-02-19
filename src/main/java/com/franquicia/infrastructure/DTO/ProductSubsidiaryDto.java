package com.franquicia.infrastructure.DTO;

import com.franquicia.domain.models.Product;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductSubsidiaryDto {
    private String franchiseName;
    private String subsidiaryName;
    private List<Product> products;
}

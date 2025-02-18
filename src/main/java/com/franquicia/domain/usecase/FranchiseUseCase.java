package com.franquicia.domain.usecase;

import com.franquicia.domain.models.Franchise;
import com.franquicia.domain.models.Product;
import com.franquicia.domain.models.Subsidiary;

import java.util.List;
import java.util.Map;

public interface FranchiseUseCase {
    Franchise createFranchise(Franchise franchise);
    Franchise addSubsuduaryToFranchise(String franchiseName, String subsidiaryName);
    Subsidiary addProductToSubsidiary(String subsidiaryName, Product product);
    Subsidiary deleteProductOfSubsidiary(String subsidiaryName, String productName);
    Subsidiary modifyProductStockOfSubsidiary(String subsidiaryName, Product product);
    List<Map<String,Product>> getBiggerStickProductInSubsidiaryByFranchise(String franchiseName);

}

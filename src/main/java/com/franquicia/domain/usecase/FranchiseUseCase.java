package com.franquicia.domain.usecase;

import com.franquicia.domain.models.Franchise;
import com.franquicia.domain.models.Product;


import java.util.List;
import java.util.Map;

public interface FranchiseUseCase {
    Franchise createFranchise(Franchise franchise);
    Franchise addSubsuduaryToFranchise(String franchiseName, String subsidiaryName);
    List<Franchise> addProductToSubsidiary(String franchiseName,String subsidiaryName, List<Product> product);
    void deleteProductOfSubsidiary(String subsidiaryName, String productName);
    Franchise modifyProductStockOfSubsidiary(String franchiseName, String subsidiaryName, Product product);
    List<Map<String,Product>> getBiggerStickProductInSubsidiaryByFranchise(String franchiseName);

}

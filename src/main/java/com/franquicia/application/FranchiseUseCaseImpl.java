package com.franquicia.application;

import com.franquicia.domain.models.Franchise;
import com.franquicia.domain.models.Product;
import com.franquicia.domain.models.Subsidiary;
import com.franquicia.domain.usecase.FranchiseUseCase;
import com.franquicia.infrastructure.reposiroty.FranchiseRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class FranchiseUseCaseImpl implements FranchiseUseCase {

    private final FranchiseRepository franchiseRepository;
    @Override
    public Franchise createFranchise(Franchise franchise) {
        return null;
    }

    @Override
    public Franchise addSubsuduaryToFranchise(String franchiseName, Subsidiary subsidiary) {
        return null;
    }

    @Override
    public Subsidiary addProductToSubsidiary(String subsidiaryName, Product product) {
        return null;
    }

    @Override
    public Subsidiary deleteProductOfSubsidiary(String subsidiaryName, String productName) {
        return null;
    }

    @Override
    public Subsidiary modifyProductStockOfSubsidiary(String subsidiaryName, Product product) {
        return null;
    }

    @Override
    public List<Map<String, Product>> getBiggerStickProductInSubsidiaryByFranchise(String franchiseName) {
        return List.of();
    }
}

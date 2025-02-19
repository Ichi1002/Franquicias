package com.franquicia.application;

import com.franquicia.domain.models.Franchise;
import com.franquicia.domain.models.Product;
import com.franquicia.domain.usecase.FranchiseUseCase;
import com.franquicia.infrastructure.entity.FranchiseEntity;
import com.franquicia.infrastructure.entity.ProductEntity;
import com.franquicia.infrastructure.entity.SubsidiaryEntity;
import com.franquicia.infrastructure.reposiroty.FranchiseRepository;
import com.franquicia.infrastructure.reposiroty.ProductRepository;
import com.franquicia.infrastructure.reposiroty.SubsidiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FranchiseUseCaseImpl implements FranchiseUseCase {
    private final FranchiseRepository franchiseRepository;
    private final SubsidiaryRepository subsidiaryRepository;
    private final ProductRepository productRepository;

    @Override
    public Franchise createFranchise(Franchise franchise) {
        return franchiseRepository.save(FranchiseEntity.fromDomain(franchise)).toDomain();
    }

    @Override
    public Franchise addSubsuduaryToFranchise(String franchiseName, String subsidiaryName) {
        var franchise = franchiseRepository.findByNameIgnoreCase(franchiseName);
        if(franchise.isEmpty())
            throw new RuntimeException("Franquicia no Existe");
        var subsidiaryEntity = SubsidiaryEntity.builder()
                .name(subsidiaryName)
                .franchise(franchise.get())
                .build();
        return subsidiaryRepository.save(subsidiaryEntity).toFranchiseDomain();

    }

    @Override
    public List<Franchise> addProductToSubsidiary(String franchiseName,String subsidiaryName, List<Product> products) {
        var franchise = franchiseRepository.findByNameIgnoreCase(franchiseName);
        if(franchise.isEmpty())
            throw new RuntimeException("Franquicia no Existe");
        var subsidiary = subsidiaryRepository.findByNameIgnoreCase(subsidiaryName);
        if(subsidiary.isEmpty())
            throw new RuntimeException("Subsidiario no Existe");
        List<ProductEntity> productEntity = products.stream().map(product ->
                ProductEntity.builder()
                        .subsidiary(subsidiary.get())
                        .name(product.getProductName())
                        .stock(product.getStock())
                        .build())
                .collect(Collectors.toList());
        return productRepository.saveAll(productEntity)
                .stream().map(ProductEntity::toFranchiseDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProductOfSubsidiary(String subsidiaryName, String productName) {
        var subsidiary = subsidiaryRepository.findByNameIgnoreCase(subsidiaryName);
        if (subsidiary.isEmpty())
            throw new RuntimeException("Sucursal no existe");
        var product = productRepository.findByNameIgnoreCase(productName);
        if(product.isEmpty())
            throw new RuntimeException("Prodcuto no existe");

        productRepository.deleteById(product.get().getUuid());

    }

    @Override
    public Franchise modifyProductStockOfSubsidiary(String franchiseName, String subsidiaryName, Product product) {
        var franchise  = franchiseRepository.findByNameIgnoreCase(franchiseName);
        if (franchise.isEmpty())
            throw new RuntimeException("Franquicia no existe");
        var subsidiary = subsidiaryRepository.findByNameIgnoreCase(subsidiaryName);
        if (subsidiary.isEmpty())
            throw new RuntimeException("Sucursal no existe");
        var productFound = productRepository.findByNameIgnoreCase(product.getProductName());
        if(productFound.isEmpty())
            throw new RuntimeException("Prodcuto no existe");
        productFound.get().setStock(product.getStock());
        return productRepository.save(productFound.get()).toFranchiseDomain();

    }

    @Override
    public List<Map<String, Product>> getBiggerStickProductInSubsidiaryByFranchise(String franchiseName) {
        return List.of();
    }
}

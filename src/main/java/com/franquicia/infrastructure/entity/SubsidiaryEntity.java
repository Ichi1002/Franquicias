package com.franquicia.infrastructure.entity;

import com.franquicia.domain.models.Franchise;
import com.franquicia.domain.models.Product;
import com.franquicia.domain.models.Subsidiary;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubsidiaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subsidiary")
    List<ProductEntity> productsList;
    @ManyToOne
    @JoinColumn(name = "FK_FRANCHISE", nullable = false, updatable = false)
    private FranchiseEntity franchise;

    public static Subsidiary fromDomain(Subsidiary subsidiary){
        return Subsidiary.builder()
                .subsidiatyName(subsidiary.getSubsidiatyName())
                .productsList(subsidiary.getProductsList())
                .build();
    }

    public Subsidiary toDomain(){
        List<Product> productList = new ArrayList<>();
        if(this.productsList != null)
            if(!this.productsList.isEmpty())
                productList = this.productsList.stream()
                    .map(ProductEntity::toDomain)
                    .collect(Collectors.toList());
        return Subsidiary.builder()
                .subsidiatyName(this.name)
                .productsList(productList)
                .build();
    }

    public Franchise toFranchiseDomain(){
        return Franchise.builder()
                .franchiseName(this.getFranchise().getName())
                .subsidiaryList(this.getFranchise().getSubsidiaryList()
                        .stream()
                        .map(SubsidiaryEntity::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }
}

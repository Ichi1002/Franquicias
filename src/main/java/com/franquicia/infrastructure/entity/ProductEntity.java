package com.franquicia.infrastructure.entity;

import com.franquicia.domain.models.Franchise;
import com.franquicia.domain.models.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
import java.util.stream.Collectors;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "FK_Subsidiary", nullable = false, updatable = false)
    private SubsidiaryEntity subsidiary;

    public Product toDomain(){
        return Product.builder()
                .productName(this.name)
                .stock(this.stock)
                .build();
    }

    public Franchise toFranchiseDomain(){
        return Franchise.builder()
                .franchiseName(this.getSubsidiary().getFranchise().getName())
                .subsidiaryList(this.getSubsidiary().getFranchise().getSubsidiaryList()
                        .stream()
                        .map(SubsidiaryEntity::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }

}

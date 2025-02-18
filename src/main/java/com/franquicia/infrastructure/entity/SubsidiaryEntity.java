package com.franquicia.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
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
}

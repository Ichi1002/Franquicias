package com.franquicia.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private Integer Stock;
    @ManyToOne
    @JoinColumn(name = "FK_Subsidiary", nullable = false, updatable = false)
    private SubsidiaryEntity subsidiary;
}

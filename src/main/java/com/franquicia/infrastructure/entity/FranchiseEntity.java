package com.franquicia.infrastructure.entity;

import com.franquicia.domain.models.Franchise;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FranchiseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "franchise")
    private List<SubsidiaryEntity> subsidiaryList;

    public Franchise toDomain(){
    return Franchise.builder()
            .franchiseName(this.name)
            .build();
    }

    public static FranchiseEntity fromDomain(Franchise franchise){
        return FranchiseEntity.builder()
                .name(franchise.getFranchiseName())
                .build();
    }
}

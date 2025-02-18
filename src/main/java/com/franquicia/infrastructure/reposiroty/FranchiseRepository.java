package com.franquicia.infrastructure.reposiroty;

import com.franquicia.infrastructure.entity.FranchiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FranchiseRepository extends JpaRepository<FranchiseEntity, UUID> {
    Optional<FranchiseEntity> findByNameIgnoreCase(String name);
}

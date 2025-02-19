package com.franquicia.infrastructure.reposiroty;

import com.franquicia.infrastructure.entity.SubsidiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SubsidiaryRepository extends JpaRepository<SubsidiaryEntity, UUID> {
    Optional<SubsidiaryEntity> findByNameIgnoreCase(String name);
}

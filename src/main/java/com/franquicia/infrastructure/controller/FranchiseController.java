package com.franquicia.infrastructure.controller;

import com.franquicia.domain.models.Franchise;
import com.franquicia.domain.usecase.FranchiseUseCase;
import com.franquicia.infrastructure.DTO.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FranchiseController {
    private final FranchiseUseCase franchiseUseCase;

    @PostMapping
    public ResponseDto saveFranchise(@RequestBody Franchise franchise){
        return ResponseDto.builder()
                .data(franchiseUseCase.createFranchise(franchise))
                .message("OK")
                .status(200)
                .build();
    }

}

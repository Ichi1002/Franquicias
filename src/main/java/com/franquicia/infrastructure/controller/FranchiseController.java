package com.franquicia.infrastructure.controller;

import com.franquicia.domain.models.Franchise;
import com.franquicia.domain.usecase.FranchiseUseCase;
import com.franquicia.infrastructure.DTO.ProductSubsidiaryDto;
import com.franquicia.infrastructure.DTO.ResponseDto;
import com.franquicia.infrastructure.DTO.SubsidiaryFranchiseDto;
import com.franquicia.infrastructure.DTO.SubsidiaryProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/addSubsidiary")
    public ResponseDto addSubsidiarytoFranchise(@RequestBody SubsidiaryFranchiseDto dto){
        return ResponseDto.builder()
                .data(franchiseUseCase.addSubsuduaryToFranchise(dto.getFranchiseName(),dto.getSubsidiaryName()))
                .message("OK")
                .status(200)
                .build();
    }

    @PostMapping("/addProduct")
    public ResponseDto addProductToSubsidiary(@RequestBody ProductSubsidiaryDto dto){
        return ResponseDto.builder()
                .data(franchiseUseCase.addProductToSubsidiary(
                        dto.getFranchiseName(),dto.getSubsidiaryName(),dto.getProducts()))
                .message("OK")
                .status(200)
                .build();
    }

    @DeleteMapping("/deleteProduct")
    public ResponseDto deleteProductFromSubsidiary(@RequestBody SubsidiaryProductDto dto){
        franchiseUseCase.deleteProductOfSubsidiary(dto.getSubsidiaryName(),dto.getProduct().getProductName());
        return ResponseDto.builder()
                .data("Producto eliminado correctamente")
                .message("OK")
                .status(200)
                .build();
    }

    @PatchMapping("/updateStock")
    public ResponseDto updateStockProductFromSubsidiary(@RequestBody SubsidiaryProductDto dto){
        franchiseUseCase.modifyProductStockOfSubsidiary(dto.getFranchiseName(),dto.getSubsidiaryName(),dto.getProduct());
        return ResponseDto.builder()
                .data("Producto actualizado correctamente")
                .message("OK")
                .status(200)
                .build();
    }

    @GetMapping("/getMaxtock/{franchiseName}")
    public ResponseDto getMaxStockByFtranchiseAndSubsidiary(@PathVariable String franchiseName){

        return ResponseDto.builder()
                .data(franchiseUseCase.getBiggerStickProductInSubsidiaryByFranchise(franchiseName))
                .message("OK")
                .status(200)
                .build();
    }

}

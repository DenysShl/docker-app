package com.docker.dto.mapper;

import com.docker.dto.ProductRequestDto;
import com.docker.dto.ProductResponseDto;
import com.docker.model.Product;

public interface MapperDto {
    ProductResponseDto toDto(Product product);

    Product toModel(ProductRequestDto productRequestDto);
}

package com.docker.dto.mapper;

import com.docker.dto.ProductRequestDto;
import com.docker.dto.ProductResponseDto;
import com.docker.model.Product;
import org.springframework.stereotype.Component;

@Component
public class MapperDtoImpl implements MapperDto {
    @Override
    public ProductResponseDto toDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        return responseDto;
    }

    @Override
    public Product toModel(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setTitle(productRequestDto.getTitle());
        product.setPrice(productRequestDto.getPrice());
        return product;
    }
}

package com.docker.service;

import com.docker.model.Product;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.PageRequest;

public interface ProductService {
    Product create(Product product);

    Product getById(Long id);

    void deleteById(Long id);

    List<Product> findAll(PageRequest pageRequest);

    List<Product> getAllSortedWherePriceBetween(BigDecimal min,
                                                BigDecimal max,
                                                PageRequest pageRequest);

    List<String> getUppercaseTitles();
}

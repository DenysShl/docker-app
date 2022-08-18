package com.docker.service;

import com.docker.model.Product;
import com.docker.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Can`t find product by id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest).toList();
    }

    @Override
    public List<Product> getAllSortedWherePriceBetween(BigDecimal min,
                                                       BigDecimal max,
                                                       PageRequest pageRequest) {
        return productRepository.findAllByPriceBetween(min, max, pageRequest);
    }

    @Override
    public List<String> getUppercaseTitles() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(Product::getTitle)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}

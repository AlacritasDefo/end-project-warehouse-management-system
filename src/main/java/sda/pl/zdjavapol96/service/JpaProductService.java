package sda.pl.zdjavapol96.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.dto.ProductDto;
import sda.pl.zdjavapol96.model.Product;
import sda.pl.zdjavapol96.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaProductService implements ProductService{
    private final ProductRepository productRepository;

    public JpaProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(ProductDto newProduct) {
       //TODO Zaimplementować ADD Product
        return null;
    }
    @Override
    public List<Product> findAllProducts(){
        return productRepository.findAllProducts();
    }

    @Override
    public List<Product> findProductById(long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        final Optional<Product> foundProduct = productRepository.findProductByName(name);
        return foundProduct;
    }
}

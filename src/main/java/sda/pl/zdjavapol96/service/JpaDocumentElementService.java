package sda.pl.zdjavapol96.service;

import org.springframework.transaction.annotation.Transactional;
import sda.pl.zdjavapol96.dto.DocumentElementDto;
import sda.pl.zdjavapol96.model.Document;
import sda.pl.zdjavapol96.model.DocumentElement;
import sda.pl.zdjavapol96.model.Product;
import sda.pl.zdjavapol96.model.ProductPrice;
import sda.pl.zdjavapol96.repository.DocumentElementRepository;
import sda.pl.zdjavapol96.repository.ProductRepository;
import java.math.BigDecimal;

public class JpaDocumentElementService implements DocumentElementService{

    private final DocumentElementRepository documentElementRepository;
    private final ProductRepository productRepository;

    public JpaDocumentElementService(DocumentElementRepository documentElementRepository, ProductRepository productRepository) {
        this.documentElementRepository = documentElementRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public DocumentElement add(DocumentElementDto newDocumentElement) {
        DocumentElement documentElement = DocumentElement.builder()
                .document(Document.builder()
                        .id(newDocumentElement.getDocumentId())
                        .build())
                .product(Product.builder()
                        .id(newDocumentElement.getProductId())
                        .build())
                .quantity(newDocumentElement.getQuantity())
                .productPrice(ProductPrice.builder()
                        .id(newDocumentElement.getProductPriceId())
                        .build())
                .build();
        DocumentElement save = documentElementRepository.save(documentElement);
        Product product = productRepository.getById(newDocumentElement.getProductId());
        BigDecimal quantity = product.getQuantity();
        BigDecimal result = quantity.subtract(newDocumentElement.getQuantity());
        product.setQuantity(result);
        productRepository.save(product);
        return save;
    }
}

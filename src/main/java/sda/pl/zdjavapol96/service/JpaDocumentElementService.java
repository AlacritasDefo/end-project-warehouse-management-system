package sda.pl.zdjavapol96.service;

import org.springframework.transaction.annotation.Transactional;
import sda.pl.zdjavapol96.dto.DocumentElementDto;
import sda.pl.zdjavapol96.exception.NotEnoughProductOnStock;
import sda.pl.zdjavapol96.model.*;
import sda.pl.zdjavapol96.repository.DocumentElementRepository;
import sda.pl.zdjavapol96.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class JpaDocumentElementService implements DocumentElementService {

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
        if (documentElement.getDocument().getDocumentType() == DocumentType.GOODS_RECEIVED_NOTE) {
            BigDecimal quantity = product.getQuantity();
            BigDecimal result = quantity.add(newDocumentElement.getQuantity());
            product.setQuantity(result);
            productRepository.save(product);
        }
        if (documentElement.getDocument().getDocumentType() == DocumentType.STOCK_ISSUE_CONFIRMATION) {
            if (newDocumentElement.getQuantity().compareTo(product.getQuantity()) > 0) {
                throw new NotEnoughProductOnStock("Zbyt mała ilość produktu w magazynie : ", product.getQuantity());
            } else {
                BigDecimal quantity = product.getQuantity();
                BigDecimal result = quantity.subtract(newDocumentElement.getQuantity());
                product.setQuantity(result);
                productRepository.save(product);
            }
        }
        return save;
    }

    @Override
    public List<DocumentElement> findAll() {
        return documentElementRepository.findAll();
    }

    @Override
    public Optional<DocumentElement> findById(long id) {
        return Optional.of(documentElementRepository.getById(id));
    }

    @Override
    public void deleteById(long id) {
        documentElementRepository.deleteById(id);
    }
}

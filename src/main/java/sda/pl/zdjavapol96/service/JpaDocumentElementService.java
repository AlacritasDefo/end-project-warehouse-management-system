package sda.pl.zdjavapol96.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sda.pl.zdjavapol96.dto.DocumentElementDto;
import sda.pl.zdjavapol96.exception.NotEnoughProductOnStock;
import sda.pl.zdjavapol96.model.*;
import sda.pl.zdjavapol96.repository.DocumentElementRepository;
import sda.pl.zdjavapol96.repository.ProductPriceRepository;
import sda.pl.zdjavapol96.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class JpaDocumentElementService implements DocumentElementService {

    private final DocumentElementRepository documentElementRepository;
    private final ProductRepository productRepository;
    private final ProductPriceRepository productPriceRepository;

    public JpaDocumentElementService(DocumentElementRepository documentElementRepository, ProductRepository productRepository, ProductPriceRepository productPriceRepository) {
        this.documentElementRepository = documentElementRepository;
        this.productRepository = productRepository;
        this.productPriceRepository = productPriceRepository;
    }

    @Override
    @Transactional
    public DocumentElement add(DocumentElementDto newDocumentElement) {
        List<ProductPrice> pricesByProductId = productPriceRepository.findProductPricesByProductId(newDocumentElement.getProductId());
        pricesByProductId.sort((p1, p2) -> {
            if (p1.getIntroductionDate().isBefore(p2.getIntroductionDate()))
                return 1;
            else return -1;
        });
        Optional<ProductPrice> first = pricesByProductId.stream().findFirst();

        DocumentElement documentElement = DocumentElement.builder()
                .document(Document.builder()
                        .id(newDocumentElement.getDocumentId())
                        .build())
                .product(Product.builder()
                        .id(newDocumentElement.getProductId())
                        .build())
                .quantity(newDocumentElement.getQuantity())
                .productPrice(first.orElseThrow())
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
        return documentElementRepository.findById(id);
    }


    @Override
    public void deleteById(long id) {

    }
}

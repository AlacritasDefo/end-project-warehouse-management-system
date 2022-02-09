package sda.pl.zdjavapol96.service;

import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.model.*;
import sda.pl.zdjavapol96.repository.DocumentElementRepository;
import sda.pl.zdjavapol96.repository.DocumentRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JpaDocumentService implements DocumentService {


    private final DocumentRepository documentRepository;
    private final DocumentElementRepository documentElementRepository;

    public JpaDocumentService(DocumentRepository documentRepository, DocumentElementRepository documentElementRepository) {
        this.documentRepository = documentRepository;
        this.documentElementRepository = documentElementRepository;
    }

    @Override
    public Document add(DocumentDto newDocument) {
        Document document = Document.builder()
                .documentType(newDocument.getDocumentType())
                .customer(Customer.builder()
                        .id(newDocument.getCustomerId())
                        .build())
                .issueDate(newDocument.getIssueDate())
                .user(newDocument.getUser())
                .documentElements(Set.of())
                .build();
        return documentRepository.save(document);
    }

    @Override
    public List<Document> findByCustomer(Customer customer) {
        return documentRepository.findDocumentByCustomerTaxId(customer.getTaxId());
    }

    @Override
    public Optional<Document> findById(long id) {
        return documentRepository.findById(id);
    }

    @Override
    public List<Document> findByDocumentType(DocumentType documentType) {
        return documentRepository.findDocumentByDocumentType(documentType);
    }

    @Override
    public List<Document> findByProduct(Product product) {
        List<DocumentElement> documentElementByProductId = documentElementRepository.findDocumentElementByProductId(product.getId());
        return documentElementByProductId.stream().map(DocumentElement::getDocument).distinct().collect(Collectors.toList());
    }
}

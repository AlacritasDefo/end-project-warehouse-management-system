package sda.pl.zdjavapol96.service;

import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.model.Customer;
import sda.pl.zdjavapol96.model.Document;
import sda.pl.zdjavapol96.repository.DocumentElementRepository;
import sda.pl.zdjavapol96.repository.DocumentRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class JpaDocumentService implements DocumentService{


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
    public Optional<Document> findByID(long id) {
        return Optional.empty();
    }

    @Override
    public List<Document> findAll() {
        return null;
    }
}

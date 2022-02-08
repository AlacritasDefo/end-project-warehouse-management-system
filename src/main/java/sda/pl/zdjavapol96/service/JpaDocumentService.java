package sda.pl.zdjavapol96.service;

import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.model.Customer;
import sda.pl.zdjavapol96.model.Document;
import sda.pl.zdjavapol96.repository.DocumentElementRepository;
import sda.pl.zdjavapol96.repository.DocumentRepository;

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
                .documentElements(newDocument.getDocumentElements())
                .build();
        return documentRepository.save(document);
    }
}

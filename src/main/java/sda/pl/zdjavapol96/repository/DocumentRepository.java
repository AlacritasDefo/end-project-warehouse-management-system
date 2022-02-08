package sda.pl.zdjavapol96.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.pl.zdjavapol96.model.Document;
import sda.pl.zdjavapol96.model.DocumentType;

import java.time.LocalDate;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findDocumentByDocumentType(DocumentType documentType);
    List<Document> findDocumentByCustomerTaxId(String customerTaxId);
    List<Document> findDocumentByIssueDate(LocalDate issueDate);


}

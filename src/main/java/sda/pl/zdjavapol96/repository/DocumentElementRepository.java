package sda.pl.zdjavapol96.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.pl.zdjavapol96.model.DocumentElement;
import sda.pl.zdjavapol96.model.DocumentType;

import java.util.List;

public interface DocumentElementRepository extends JpaRepository<DocumentElement, Long> {

    List<DocumentElement> findDocumentElementByDocumentId(long documentId);
    List<DocumentElement> findDocumentElementByDocumentDocumentType(DocumentType documentType);
    List<DocumentElement> findDocumentElementByProductId(long productId);
    List<DocumentElement> findDocumentElementByProductProductName(String productName);

    void deleteById(long id);
}

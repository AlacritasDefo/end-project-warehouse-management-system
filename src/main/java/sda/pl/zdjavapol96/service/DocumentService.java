package sda.pl.zdjavapol96.service;


import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.model.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentService {
    Document add(DocumentDto newDocument);
    Optional<Document> findByID(long id);
    List<Document> findAll();


}

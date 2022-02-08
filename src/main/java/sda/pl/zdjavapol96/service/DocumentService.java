package sda.pl.zdjavapol96.service;


import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.model.Document;

public interface DocumentService {
    Document add(DocumentDto newDocument);

}

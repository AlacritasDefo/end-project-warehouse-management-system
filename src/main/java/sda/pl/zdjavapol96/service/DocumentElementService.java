package sda.pl.zdjavapol96.service;

import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.dto.DocumentElementDto;
import sda.pl.zdjavapol96.model.DocumentElement;

public interface DocumentElementService {
    DocumentElement add(DocumentElementDto newDocumentElement);
}

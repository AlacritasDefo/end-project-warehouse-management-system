package sda.pl.zdjavapol96.mapper;

import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.model.Document;

public class DocumentMapper {
    public static DocumentDto mapToDto(Document document){
        return DocumentDto.builder()
                .documentType(document.getDocumentType())
                .documentElements(document.getDocumentElements())
                .customerId(document.getCustomer().getId())
                .issueDate(document.getIssueDate())
                .user(document.getUser())
                .build();
    }
}

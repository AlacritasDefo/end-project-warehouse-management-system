package sda.pl.zdjavapol96.dto;

import lombok.Builder;
import lombok.Data;
import sda.pl.zdjavapol96.model.DocumentType;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class DocumentDto {
    @NotNull
    private DocumentType documentType;
    @NotNull
    private LocalDate issueDate;
    @NotNull
    private CustomerDto customer;
    @NotNull
    private UserAppDto user;
    private Set<DocumentElementDto> documentElements;

}

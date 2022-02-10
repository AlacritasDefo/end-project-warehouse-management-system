package sda.pl.zdjavapol96.dto;

import lombok.Builder;
import lombok.Data;
import sda.pl.zdjavapol96.model.DocumentElement;
import sda.pl.zdjavapol96.model.DocumentType;
import sda.pl.zdjavapol96.model.UserApp;

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
    private long customerId;
    @NotNull
    private long userId;
    private Set<DocumentElement> documentElements;

}

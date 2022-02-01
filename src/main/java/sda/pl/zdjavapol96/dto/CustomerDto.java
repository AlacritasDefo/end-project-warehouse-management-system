package sda.pl.zdjavapol96.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class CustomerDto {
    @NotNull
    @Length(min = 3, message = "Name must be at least 3 characters long")
    private String name;
    @NotNull
    private String country;
    @NotNull
    private String address;
    @NotNull
    private long phoneNumber;
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "E-mail must be correct")
    private String eMail;
    private String taxId;
}

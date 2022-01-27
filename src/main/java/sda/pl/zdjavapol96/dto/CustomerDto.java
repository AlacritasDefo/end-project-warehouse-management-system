package sda.pl.zdjavapol96.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {
    private String name;
    private String country;
    private String address;
    private long phoneNumber;
    private String eMail;
    private String taxId;
}

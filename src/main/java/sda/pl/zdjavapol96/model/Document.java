package sda.pl.zdjavapol96.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private DocumentType documentType;
    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;
    @Column(nullable = false)
    @OneToMany(targetEntity = DocumentElement.class)
    private Set<DocumentElement> documentElements = new LinkedHashSet<>();
    @Column(nullable = false)
    private LocalDate issueDate;
    @Column(nullable = false)
    @ManyToOne(targetEntity = ProductPrice.class)
    private ProductPrice productPrice;
    @ManyToOne(targetEntity = UserApp.class)
    private UserApp user;
}

package sda.pl.zdjavapol96.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "documentElements")

public class DocumentElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 20)
    private long documentId;
    @Column(nullable = false,unique = true, length = 50)
    @ManyToOne(targetEntity = Product.class)
    private Product product;
    @Column(nullable = false, length = 20)
    private BigDecimal quantity;
    @Column(nullable = false,length = 25)
    private String unit;
    @Column(nullable = false, length = 25)
    private BigDecimal productPrice;


}

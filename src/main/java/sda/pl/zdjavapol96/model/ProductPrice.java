package sda.pl.zdjavapol96.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "productPrices")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long productId;
    @Column(nullable = false)
    private BigDecimal purchasePrice;
    @Column(nullable = false)
    private BigDecimal sellingPrice;
    @Column(nullable = false)
    private Date introductiontDate;



}

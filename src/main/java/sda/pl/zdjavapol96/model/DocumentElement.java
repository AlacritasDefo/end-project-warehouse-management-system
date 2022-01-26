package sda.pl.zdjavapol96.model;


import com.sun.xml.bind.v2.TODO;
import lombok.*;
import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documentElements")

public class DocumentElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity = Document.class)
    private Document document;
    @ManyToOne(targetEntity = Product.class)
    private Product product;
    @Column(nullable = false, length = 20)
    private BigDecimal quantity;
    @Column(nullable = false,length = 25)
    private String unit;
    @Column(nullable = false, length = 25)
    private BigDecimal productPrice;

}

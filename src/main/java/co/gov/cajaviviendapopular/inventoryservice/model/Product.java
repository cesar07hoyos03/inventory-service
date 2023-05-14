package co.gov.cajaviviendapopular.inventoryservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    @OneToMany
    private List<Purchase> purchaseList;


}




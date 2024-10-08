package md.hajji.inventoryservice.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;
}

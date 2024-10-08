package md.hajji.inventoryservice;

import md.hajji.inventoryservice.entities.Product;
import md.hajji.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            Stream.of("Dell latitude 7450", "HP elite book 640", "Google pixel 9")
                    .map(name -> Product.builder()
                            .name(name)
                            .price(1000 + Math.random() * 3000)
                            .quantity((int) (1 + Math.random() * 10))
                            .build()
                    )
                    .forEach(productRepository::save);
        };
    }

}

package md.hajji.billingservice;

import md.hajji.billingservice.entities.Bill;
import md.hajji.billingservice.entities.ProductItem;
import md.hajji.billingservice.models.Customer;
import md.hajji.billingservice.repositories.BillRepository;
import md.hajji.billingservice.repositories.ProductItemRepository;
import md.hajji.billingservice.restclients.CustomerRestClient;
import md.hajji.billingservice.restclients.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;


@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(
            BillRepository billRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClient customerRestClient,
            ProductRestClient productRestClient){

        return args -> {

            //get customer with id = 1
            Customer customer = customerRestClient.getCustomer(1L);

            //create bill for the customer:
            Bill bill = Bill.builder()
                    .billingDate(LocalDateTime.now())
                    .customerId(customer.id())
                    .build();

            // save the bill:
            billRepository.save(bill);

            // fetch products from inventory-service
            // transform products to productItems
            // save the productItems
            productRestClient.getProducts()
                    .getContent()
                    .stream()
                    .map(product -> ProductItem.builder()
                            .productId(product.id())
                            .quantity(3)
                            .price(3 * product.price())
                            .bill(bill)
                            .build())
                    .forEach(productItemRepository::save);


        };
    }

}

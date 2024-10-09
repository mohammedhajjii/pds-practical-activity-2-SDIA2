package md.hajji.customerservice;

import md.hajji.customerservice.entitis.Customer;
import md.hajji.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.server.ExposesResourceFor;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            Stream.of("karim", "hamza", "asmae")
                    .map(name -> Customer.builder()
                            .name(name)
                            .email(name+"@gmail.com")
                            .build()
                    )
                    .forEach(customerRepository::save);
        };
    }

}

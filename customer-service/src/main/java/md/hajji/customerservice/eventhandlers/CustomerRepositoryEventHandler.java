package md.hajji.customerservice.eventhandlers;

import md.hajji.customerservice.entitis.Customer;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler()
public class CustomerRepositoryEventHandler {

    @HandleBeforeCreate
    public void handleBeforeCreate(Customer customer) {

        System.out.println("handleBeforeCreate started ");

        if (customer.getName() == null || customer.getName().isBlank())
            throw new IllegalArgumentException("Customer name cannot be null or empty");

        if(customer.getEmail() == null || customer.getEmail().isBlank())
            throw new IllegalArgumentException("Customer email cannot be null or empty");
    }
}

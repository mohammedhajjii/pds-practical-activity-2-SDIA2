package md.hajji.customerservice.eventhandlers;

import md.hajji.customerservice.entitis.Customer;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

@Service
@RepositoryEventHandler
public class CustomerRepositoryEventHandler {

    @HandleBeforeSave
    @HandleBeforeCreate
    public void handleBeforeCreate(Customer customer) {

        System.out.println("handleBeforeCreate started ");

        if (customer.getName() == null || customer.getName().isBlank())
            throw new IllegalArgumentException("Customer name cannot be null or empty");

        if(customer.getEmail() == null || customer.getEmail().isBlank())
            throw new IllegalArgumentException("Customer email cannot be null or empty");
    }
}

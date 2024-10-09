package md.hajji.billingservice.restclients;

import md.hajji.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @GetMapping(path = "customers/{id}")
    Customer getCustomer(@PathVariable  Long id);

    @GetMapping(path = "customers")
    PagedModel<Customer> getCustomers();
}

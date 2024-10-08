package md.hajji.inventoryservice.eventhandlers;


import md.hajji.inventoryservice.entities.Product;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

@Service
@RepositoryEventHandler
public class ProductRepositoryEventHandler {

    @HandleBeforeCreate
    @HandleBeforeSave
    public void handleSaveProduct(Product product) {

        if(product.getName() == null || product.getName().isBlank())
            throw new IllegalArgumentException("Product name cannot be empty");

        if(product.getPrice() < 0)
            throw new IllegalArgumentException("Product price cannot be negative");

        if(product.getQuantity() < 0)
            throw new IllegalArgumentException("Product quantity cannot be negative");
    }
}

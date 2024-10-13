package md.hajji.billingservice.mappers;

import md.hajji.billingservice.dtos.BillDTO;
import md.hajji.billingservice.entities.Bill;
import md.hajji.billingservice.entities.ProductItem;
import md.hajji.billingservice.restclients.CustomerRestClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring",
        uses = {CustomerRestClient.class, ProductItemMapper.class})
public interface BillMapper {

    @Mappings({
            @Mapping(source = "customerId", target = "customer"),
            @Mapping(source = "productItems", target = "totalPrice")
    })
    BillDTO mapBill(final Bill bill);

    /**
     * calculate the total price of bill:
     * @param productItems: Product item list
     * @return totalPrice
     */
    default Double calculateTotalPrice(final List<ProductItem> productItems) {
        return productItems.stream().mapToDouble(ProductItem::getPrice).sum();
    }
}

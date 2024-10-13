package md.hajji.billingservice.mappers;

import md.hajji.billingservice.dtos.ProductItemDTO;
import md.hajji.billingservice.entities.ProductItem;
import md.hajji.billingservice.restclients.ProductRestClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductRestClient.class})
public interface ProductItemMapper {

    @Mapping(source = "productId", target = "product")
    ProductItemDTO mapProductItem(ProductItem productItem);
}

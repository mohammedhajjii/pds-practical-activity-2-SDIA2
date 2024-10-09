package md.hajji.billingservice.mappers;

import md.hajji.billingservice.dtos.BillDTO;
import md.hajji.billingservice.entities.Bill;
import md.hajji.billingservice.restclients.CustomerRestClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring",
        uses = {CustomerRestClient.class, ProductItemMapper.class})
public interface BillMapper {

    @Mapping(source = "customerId", target = "customer")
    BillDTO mapBill(final Bill bill);

}

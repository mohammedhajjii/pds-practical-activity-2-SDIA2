package md.hajji.billingservice.dtos;

import md.hajji.billingservice.models.Customer;

import java.time.LocalDateTime;
import java.util.List;

public record BillDTO(
        Long id,
        LocalDateTime billingDate,
        Customer customer,
        List<ProductItemDTO> productItems,
        Double totalPrice
) {
}

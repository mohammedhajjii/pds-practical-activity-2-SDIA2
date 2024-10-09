package md.hajji.billingservice.dtos;

import md.hajji.billingservice.models.Product;

public record ProductItemDTO(
        Long id,
        double price,
        int quantity,
        Product product
) {}

import { ResolveFn } from '@angular/router';
import {Product} from "../models/models";
import {ProductService} from "../services/product.service";
import {inject} from "@angular/core";

export const productResolver: ResolveFn<Product> = route => {
  const productService: ProductService = inject(ProductService);
  const id: number = Number.parseInt(route.paramMap.get('id') || '-1');
  return productService.getProduct(id);
}

export const productsResolver: ResolveFn<Product[]> = () => {
  const productService: ProductService = inject(ProductService);
  return productService.getProducts();
}

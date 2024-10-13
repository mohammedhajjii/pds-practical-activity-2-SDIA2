import {Customer, Product} from "../models/models";

//------------------------------- Data Rest Resource --------------------------


export type Resource<T> =
  { _embedded: { [K in keyof T]: T[K]}} & {[P: string]: any};

// simulate PageModel<Customer>:
export type CustomerResource = Resource<{customers: Augmented<Customer>[]}>;

// simulate PageModel<Product>:
export type ProductResource = Resource<{products: Augmented<Product>[]}>

//------------------------------- Augmented --------------------------

export type Augmented<T> = {[K in keyof T]: T[K]} & {[K: string]: any};

export type TakeFn<T> = (augmented: Augmented<T>) => T;

export const takeCustomer: TakeFn<Customer> = augmented => {
  return {
    id: augmented.id,
    name: augmented.name,
    email: augmented.email
  }
}

export const takeProduct: TakeFn<Product> = augmented => {
  return {
    id: augmented.id,
    name: augmented.name,
    price: augmented.price,
    quantity: augmented.quantity
  }
}

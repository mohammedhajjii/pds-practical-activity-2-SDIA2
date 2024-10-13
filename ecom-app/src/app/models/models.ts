

export interface Customer{
  id: number;
  name: string;
  email: string;
}


export interface Product{
  id: number;
  name: string;
  price: number;
  quantity?: number;
}

export interface ProductItem{
  id: number;
  price: number;
  quantity: number;
  product: Product;

}


export interface Bill{
  id: number;
  billingDate: string;
  customer: Customer;
  productItems: ProductItem[],
  totalPrice: number;
}

import { ResolveFn } from '@angular/router';
import {Customer} from "../models/models";
import {CustomerService} from "../services/customer.service";
import {inject} from "@angular/core";

export const customerResolver: ResolveFn<Customer> = route => {
  const customerService: CustomerService = inject(CustomerService);
  const id: number = Number.parseInt(route.paramMap.get('id') || '-1')
  return customerService.getCustomer(id)
}

export const customersResolver: ResolveFn<Customer[]> = () => {
  console.log('started customer resolver');
  const customerService: CustomerService = inject(CustomerService);
  return customerService.getCustomers();
}

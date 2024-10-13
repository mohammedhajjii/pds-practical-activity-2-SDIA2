import { ResolveFn } from '@angular/router';
import {Bill} from "../models/models";
import {BillingService} from "../services/billing.service";
import {inject} from "@angular/core";

export const billingResolver: ResolveFn<Bill> = route => {
  const billingService: BillingService = inject(BillingService);
  const billId: number = Number.parseInt(route.paramMap.get('bid') || '-1');
  return billingService.getBillById(billId);
}


export const billingsResolver: ResolveFn<Bill[]> = (route) => {
  const billingService: BillingService = inject(BillingService);
  const customer: number = Number.parseInt(route.paramMap.get('cid') || '-1');
  return billingService.getBillsByCustomer(customer);
}



export class Environment {
  static baseUrl: string = 'http://localhost:8888';
  static customerService: string = `${Environment.baseUrl}/customer-service/customers`;
  static inventoryService: string = `${Environment.baseUrl}/inventory-service/products`;
  static billingService: string = `${Environment.baseUrl}/billing-service//bill-details`;
}


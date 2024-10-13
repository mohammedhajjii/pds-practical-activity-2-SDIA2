import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, mergeAll, Observable, toArray} from "rxjs";
import {Environment} from "../../environments/environment";
import {Customer} from "../models/models";
import {Resource, Augmented, takeCustomer, CustomerResource} from "../utils/utils";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {


  constructor(private http: HttpClient) {}


  getCustomers(): Observable<Customer[]>{
    return this.http.get<CustomerResource>(Environment.customerService)
      .pipe(
        map(resource => resource._embedded.customers),
        mergeAll(),
        map(takeCustomer),
        toArray()
      );


  }

  getCustomer(id: number): Observable<Customer>{
    const url: string = `${Environment.customerService}/${id}`
    return this.http.get<Augmented<Customer>>(url)
      .pipe(map(takeCustomer));
  }


}

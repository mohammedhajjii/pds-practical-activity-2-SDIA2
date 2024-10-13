import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bill} from "../models/models";
import {Environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class BillingService {

  constructor(private http: HttpClient) { }

  getBillById(id: number): Observable<Bill>{
    const url: string = `${Environment.billingService}/${id}`;
    return this.http.get<Bill>(url);
  }

  getBillsByCustomer(id: number): Observable<Bill[]>{
    const url: string = `${Environment.billingService}/of-customer/${id}`;
    return this.http.get<Bill[]>(url);
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, mergeAll, Observable, of, toArray} from "rxjs";
import {Product} from "../models/models";
import {Augmented, ProductResource, takeProduct, Resource} from "../utils/utils";

import {Environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]>{
    return this.http.get<ProductResource>(Environment.inventoryService)
      .pipe(
        map(resource => resource._embedded.products),
        mergeAll(),
        map(takeProduct),
        toArray()
      );
  }

  getProduct(id: number): Observable<Product>{
    const url: string = `${Environment.inventoryService}/${id}`;
    return this.http.get<Augmented<Product>>(url)
      .pipe(map(takeProduct));

  }
}

import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Product} from "../../models/models";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit{

  readonly displayColumns: string[] = [
    'ID',
    'Name',
    'Price',
    'Quantity'
  ];

  dataSource!: MatTableDataSource<Product>;

  constructor(private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe({
      next: data => {
        this.dataSource = new MatTableDataSource(data['products'] as Product[]);
      }
    })
  }




}

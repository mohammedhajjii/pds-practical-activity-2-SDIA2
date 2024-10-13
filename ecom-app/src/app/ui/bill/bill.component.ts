import {Component, OnInit, signal} from '@angular/core';
import {Bill, ProductItem} from "../../models/models";
import {ActivatedRoute} from "@angular/router";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrl: './bill.component.css'
})
export class BillComponent implements OnInit{

  bill = signal<Partial<Bill>>({});

  readonly displayedColumns: string[] = [
    'ID', //id of item
    'Name',
    'UnitPrice',
    'Quantity',
    'Price'
  ];

  dataSource!: MatTableDataSource<ProductItem>;

  constructor(private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe({
      next: data => {
        this.bill.set(data['bill'] as Bill);
        this.dataSource = new MatTableDataSource<ProductItem>(this.bill().productItems);
      }
    });
  }


  protected readonly encodeURI = encodeURI;
}

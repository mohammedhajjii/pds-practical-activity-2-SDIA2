import {AfterViewInit, Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CustomerService} from "../../services/customer.service";
import {MatTableDataSource} from "@angular/material/table";
import {Customer} from "../../models/models";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent implements OnInit, AfterViewInit{

  readonly displayColumns: string[] = [
    'ID',
    'Name',
    'Email',
    'Bills'
  ];

  datasource!: MatTableDataSource<Customer>;

  constructor(private activatedRoute: ActivatedRoute,
              private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe({
      next: data => {
        this.datasource = new MatTableDataSource<Customer>(data['customers'] as Customer[]);
      }
    })
  }


  ngAfterViewInit(): void {
  }


}

import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Bill} from "../../models/models";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrl: './bills.component.css'
})
export class BillsComponent implements OnInit{

  readonly displayedColumns: string[] = [
    'ID',
    'Date',
    'Details'
  ];

  dataSource!: MatTableDataSource<Bill>;

  constructor(private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    console.log('init bills started');
    this.activatedRoute.data.subscribe({
      next: data => {
        this.dataSource = new MatTableDataSource<Bill>(data['bills'] as Bill[]);
      }
    })
  }


}

import {Component, OnInit, signal} from '@angular/core';
import {Environment} from "../environments/environment";
import {CustomerService} from "./services/customer.service";
import {ProductService} from "./services/product.service";
import {NavigationCancel, NavigationEnd, NavigationError, NavigationStart, Router} from "@angular/router";
import {reflectObjectLiteral} from "@angular/compiler-cli/src/ngtsc/reflection";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'ecom-app';
  displayProgressBar = signal(false);

  constructor(private customerService: CustomerService,
              private productService: ProductService,
              private router: Router) {
  }

  ngOnInit(): void {
    // console.log('---------------------- Customers ------------------------');
    // this.customerService.getCustomers()
    //   .subscribe({
    //     next: value => {
    //       console.log(value);
    //     },
    //     error: err => {
    //       console.error(err);
    //     }
    //   });
    // console.log('---------------------- Customers 1 ------------------------');
    // this.customerService.getCustomer(1)
    //   .subscribe({
    //     next: customer => {
    //       console.log(customer)
    //     }
    //   });
    // console.log('---------------------- Products ------------------------');
    // this.productService.getProducts()
    //   .subscribe({
    //     next: value => {
    //       console.log(value);
    //     },
    //     error: err => {
    //       console.log(err);
    //     }
    //   });
    // console.log('---------------------- Product 1 ------------------------');
    // this.productService.getProduct(1)
    //   .subscribe({
    //     next: product=> {
    //       console.log(product)
    //     }
    //   })

    this.router.events.subscribe({
      next: event => {
        if (event instanceof NavigationStart){
          this.displayProgressBar.set(true);
        }
        if (event instanceof NavigationEnd ||
          event instanceof NavigationCancel ||
          event instanceof NavigationError){
          this.displayProgressBar.set(false);
        }
      }
    });
  }
}

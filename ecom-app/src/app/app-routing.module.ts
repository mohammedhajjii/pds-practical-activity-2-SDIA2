import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomerComponent} from "./ui/customer/customer.component";
import {customersResolver} from "./resolvers/customer.resolver";
import {ProductComponent} from "./ui/product/product.component";
import {productsResolver} from "./resolvers/product.resolver";
import {BillsComponent} from "./ui/bills/bills.component";
import {billingResolver, billingsResolver} from "./resolvers/billing.resolver";
import {BillComponent} from "./ui/bill/bill.component";

const routes: Routes = [
  {
    path: 'customers',
    children: [
      {
        path: '',
        component: CustomerComponent,
        resolve: {
          customers: customersResolver
        }
      }
      ,
      {
        path: ':cid/bills',
        children: [
          {
            path: '',
            component: BillsComponent,
            resolve: {
              bills: billingsResolver
            }
          },
          {
            path: ':bid',
            component: BillComponent,
            resolve: {
              bill: billingResolver
            }
          }
        ]
      }
    ]
  },
  // { path: 'customers/:cid/bills',
  //   component: BillsComponent,
  //   resolve: {
  //     bills: billingsResolver
  //   }
  // },
  {
    path: 'products',
    component: ProductComponent,
    resolve: {
      products: productsResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

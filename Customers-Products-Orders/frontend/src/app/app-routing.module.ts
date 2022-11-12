import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCustomerComponent } from './components/add-customer/add-customer.component';
import { CustomerOrdersComponent } from './components/customer-orders/customer-orders.component';
import { CustomersComponent } from './components/customers/customers.component';
import { OrderDetailsComponent } from './components/order-details/order-details.component';
import { OrdersComponent } from './components/orders/orders.component';
import { ProductsComponent } from './components/products/products.component';

const routes: Routes = [
  { path: '', redirectTo: '/customers', pathMatch: 'full' }, // redirect to home
  { path: 'customers', component: CustomersComponent },
  { path: 'customer-orders/:id', component: CustomerOrdersComponent },
  { path: 'addcustomer', component: AddCustomerComponent },
  { path: 'products', component: ProductsComponent },
  { path: 'orders', component: OrdersComponent },
  { path: 'order-details/:id', component: OrderDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

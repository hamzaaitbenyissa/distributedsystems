import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from 'src/app/models/Order';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-customer-orders',
  templateUrl: './customer-orders.component.html',
  styleUrls: ['./customer-orders.component.css'],
})
export class CustomerOrdersComponent implements OnInit {
  orders!: Order[];
  errorMessage: string = '';

  constructor(private orderService: OrderService, private router: Router,   private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.searchOrdersByCustomer();
  }

  //handle searching event
  searchOrdersByCustomer() {
    this.orderService.searchByCustomer(this.route.snapshot.params['id']).subscribe({
      next: (resp) => {
        console.log(resp);
        this.orders = resp._embedded.orders;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  // check the costumer accounts
  checkOrderDetails(order: Order) {
    console.log('clicked ');
    this.router.navigateByUrl('/order-details/' + order.id);
  }
}

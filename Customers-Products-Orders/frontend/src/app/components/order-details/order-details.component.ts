import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from 'src/app/models/Order';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  order!: Order;
  errorMessage: string = '';

  constructor(private orderService: OrderService, private router: Router,   private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.getOrderDetails();
  }

  //handle searching event
  getOrderDetails() {
    this.orderService.getOrderDetails(this.route.snapshot.params['id']).subscribe({
      next: (resp) => {
        console.log(resp);
        this.order = resp;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

}

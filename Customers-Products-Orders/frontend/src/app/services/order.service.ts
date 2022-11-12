import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Order, OrderServiceResponse } from '../models/Order';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  constructor(private http: HttpClient) {}

  // http://localhost:8083/orders/search/byCustomer?id=16&projection=fullOrder

  // fullOrder/5

  public searchByCustomer(id: String): Observable<OrderServiceResponse> {
    return this.http.get<OrderServiceResponse>(
      environment.backendServer +
        '/order-service/orders/search/byCustomer?id=' +
        id +
        '&projection=fullOrder'
    );
  }

  public getOrderDetails(id: String): Observable<Order> {
    return this.http.get<Order>(
      environment.backendServer + '/order-service/fullOrder/' + id
    );
  }
}

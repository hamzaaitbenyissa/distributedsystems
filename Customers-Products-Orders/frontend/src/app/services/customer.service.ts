import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Customer, CustomerServiceResponse } from '../models/Customer';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  constructor(private http: HttpClient) {}

  public searchCustomers(keyword: String): Observable<CustomerServiceResponse> {
    return this.http.get<CustomerServiceResponse>(
      environment.backendServer +
        '/customer-service/customers/search/byName?name=' +
        keyword +
        '&projection=fullCustomer'
    );
  }
  
  // add a new customer
  public addCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(
      environment.backendServer + '/customer-service/customers',
      customer
    );
  }

  // delete an user
  public deleteCustomer(id: number) {
    return this.http.delete(environment.backendServer + '/customer-service/customers/' + id);
  }
}

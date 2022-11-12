import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { catchError, map, Observable, throwError } from 'rxjs';
import { CustomerService } from 'src/app/services/customer.service';
import { Customer } from '../../models/Customer';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css'],
})
export class CustomersComponent implements OnInit {
  customers!: Customer[];
  errorMessage: string = '';

  constructor(
    private customerService: CustomerService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.handleSearchCustomers();
  }

  myForm = new FormGroup({
    keyword: new FormControl(''),
  });

  get f() {
    return this.myForm.controls;
  }

  //handle searching event
  handleSearchCustomers() {
    this.customerService.searchCustomers(this.myForm.value.keyword).subscribe({
      next: (resp) => {
        console.log(resp);
        this.customers = resp._embedded.customers;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  // handle delete  event
  onDeleteCustomer(c: Customer) {
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this customer!',
      icon: 'question',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#330020',

      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it',
    }).then((result) => {
      if (result.isConfirmed) {
        this.customerService.deleteCustomer(c.id).subscribe({
          next: (resp) => {
            this.customers = this.customers.slice(this.customers.indexOf(c), 1);
          },
          error: (err) => {
            console.log(err);
          },
        });
      } else if (result.isDismissed) {
      }
    });
  }

  // handle edit event
  onEditCustomer() {
    confirm('Are you sure you want to edit it ');
  }

  // check the costumer accounts
  checkCustomerOrders(customer: Customer) {
    console.log('clicked ');
    this.router.navigateByUrl('/customer-orders/' + customer.id);
  }
}

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  products!: Product[];
  errorMessage: string = '';

  constructor(private productService: ProductService, private router: Router) {}
  ngOnInit(): void {
    this.handleSearchProducts();
  }

  myForm = new FormGroup({
    keyword: new FormControl(''),
  });

  get f() {
    return this.myForm.controls;
  }

  //handle searching event
  handleSearchProducts() {
    this.productService.searchProducts(this.myForm.value.keyword).subscribe({
      next: (resp) => {
        console.log(resp);
        this.products = resp._embedded.products;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  // handle delete  event
  onDeleteProduct(c: Product) {
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this product!',
      icon: 'question',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#330020',

      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it',
    }).then((result) => {
      if (result.isConfirmed) {
        this.productService.deleteProduct(c.id).subscribe({
          next: (resp) => {
            this.products = this.products.slice(this.products.indexOf(c), 1);
          },
          error: (err) => {
            console.log(err);
          },
        });
      } else if (result.isDismissed) {
      }
    });
  }

  // check the costumer accounts
  checkProductOrders(product: Product) {
    console.log('clicked ');
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Product, ProductServiceResponse } from '../models/Product';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}

  public searchProducts(keyword: String): Observable<ProductServiceResponse> {
    return this.http.get<ProductServiceResponse>(
      environment.backendServer +
        '/product-service/products/search/byName?name=' +
        keyword +
        '&projection=fullProduct'
    );
  }

  // add a new product
  public addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(
      environment.backendServer + '/product-service/products',
      product
    );
  }

  // delete an user
  public deleteProduct(id: number) {
    return this.http.delete(
      environment.backendServer + '/product-service/products/' + id
    );
  }
}

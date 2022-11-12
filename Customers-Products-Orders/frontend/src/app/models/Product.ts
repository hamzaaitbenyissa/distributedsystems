export interface ProductServiceResponse {
  _embedded: ProductEmbedded;
  page:      Page;
}

export interface ProductEmbedded {
  products: Product[];
}

export interface Product {
  id:            number;
  name:          string;
  quantityStock: number;
  price:         number;
}


export interface LinksProduct {
  href:      string;
  templated: boolean;
}


export interface Page {
  size:          number;
  totalElements: number;
  totalPages:    number;
  number:        number;
}
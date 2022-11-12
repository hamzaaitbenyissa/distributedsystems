import { Product } from './Product';

export interface OrderServiceResponse {
  _embedded: OrderEmbedded;
}

export interface OrderEmbedded {
  orders: Order[];
}

export interface Order {
  id: number;
  status: string;
  costumerId: number;
  updatedAt: Date;
  createdAt: Date;
  total: number;
  orderedProducts: OrderedProducts[];
}

export interface OrderedProducts {
  id: number;
  productId: number;
  quantity: number;
  discount: number;
  product: Product;
  amount: number;
}

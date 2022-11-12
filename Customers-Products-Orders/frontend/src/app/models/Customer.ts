export interface CustomerServiceResponse {
  _embedded: CustomerEmbedded;
  page: Page;
}

export interface CustomerEmbedded {
  customers: Customer[];
}

export interface Customer {
  id: number;
  name: string;
  email: string;
}

export interface Page {
  size: number;
  totalElements: number;
  totalPages: number;
  number: number;
}

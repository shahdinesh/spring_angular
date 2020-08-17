import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getOrders(): Observable<any> {
    return this.http.get(API_URL + 'orders', httpOptions);
  }

  markPaid(id): Observable<any> {
    return this.http.get(API_URL + 'orders/markPaid/' + id, httpOptions);
  }

  placeOrder(formData): Observable<any> {
    return this.http.post(API_URL + 'orders/placeOrder', formData, httpOptions);
  }

}

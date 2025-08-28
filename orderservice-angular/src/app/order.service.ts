import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  API="http://localhost:8080";
  public registerOrder(orderData: any)
  {
    return this.http.post(`${this.API}/orderservice` , orderData);
  }

  public getOrders(){
    return this.http.get(`${this.API}/orderservice`);
  }

  public deleteOrder(orderId:any){
    return this.http.delete(`${this.API}/orderservice/${orderId}`);
  }

  public updateOrder(order: any){
    return this.http.put(`${this.API}/orderservice/${order.id}`, order);
  }
  constructor(private http: HttpClient) { }
}

package com.tnisf.orderservice_santhosh;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {
	@Autowired
    private OrderServiceSer service;
    
	@PostMapping("/Orderservice")
	public void add(@RequestBody OrderService order) {
		service.insertRecord(order);
	}
	@GetMapping("/orderservice")
	public List<OrderService> ShowAll(){
		return service.getAllRecords();
	}
	@GetMapping("/orderservice/{id}")
	public OrderService getOrderById(@PathVariable Integer id)
	{
		return service.getCustomerById(id);
	}
	
	@DeleteMapping("/orderservice/{id}")
	public void deleteOrder(@PathVariable Integer id)
	{
		service.deleteCustomer(id);
	}
	
	@PutMapping("/customerservice/{id}")
	public ResponseEntity<String> updateOrderService(@PathVariable Integer id,@RequestBody OrderService updatedOrder)
	{
		service.updateOrderService(id,updatedOrder);
		return ResponseEntity.ok("Customer updated Successfully");
	}
		
		
}


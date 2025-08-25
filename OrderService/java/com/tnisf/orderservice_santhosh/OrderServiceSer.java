package com.tnisf.orderservice_santhosh;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceSer {
	@Autowired
	private OrderServiceRepository repo;
	
	//Inserting records
	public void insertRecord(OrderService cust)
	{
		repo.save(cust);
	}
	
	//Show all the records 
	public List<OrderService> getAllRecords()
	{
		return repo.findAll();
	}
	
	//Show specific record 
	public OrderService getCustomerById(Integer id)
	{
		return repo.findById(id).orElse(null);
	}
	//Deleting the specific record from the table in database
	public void deleteCustomer(Integer id)
	{
		repo.deleteById(id);
	}
	
	//updating the existing record
	public void updateOrderService(Integer id,OrderService updateOrderService)
	{
		OrderService existingOrderService=repo.findById(id).orElse(null);
		if(existingOrderService!=null)
		{
			existingOrderService.setId(updateOrderService.getId());
			existingOrderService.setName(updateOrderService.getName());
			existingOrderService.setEmail(updateOrderService.getEmail());
			existingOrderService.setPhonenumber(updateOrderService.getPhonenumber());
			repo.save(existingOrderService);
		}
	}
	}


package ques2.Controller;

import java.sql.Date;

import ques2.Model.Persistence.*;
import ques2.Model.Service.*;

public class CustomerApp {

	public static void main(String[] args) {
		CustomerDto customerService = new CustomerDtoImpl();

		System.out.println("add new customer");
		customerService.addCustomer(new Customer(123, "Mahek", "ymsli", "9867453536", Date.valueOf("1999-11-17")));
		customerService.addCustomer(new Customer(456, "Harshdeep", "ymsli", "7867878678", Date.valueOf("2000-08-10")));

		Customer customer = customerService.getById(1);
		System.out.println("get by id");
		System.out.println(customer);

	}

}
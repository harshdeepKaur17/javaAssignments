package ques2.Model.Service;

import ques2.Model.Persistence.Customer;

public interface CustomerDto {
	void addCustomer(Customer c);

	Customer getById(int id);
}

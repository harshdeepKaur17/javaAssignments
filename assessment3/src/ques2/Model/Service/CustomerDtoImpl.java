package ques2.Model.Service;

import ques2.Model.Persistence.*;

public class CustomerDtoImpl implements CustomerDto {
	CustomerDao cs = new CustomerDaoImpl();

	@Override
	public void addCustomer(Customer c) {
		cs.addCustomer(c);
	}

	@Override
	public Customer getById(int id) {
		return cs.getById(id);
	}

}

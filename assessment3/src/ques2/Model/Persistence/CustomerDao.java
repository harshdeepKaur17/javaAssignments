package ques2.Model.Persistence;

public interface CustomerDao {
	void addCustomer(Customer c);

	Customer getById(int id);
}
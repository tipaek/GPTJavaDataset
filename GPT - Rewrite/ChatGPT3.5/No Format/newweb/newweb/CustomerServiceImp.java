package com.newweb.service.base.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newweb.dao.base.CustomerDao;
import com.newweb.model.base.Customer;
import com.newweb.service.base.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Component("customerService")
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer findCustomerByID(int id) {
        return customerDao.selectCustomerByID(id);
    }

    @Override
    public Customer[] queryCustomerByName(String name) {
        List<Customer> list = customerDao.selectCustomerByName(name);
        return list.toArray(new Customer[0]);
    }

    @Override
    public Customer[] queryAllCustomers() {
        List<Customer> list = customerDao.selectAllCustomers();
        return list.toArray(new Customer[0]);
    }

    @Override
    public Customer[] queryCustomerByLikePy(String py) {
        List<Customer> list = customerDao.selectCustomersByLikePy(py);
        return list.toArray(new Customer[0]);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List queryAllCustomers(int start, int limit) {
        List list = customerDao.selectAllCustomers(start, limit);
        int size = (Integer) list.get(0);
        List cList = (List) list.get(1);
        Customer[] cs = new Customer[cList.size()];
        int count = 0;
        for (Object c : cList) {
            cs[count++] = (Customer) c;
        }
        List returnList = new ArrayList();
        returnList.add(size); // First object saves the total result count
        returnList.add(cs);  // Second object saves the entity array
        return returnList;
    }

    @Override
    public boolean save(Customer c) {
        return customerDao.insert(c);
    }

    @Override
    public boolean modify(Customer c) {
        return customerDao.update(c);
    }

    @Override
    public boolean remove(Customer customer) {
        return customerDao.delete(customer);
    }
}

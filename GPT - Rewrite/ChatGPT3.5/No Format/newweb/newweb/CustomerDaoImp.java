package com.newweb.dao.base.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newweb.dao.base.CustomerDao;
import com.newweb.model.base.Customer;

@Component("customerDao")
public class CustomerDaoImp implements CustomerDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Customer selectCustomerByID(int id) {
        return getCurrentSession().get(Customer.class, id);
    }

    @Override
    public List<Customer> selectCustomerByName(String name) {
        Query query = getCurrentSession().createSQLQuery("select * from t_customer where name=? order by py")
                .addEntity(Customer.class);
        return query.setString(0, name).list();
    }

    @Override
    public List<Customer> selectAllCustomers() {
        Query query = getCurrentSession().createSQLQuery("select * from t_customer where valid=true")
                .addEntity(Customer.class);
        return query.list();
    }

    @Override
    public List<Customer> selectCustomersByLikePy(String py) {
        Query query = getCurrentSession().createSQLQuery("select * from t_customer where valid=true and py like ?")
                .addEntity(Customer.class);
        return query.setString(0, py).list();
    }

    @Override
    public List<Customer> selectAllCustomers(int start, int limit) {
        Query query = getCurrentSession().createSQLQuery("select * from t_customer order by py")
                .addEntity(Customer.class);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public boolean insert(Customer c) {
        try {
            getCurrentSession().save(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Customer c) {
        try {
            getCurrentSession().update(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Customer customer) {
        try {
            getCurrentSession().delete(customer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

package com.newweb.dao.business.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newweb.dao.business.OrderBxgFdwDao;
import com.newweb.model.business.OrderBxgFdw;

@SuppressWarnings("unchecked")
@Component("orderBxgFdwDao")
public class OrderBxgFdwDaoImp implements OrderBxgFdwDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrderBxgFdwDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean insert(OrderBxgFdw orderBxgFdw) {
        try {
            sessionFactory.getCurrentSession().save(orderBxgFdw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<OrderBxgFdw> selectOrderBxgFdwsByOrderID(String orderid) {
        Query query = sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_order_bxgfdws where orderID=?")
                .addEntity(OrderBxgFdw.class);
        return query.setString(0, orderid).list();
    }

    @Override
    public OrderBxgFdw selectBxgFdwById(int iD) {
        return (OrderBxgFdw) sessionFactory.getCurrentSession().get(OrderBxgFdw.class, iD);
    }

    @Override
    public boolean update(OrderBxgFdw fdw) {
        try {
            sessionFactory.getCurrentSession().update(fdw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(OrderBxgFdw fdw) {
        try {
            sessionFactory.getCurrentSession().delete(fdw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

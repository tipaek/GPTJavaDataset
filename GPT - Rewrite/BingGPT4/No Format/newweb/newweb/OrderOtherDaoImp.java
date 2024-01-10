package com.newweb.dao.business.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newweb.dao.business.OrderOtherDao;
import com.newweb.model.business.OrderOther;

import java.util.List;

@Repository("orderOtherDao")
public class OrderOtherDaoImp implements OrderOtherDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrderOtherDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean insert(OrderOther other) {
        try {
            sessionFactory.getCurrentSession().save(other);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderOther> selectOrderOthersByOrderID(String orderid) {
        return sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_order_others where orderid=?")
                .addEntity(OrderOther.class)
                .setString(0, orderid)
                .list();
    }

    @Override
    public OrderOther selectOrderOtherById(int id) {
        return (OrderOther) sessionFactory.getCurrentSession().get(OrderOther.class, id);
    }

    @Override
    public boolean update(OrderOther other) {
        try {
            sessionFactory.getCurrentSession().update(other);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(OrderOther other) {
        try {
            sessionFactory.getCurrentSession().delete(other);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

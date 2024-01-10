package com.newweb.dao.business.imp;

import com.newweb.dao.business.OrderSmallDao;
import com.newweb.model.business.OrderSmall;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderSmallDao")
public class OrderSmallDaoImp implements OrderSmallDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrderSmallDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int insert(OrderSmall os) {
        return (Integer) sessionFactory.getCurrentSession().save(os);
    }

    @Override
    public OrderSmall selectOrderSmallById(int id) {
        return (OrderSmall) sessionFactory.getCurrentSession().get(OrderSmall.class, id);
    }

    @Override
    public boolean delete(OrderSmall os) {
        try {
            sessionFactory.getCurrentSession().delete(os);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(OrderSmall os) {
        try {
            sessionFactory.getCurrentSession().update(os);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public OrderSmall selectOrderSmallBySmallIdInOrderId(int smallId, String orderId) {
        return (OrderSmall) sessionFactory.getCurrentSession()
                .createSQLQuery("select * from  t_order_smallGoods where smallID=? and orderID=? ")
                .addEntity(OrderSmall.class)
                .setInteger(0, smallId)
                .setString(1, orderId)
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderSmall> selectAllOrderSmalls() {
        return sessionFactory.getCurrentSession()
                .createSQLQuery("select * from  t_order_smallGoods")
                .addEntity(OrderSmall.class)
                .list();
    }
}

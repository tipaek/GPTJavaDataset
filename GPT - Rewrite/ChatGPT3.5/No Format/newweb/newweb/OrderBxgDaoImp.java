package com.newweb.dao.business.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newweb.dao.business.OrderBxgDao;
import com.newweb.model.business.OrderBxg;

@Component("orderBxgDao")
public class OrderBxgDaoImp implements OrderBxgDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrderBxgDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int insert(OrderBxg ob) {
        return (int) sessionFactory.getCurrentSession().save(ob);
    }

    @Override
    public OrderBxg selectOrderBxgByBxgIdInOrderID(int bxgID, String orderId) {
        Query query = sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_order_bxgs where bxgID=? and orderID=? ").addEntity(OrderBxg.class);
        query.setInteger(0, bxgID);
        query.setString(1, orderId);
        return (OrderBxg) query.uniqueResult();
    }

    @Override
    public boolean delete(OrderBxg ob) {
        try {
            sessionFactory.getCurrentSession().delete(ob);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(OrderBxg ob) {
        try {
            sessionFactory.getCurrentSession().update(ob);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderBxg> selectAllOrderBxgs() {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select * from t_order_bxgs")
                .addEntity(OrderBxg.class);
        return query.list();
    }
}

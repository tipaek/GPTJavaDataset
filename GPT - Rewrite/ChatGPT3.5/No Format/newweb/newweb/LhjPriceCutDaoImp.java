package com.newweb.dao.business.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newweb.dao.business.LhjPriceCutDao;
import com.newweb.model.business.LhjPriceCut;

@Repository("lhjPriceCutDao")
public class LhjPriceCutDaoImp implements LhjPriceCutDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public LhjPriceCutDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public LhjPriceCut selectPriceCutByCustomerIDAndPriceID(int priceID, int customerID) {
        String hql = "FROM LhjPriceCut WHERE lhjPrice.id = :priceID AND customer.id = :customerID";
        return sessionFactory.getCurrentSession()
                .createQuery(hql, LhjPriceCut.class)
                .setParameter("priceID", priceID)
                .setParameter("customerID", customerID)
                .uniqueResult();
    }

    @Override
    public boolean insert(LhjPriceCut cut) {
        try {
            sessionFactory.getCurrentSession().save(cut);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(LhjPriceCut cut) {
        try {
            sessionFactory.getCurrentSession().delete(cut);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(LhjPriceCut cut) {
        try {
            sessionFactory.getCurrentSession().update(cut);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

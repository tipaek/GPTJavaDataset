package com.newweb.dao.business.imp;

import com.newweb.dao.business.SmallPriceCutDao;
import com.newweb.model.business.SmallPriceCut;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("smallPriceCutDao")
public class SmallPriceCutDaoImp implements SmallPriceCutDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public SmallPriceCutDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SmallPriceCut selectSmallPriceCutBySmallIDAndCustomerID(int smallID, int customerID) {
        return (SmallPriceCut) sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_smallpricecut where smallid=? and customerid=?")
                .addEntity(SmallPriceCut.class)
                .setInteger(0, smallID)
                .setInteger(1, customerID)
                .uniqueResult();
    }

    @Override
    public boolean insert(SmallPriceCut cut) {
        try {
            sessionFactory.getCurrentSession().save(cut);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(SmallPriceCut cut) {
        try {
            sessionFactory.getCurrentSession().delete(cut);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(SmallPriceCut cut) {
        try {
            sessionFactory.getCurrentSession().update(cut);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

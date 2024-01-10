package com.newweb.dao.base.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newweb.dao.base.LhjPriceDao;
import com.newweb.model.base.LhjPrice;

@Repository("lhjPriceDao")
public class LhjPriceDaoImp implements LhjPriceDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public LhjPriceDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public LhjPrice selectLhjPriceByMaterialBrandID(int materialBrandID) {
        String hql = "FROM LhjPrice WHERE materialBrand.id = :materialBrandID";
        return sessionFactory.getCurrentSession()
                .createQuery(hql, LhjPrice.class)
                .setParameter("materialBrandID", materialBrandID)
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<LhjPrice> selectAllLhjPrices(int start, int limit) {
        String hql = "FROM LhjPrice";
        List<LhjPrice> lhjPrices = sessionFactory.getCurrentSession()
                .createQuery(hql)
                .setFirstResult(start)
                .setMaxResults(limit)
                .list();

        int size = lhjPrices.size();
        return List.of(size, lhjPrices);
    }

    @Override
    public LhjPrice selectLhjPriceByID(int lid) {
        return sessionFactory.getCurrentSession().get(LhjPrice.class, lid);
    }

    @Override
    public boolean update(LhjPrice lhjp) {
        try {
            sessionFactory.getCurrentSession().update(lhjp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(LhjPrice lhjp) {
        try {
            sessionFactory.getCurrentSession().save(lhjp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(LhjPrice lhjp) {
        try {
            sessionFactory.getCurrentSession().delete(lhjp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

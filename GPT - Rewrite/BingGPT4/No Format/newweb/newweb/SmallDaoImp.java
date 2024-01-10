package com.newweb.dao.base.imp;

import com.newweb.dao.base.SmallDao;
import com.newweb.model.base.Small;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("smallDao")
public class SmallDaoImp implements SmallDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public SmallDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<String> selectDistinctType() {
        return sessionFactory.getCurrentSession()
                .createSQLQuery("select distinct type from t_small where valid=true")
                .list();
    }

    @Override
    public List<Small> selectAllSmalls() {
        return sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_small where valid=true order by buycount desc,type desc,CONVERT(name USING GBK)")
                .addEntity(Small.class)
                .list();
    }

    @Override
    public List<Small> selectSmallsByType(String type) {
        return sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_small where valid=true and type=? order by buycount desc,type desc,CONVERT(name USING GBK)")
                .addEntity(Small.class)
                .setString(0, type)
                .list();
    }

    @Override
    public Small selectSmallById(int id) {
        return (Small) sessionFactory.getCurrentSession().get(Small.class, id);
    }

    @Override
    public int update(Small small) {
        sessionFactory.getCurrentSession().update(sessionFactory.getCurrentSession().merge(small));
        return 1;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List selectAllSmalls(int start, int limit) {
        List list = new ArrayList();
        var query = sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_small order by valid DESC,buycount desc,type desc,CONVERT(name USING GBK)")
                .addEntity(Small.class);
        list.add(query.list().size());
        list.add(query.setFirstResult(start).setMaxResults(limit).list());
        return list;
    }

    @Override
    public Small selectSmallByName(String name) {
        return (Small) sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_small where name=?")
                .addEntity(Small.class)
                .setString(0, name)
                .uniqueResult();
    }

    @Override
    public boolean insert(Small small) {
        try {
            sessionFactory.getCurrentSession().save(small);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Small small) {
        try {
            sessionFactory.getCurrentSession().delete(small);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

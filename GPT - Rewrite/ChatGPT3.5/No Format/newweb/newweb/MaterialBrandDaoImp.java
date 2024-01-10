package com.newweb.dao.base.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.newweb.dao.base.MaterialBrandDao;
import com.newweb.model.base.MaterialBrand;
import com.newweb.model.base.TypeForBrand;

@Component("materialBrandDao")
@Transactional
public class MaterialBrandDaoImp implements MaterialBrandDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public MaterialBrandDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<MaterialBrand> selectMaterialBrandsByType(String type) {
        Query<MaterialBrand> query = sessionFactory.getCurrentSession()
                .createQuery("from MaterialBrand where valid = true and type = :type", MaterialBrand.class);
        return query.setParameter("type", type).list();
    }

    @Override
    public MaterialBrand selectMaterialBrandById(int iD) {
        return sessionFactory.getCurrentSession().get(MaterialBrand.class, iD);
    }

    @Override
    public TypeForBrand selectTypeForBrandById(int iD) {
        return sessionFactory.getCurrentSession().get(TypeForBrand.class, iD);
    }

    @Override
    public List<Object> selectAllMaterialBrands(int start, int limit) {
        List<Object> list = new ArrayList<>();
        Query<MaterialBrand> query = sessionFactory.getCurrentSession().createQuery("from MaterialBrand", MaterialBrand.class);
        int size = query.list().size();
        query.setFirstResult(start);
        query.setMaxResults(limit);
        list.add(0, size);
        list.add(1, query.list());
        return list;
    }

    @Override
    public boolean update(MaterialBrand mb) {
        try {
            sessionFactory.getCurrentSession().update(mb);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public MaterialBrand selectMaterialBrandByName(String name) {
        Query<MaterialBrand> query = sessionFactory.getCurrentSession()
                .createQuery("from MaterialBrand where name = :name", MaterialBrand.class);
        return query.setParameter("name", name).uniqueResult();
    }

    @Override
    public boolean insert(MaterialBrand mb) {
        try {
            sessionFactory.getCurrentSession().save(mb);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(MaterialBrand mb) {
        try {
            sessionFactory.getCurrentSession().delete(mb);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

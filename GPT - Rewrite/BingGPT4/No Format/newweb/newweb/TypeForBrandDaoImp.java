package com.newweb.dao.base.imp;

import com.newweb.dao.base.TypeForBrandDao;
import com.newweb.model.base.TypeForBrand;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("typeForBrandDao")
public class TypeForBrandDaoImp implements TypeForBrandDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public TypeForBrandDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<TypeForBrand> selectTypeForBrandByMaterialBrand(String brandID) {
        return sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_typeforbrand where valid=true and materialbrandID=?")
                .addEntity(TypeForBrand.class)
                .setString(0, brandID)
                .list();
    }

    @Override
    public boolean update(TypeForBrand typeForBrand) {
        try {
            sessionFactory.getCurrentSession().update(typeForBrand);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public List selectAllTyepForBrands(int start, int limit) {
        var query = sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_typeforbrand")
                .addEntity(TypeForBrand.class);
        List list = List.of(query.list().size(), query.setFirstResult(start).setMaxResults(limit).list());
        return list;
    }

    @Override
    public TypeForBrand selectTypeForBrandByID(int typeID) {
        return (TypeForBrand) sessionFactory.getCurrentSession().get(TypeForBrand.class, typeID);
    }

    @Override
    public TypeForBrand selectTypeForBrandByCondition(String name, int materialBrandID) {
        return (TypeForBrand) sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_bxg where name=? and materialbrandID=?")
                .addEntity(TypeForBrand.class)
                .setString(0, name)
                .setInteger(1, materialBrandID)
                .uniqueResult();
    }

    @Override
    public boolean insert(TypeForBrand type) {
        try {
            sessionFactory.getCurrentSession().save(type);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(TypeForBrand type) {
        try {
            sessionFactory.getCurrentSession().delete(type);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

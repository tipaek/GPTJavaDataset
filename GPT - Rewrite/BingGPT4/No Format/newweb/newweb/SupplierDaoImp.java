package com.newweb.dao.base.imp;

import com.newweb.dao.base.SupplierDao;
import com.newweb.model.base.Supplier;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("supplierDao")
public class SupplierDaoImp implements SupplierDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public SupplierDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Supplier> selectAllSuppliers() {
        return sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_supplier where valid=true")
                .addEntity(Supplier.class)
                .list();
    }

    @Override
    public Supplier selectSupplierById(int id) {
        return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
    }

    @Override
    public boolean update(Supplier supplier) {
        try {
            sessionFactory.getCurrentSession().update(supplier);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Supplier selectSupplierByName(String name) {
        return (Supplier) sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_supplier where name=?")
                .addEntity(Supplier.class)
                .setString(0, name)
                .uniqueResult();
    }

    @Override
    public boolean insert(Supplier supplier) {
        try {
            sessionFactory.getCurrentSession().save(supplier);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public List selectAllSuppliers(int start, int limit) {
        var query = sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_supplier")
                .addEntity(Supplier.class);
        List list = List.of(query.list().size(), query.setFirstResult(start).setMaxResults(limit).list());
        return list;
    }

    @Override
    public boolean delete(Supplier supplier) {
        try {
            sessionFactory.getCurrentSession().delete(supplier);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

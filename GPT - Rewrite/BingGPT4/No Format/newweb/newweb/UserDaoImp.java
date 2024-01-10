package com.newweb.dao.base.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newweb.dao.base.UserDao;
import com.newweb.model.base.User;

import java.util.List;

@Repository("userDao")
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User selectUserByName(String name) {
        return (User) sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_user where userName=?")
                .addEntity(User.class)
                .setString(0, name)
                .uniqueResult();
    }

    @Override
    public User selectUserByID(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> selectUserByLinkID(int id) {
        return sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_user where linkid=?")
                .addEntity(User.class)
                .setInteger(0, id)
                .list();
    }

    @Override
    public boolean insertUser(User user) {
        try {
            sessionFactory.getCurrentSession().save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> selectAllUsers(int start, int limit) {
        var query = sessionFactory.getCurrentSession()
                .createSQLQuery("select * from t_user")
                .addEntity(User.class)
                .setFirstResult(start)
                .setMaxResults(limit);
        return query.list();
    }

    @Override
    public boolean update(User user) {
        try {
            sessionFactory.getCurrentSession().update(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

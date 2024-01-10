package com.newweb.service.base.imp;

import com.newweb.dao.base.UserDao;
import com.newweb.model.base.User;
import com.newweb.service.base.UserService;
import com.newweb.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByName(String name) {
        return userDao.selectUserByName(name);
    }

    @Override
    public User findUserByID(int id) {
        return userDao.selectUserByID(id);
    }

    @Override
    public User findUserByLinkID(int id) {
        List<User> users = userDao.selectUserByLinkID(id);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public boolean saveUser(User user) {
        return userDao.insertUser(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> queryAllUsers(int start, int limit) {
        List<User> users = userDao.selectAllUsers(start, limit);
        return users;
    }

    @Override
    public void userLoginRecord(HttpServletRequest request, User user) {
        user.setLoginCount(user.getLoginCount() + 1);
        user.setLastLoginTime(DateUtil.getLocationCurrentDate() + " " + DateUtil.getLocationCurrentTime());
        userDao.update(user);
    }

    @Override
    public boolean modify(User user) {
        return userDao.update(user);
    }
}

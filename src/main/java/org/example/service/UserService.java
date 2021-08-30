package org.example.service;

import org.example.entity.User;
import org.example.storage.UserDao;
import org.example.storage.hibernateDao.HibernateUserDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UserService {
    private final UserDao userDao;

    public UserService(@Qualifier("hibernateUserDao") UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user){
        if(user==null) return;
        userDao.add(user);
    }

    public boolean exists(String username){
        return userDao.exists(username);
    }

    public User getByUsername(String username){
        return userDao.getByUsername(username);
    }

}

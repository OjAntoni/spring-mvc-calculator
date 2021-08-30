package org.example.storage.hibernateDao;

import org.example.entity.User;
import org.example.storage.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class HibernateUserDao implements UserDao {

    private SessionFactory sessionFactory;

    public HibernateUserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void add(User u) {
        Session session = sessionFactory.getCurrentSession();
        session.save(u);
    }

    @Override
    @Transactional
    public boolean exists(String username) {
        boolean exists;
        Session session = sessionFactory.openSession();
        exists = session.createQuery("from User where username = :username")
                .setParameter("username",username)
                .list().size()>0;
        return exists;
    }

    @Override
    @Transactional
    public User getByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User where username= :username", User.class);
        query.setParameter("username", username);
        return query.list().size()==1 ? query.getSingleResult() : null;
    }
}

package org.example.storage.hibernateDao;

import lombok.AllArgsConstructor;
import org.example.entity.Operation;
import org.example.entity.User;
import org.example.storage.OperationDao;
import org.example.storage.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Component
public class HibernateOperationDao implements OperationDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void add(Operation operation) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(operation);
    }

    @Override
    @Transactional
    public List<Operation> getAll(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Operation> query = currentSession.createQuery("from Operation where user=:user", Operation.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void delete(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Operation operation= currentSession.get(Operation.class, id);
        currentSession.delete(operation);
    }
}

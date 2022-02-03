package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> allUsers() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public void deleteById(int id) {
        User u = getById(id);
        em.remove(u);
    }

    @Override
    public User edit(User user) {
        return em.merge(user);
    }

    @Override
    public User getById(int id) {
        return em.find(User.class, id);
    }
}

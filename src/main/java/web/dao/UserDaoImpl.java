package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDaoImpl implements UserDao{
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, User> users = new HashMap<>();
//
//    static {
//        User user1 = new User();
//        user1.setId(AUTO_ID.getAndIncrement());
//        user1.setName("Оля1");
//        user1.setLastName("Razumova1");
//        user1.setAge(1);
//        users.put(user1.getId(), user1);
//
//        User user2 = new User();
//        user2.setId(AUTO_ID.getAndIncrement());
//        user2.setName("ОЛя2");
//        user2.setLastName("Razumova2");
//        user2.setAge(2);
//        users.put(user2.getId(), user2);
//
//        User user3 = new User();
//        user3.setId(AUTO_ID.getAndIncrement());
//        user3.setName("Оля3");
//        user3.setLastName("Razumova3");
//        user3.setAge(3);
//        users.put(user3.getId(), user3);
//
//        User user4 = new User();
//        user4.setId(AUTO_ID.getAndIncrement());
//        user4.setName("Оля4");
//        user4.setLastName("Razumova4");
//        user4.setAge(4);
//        users.put(user4.getId(), user4);
//    }

//    @Override
//    public List<User> allUserss() {
//
//        return new ArrayList<>(users.values());
//    }
//
    @Override
    public void add(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public void edit(User user) {
        users.put(user.getId(),user);

    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }




//    private SessionFactory sessionFactory;
//@Autowired
private EntityManagerFactory entityManagerFactory;

//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    EntityManager entityManager = entityManagerFactory.createEntityManager();

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> allUsers(int page) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("from User").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
//    }

    @Override
    @SuppressWarnings("unchecked")

    public List<User> allUsers(int page) {

        return entityManager.createQuery("from User").setFirstResult(10 * (page - 1)).setMaxResults(10).getResultList();
    }



//    @Override
//    public void add(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(user);
//    }

//    @Override
//    public void delete(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(user);
//    }
//
//    @Override
//    public void edit(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(user);
//    }

//    @Override
//    public User getById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(User.class, id);
//    }
}

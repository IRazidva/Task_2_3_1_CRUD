package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;

import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public User add() {
        User user = new User("Name","Lastname",100);
        userDao.add(user);
        return user;
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User edit(User user) {
        return userDao.edit(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }


    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

}

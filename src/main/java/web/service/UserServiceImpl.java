package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repo.UserRepository;
import web.user.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add() {
        User user = new User("Name","Lastname",100);
        User savedUser = userRepository.saveAndFlush(user);
        return savedUser;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User edit(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }


    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

//
//    @Override
//    @Transactional
//
//    public void add(User user) {
//        userDao.add(user);
//
//    }
//
//    @Override
//    @Transactional
//
//    public void delete(User user) {
//        userDao.delete(user);
//
//    }
//
//    @Override
//    @Transactional
//
//    public void edit(User user) {
//        userDao.edit(user);
//
//    }
//
//    @Override
//    @Transactional
//
//    public User getById(int id) {
//        return userDao.getById(id);
//    }
}

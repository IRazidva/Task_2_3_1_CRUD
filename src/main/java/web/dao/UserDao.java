package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void deleteById(int id);
    User edit(User user);
    User getById(int id);
}

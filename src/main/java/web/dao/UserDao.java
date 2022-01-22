package web.dao;

import web.user.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers(int page);
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
}

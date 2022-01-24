package web.service;

import web.user.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    User add();
    void delete(User user);
    void deleteById(int id);
    User edit(User user);
    User getById(int id);
}

package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User show(int id);
    void save(User user);
    void update(int id, User newVersion);
    void delete(int id);
}

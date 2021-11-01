package web.dao;

import web.model.User;

import java.util.List;

public interface Dao {
    List<User> getUsers();
    User show(long id);
    void save(User user);
    void update(User newVersion);
    void delete(long id);
}

package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.Dao;
import web.model.User;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    private final Dao dao;

    public UserServiceImpl(Dao dao) {
        this.dao = dao;
    }


    public void save(User user){
        dao.save(user);
    }

    public List<User> getUsers(){
        return dao.getUsers();
    }

    public User show(long id){
        return dao.show(id);
    }

    public void delete(long id){
        dao.delete(id);
    }

    public void update(User user){
        dao.update(user);
    }
}

package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    private Dao dao = new Dao();

    @Transactional
    public void save(User user){
        dao.save(user);
    }

    @Transactional
    public List<User> getUsers(){
        return dao.getUsers();
    }

    @Transactional
    public User show(int id){
        return dao.show(id);
    }

    @Transactional
    public void delete(int id){
        dao.delete(id);
    }

    @Transactional
    public void update(int id , User user){
        dao.update(id, user);
    }
}

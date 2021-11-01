package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class DaoImpl implements Dao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsers() {
        return entityManager.createQuery("FROM User ", User.class).getResultList();
    }

    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User newVersion) {
        User oldVersion = show(newVersion.getId());
        oldVersion.setName(newVersion.getName());
        oldVersion.setLastName(newVersion.getLastName());
        oldVersion.setAge(newVersion.getAge());
        entityManager.merge(oldVersion);
    }

    public void delete(long id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}

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

    public User show(int id) {
        TypedQuery<User> q = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
        q.setParameter("id", id);
        return q.getResultList().stream().findAny().orElse(null);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(int id, User newVersion) {
        User oldVersion= show(id);
        oldVersion.setName(newVersion.getName());
        oldVersion.setLastName(newVersion.getLastName());
        oldVersion.setAge(newVersion.getAge());
        entityManager.merge(oldVersion);
    }

    public void delete(int id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}

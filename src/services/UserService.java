package services;

import entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserService {

    @PersistenceContext
    private EntityManager em;

    public List<User> getAll() {
        return em
                .createNamedQuery(User.GET_ALL, User.class)
                .getResultList();
    }

    public User getById(int id) {
        return em
                .createNamedQuery(User.GET_BY_ID, User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public void insert(User u) {
        em.persist(u);
    }
}

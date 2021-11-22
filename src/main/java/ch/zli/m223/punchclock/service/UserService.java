package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.PasswordAnalysis;
import ch.zli.m223.punchclock.domain.User;

@ApplicationScoped
@RolesAllowed("Admin")
public class UserService {
    @Inject
    private EntityManager entityManager;

    @Transactional 
    public User addUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        var query = entityManager.createQuery("FROM User");
        return query.getResultList();
    }

    @Transactional
    public void deleteUser(Long id) {
        entityManager.remove(getUser(id));
    }

    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void updateUser(User entry) {
        entityManager.merge(entry);
    }

    public List<PasswordAnalysis> passwordLengthAnalysis() {
        var query = entityManager.createQuery("SELECT LENGTH(u.password), COUNT(u) AS cnt FROM User u GROUP BY LENGTH(u.password) HAVING LENGTH(u.password) > 8");
        return query.getResultList();
    }
}

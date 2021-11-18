package ch.zli.m223.punchclock.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.User;

@ApplicationScoped
public class UserService {
    @Inject
    private EntityManager entityManager;

    @Transactional 
    public User addUser(User user) {
        entityManager.persist(user);
        return user;
    }
}

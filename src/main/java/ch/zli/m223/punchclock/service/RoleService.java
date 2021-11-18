package ch.zli.m223.punchclock.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.punchclock.domain.Role;

@ApplicationScoped
public class RoleService {
    @Inject
    private EntityManager entityManager;

    public Role getRole(Long id) {
        return entityManager.find(Role.class, id);
    }
}

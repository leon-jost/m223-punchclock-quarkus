package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.punchclock.domain.Role;

@ApplicationScoped
@RolesAllowed("Admin")
public class RoleService {
    @Inject
    private EntityManager entityManager;

    public Role getRole(Long id) {
        return entityManager.find(Role.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Role> getRoles() {
        var query = entityManager.createQuery("FROM Role");
        return query.getResultList();
    }
}

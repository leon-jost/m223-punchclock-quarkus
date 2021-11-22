package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import ch.zli.m223.punchclock.domain.Category;

@ApplicationScoped
@RolesAllowed("Admin")
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Category> getCategories() {
        var query = entityManager.createQuery("FROM Category");
        return query.getResultList();
    }
}

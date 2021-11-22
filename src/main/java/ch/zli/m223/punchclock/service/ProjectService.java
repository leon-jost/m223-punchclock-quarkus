package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Project;

@ApplicationScoped
@RolesAllowed("Admin")
public class ProjectService {
    @Inject
    private EntityManager entityManager;

    @Transactional 
    public Project addProject(Project project) {
        entityManager.persist(project);
        return project;
    }

    @SuppressWarnings("unchecked")
    public List<Project> getProjects() {
        var query = entityManager.createQuery("FROM Project");
        return query.getResultList();
    }

    @Transactional
    public void deleteProject(Long id) {
        entityManager.remove(getProject(id));
    }

    public Project getProject(Long id) {
        return entityManager.find(Project.class, id);
    }

    @Transactional
    public void updateProject(Project project) {
        entityManager.merge(project);
    }
}

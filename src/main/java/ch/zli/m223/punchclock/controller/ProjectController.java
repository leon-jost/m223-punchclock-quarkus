package ch.zli.m223.punchclock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.service.ProjectService;

@Path("/project")
@Tag(name = "Project", description = "Handling of projects")
public class ProjectController {

    @Inject
    ProjectService projectService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets all projects", description = "Gets all projects")
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets one project", description = "Gets one project")
    public Project getProject(@PathParam("id") Long id) {
        return projectService.getProject(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new project", description = "The newly created project is returned. The id may not be passed.")
    public Project addProject(Project project) {
        return projectService.addProject(project);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a project", description = "Deletes a project")
    public void deleteProject(@PathParam("id") Long id) {
        projectService.deleteProject(id);
    }

    @PUT
    @Operation(summary = "Update a project", description = "Updates a project")
    public void updateProject(Project project) {
        projectService.updateProject(project);
    }
}

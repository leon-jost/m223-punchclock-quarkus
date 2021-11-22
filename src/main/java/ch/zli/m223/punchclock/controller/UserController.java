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

import ch.zli.m223.punchclock.domain.PasswordAnalysis;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;

@Path("/user")
@Tag(name = "User", description = "Handling of users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets all users", description = "")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets one user", description = "")
    public User getUser(@PathParam("id") Long id) {
        return userService.getUser(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new user", description = "The newly created user is returned. The id may not be passed.")
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete an user", description = "Deletes an user")
    public void deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
    }

    @PUT
    public void updateUser(User entry) {
        userService.updateUser(entry);
    }

    @GET
    @Path("/passwordLengthAnalysis")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Analyses the different lengths of the user passwords", description = "Returns the amount of passwords with a certain length that are above 8. eg. 10 (length of password), 3 (amount of times used/set by user)")
    public List<PasswordAnalysis> passwordLengthAnalysis() {
        return userService.passwordLengthAnalysis();
    }
}

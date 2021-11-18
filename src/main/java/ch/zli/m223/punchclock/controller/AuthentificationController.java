package ch.zli.m223.punchclock.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.AuthenticationService;
import ch.zli.m223.punchclock.service.UserService;

@Path("/auth")
public class AuthentificationController {
    @Inject
    AuthenticationService authenticationService;
    @Inject UserService userService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String login(User user) {
        if (authenticationService.checkIfUserExists(user)) {
            return authenticationService.generateValidJwtToken(user.getUsername());
        } else {
            throw new NotAuthorizedException("User: " + user.getUsername() + " was not found.");
        }
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String register(User user) {
        if (authenticationService.checkIfUserExists(user)) {
            throw new NotAuthorizedException("User already exists.");
        } else {
            userService.addUser(user);
            return authenticationService.generateValidJwtToken(user.getUsername());
        }
    }
}

package ch.zli.m223.punchclock.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.punchclock.domain.Role;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.AuthenticationService;
import ch.zli.m223.punchclock.service.RoleService;
import ch.zli.m223.punchclock.service.UserService;

@Path("/auth")
@Tag(name = "Authentication", description = "Handling of authentication")
public class AuthentificationController {
    @Inject
    AuthenticationService authenticationService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Performs a login", description = "Returns a JWT Token if the credentials are correct.")
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
    @Operation(summary = "Performs a registration", description = "Creates a new user and returns a JWT Token if the credentials are correct.")
    public String register(User user) {
        if (authenticationService.checkIfUserExists(user)) {
            throw new NotAuthorizedException("User already exists.");
        } else {
            authenticationService.registerUser(user);
            return authenticationService.generateValidJwtToken(user.getUsername());
        }
    }
}

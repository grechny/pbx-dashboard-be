package by.sysadmins.dashboard.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import by.sysadmins.dashboard.dto.UserProfileDto;
import by.sysadmins.dashboard.services.UserProfileService;


/**
 * Created by grechny on 07.01.2016.
 * Implements authorization by URL path /user/login
 */
@Component
@Path("/api/user")
public class UserActionsController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserActionsController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GET
    @Path("/profile")
    @Produces("application/json")
    public UserProfileDto getUserProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userProfileService.getUserProfile(username);
    }

    @POST
    @Path("/profile")
    @Consumes("application/json")
    @Produces("application/json")
    public UserProfileDto createUserProfile(UserProfileDto userProfileDto) {
        return userProfileService.createUserProfile(userProfileDto);
    }

    @PUT
    @Path("/profile/{username}")
    @Consumes("application/json")
    @Produces("application/json")
    public UserProfileDto updateUserProfile(UserProfileDto userProfileDto,
                                            @PathParam("username") String username) {
        if (!username.equals(userProfileDto.getUsername())){
            throw new IllegalArgumentException("Username cannot be changed");
        }
        return userProfileService.updateUserProfile(userProfileDto);
    }

    @DELETE
    @Path("/profile/{username}")
    public void deleteUserProfile(@PathParam("username") String username) {
        userProfileService.deleteUserProfile(username);
    }

//    @POST
//    @Path("/password")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Map getEncryptPassword(Map<String, String> map) {
//        for (Map.Entry<String, String> iMap : map.entrySet()) {
//            String hashedPassword = encryptService.encryptPassword(iMap.getValue());
//            map.put(iMap.getKey(), hashedPassword);
//        }
//        return map;
//    }
}
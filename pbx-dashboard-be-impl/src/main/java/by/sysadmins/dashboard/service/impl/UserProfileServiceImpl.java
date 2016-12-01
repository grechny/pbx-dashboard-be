package by.sysadmins.dashboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import by.sysadmins.dashboard.dto.UserProfileDto;
import by.sysadmins.dashboard.entities.Roles;
import by.sysadmins.dashboard.entities.UserRoles;
import by.sysadmins.dashboard.entities.Users;
import by.sysadmins.dashboard.entities.repositories.UsersRepository;
import by.sysadmins.dashboard.services.UserProfileService;

@Component
public class UserProfileServiceImpl implements UserProfileService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserProfileServiceImpl(final UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserProfileDto getUserProfile(String username) {
        Users user = usersRepository.findByUsername(username);

        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setUsername(user.getUsername());
        userProfileDto.setEnabled(user.getEnabled());
        userProfileDto.setCompanyName(user.getCompanies().getCompanyName());

        return userProfileDto;
    }

    @Override
    public UserProfileDto createUserProfile(UserProfileDto userProfileDto) {
        return null;
    }

    @Override
    public UserProfileDto updateUserProfile(UserProfileDto userProfileDto) {
        return null;
    }

    @Override
    public void deleteUserProfile(String username) {
        Users user = usersRepository.findByUsername(username);
        if (user != null){
            usersRepository.delete(user.getIdUser());
        }

    }

    @Override
    public List<String> getUserRoles(String username) {
        Users user = usersRepository.findByUsername(username);

        List<UserRoles> userRolesList = user.getUserRoles();
        List<Roles> roles = userRolesList.stream().map(UserRoles::getRoles).collect(Collectors.toList());
        List<String> userRoles = new ArrayList<>();
        for (Roles role : roles) {
            userRoles.add(role.getRole());
        }

        return userRoles;
    }

    @Override
    public String getHashedUserPassword(String username) {
        Users user = usersRepository.findByUsername(username);
        return user.getPassword();
    }


}

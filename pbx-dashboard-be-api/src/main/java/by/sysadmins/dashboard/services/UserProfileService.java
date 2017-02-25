package by.sysadmins.dashboard.services;

import java.util.List;

import by.sysadmins.dashboard.dto.UserProfileDto;

public interface UserProfileService {

    UserProfileDto createUserProfile(UserProfileDto userProfileDto);

    UserProfileDto getUserProfile(String username);

    List<String> getUserRoles(String username);

    String getHashedUserPassword(String username);

    UserProfileDto updateUserProfile(UserProfileDto userProfileDto);

    void deleteUserProfile(String username);
}

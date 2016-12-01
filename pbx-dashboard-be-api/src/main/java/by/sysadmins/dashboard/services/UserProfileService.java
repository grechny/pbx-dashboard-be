package by.sysadmins.dashboard.services;

import java.util.List;

import by.sysadmins.dashboard.dto.UserProfileDto;

public interface UserProfileService {

    UserProfileDto getUserProfile(String username);

    UserProfileDto createUserProfile(UserProfileDto userProfileDto);

    UserProfileDto updateUserProfile(UserProfileDto userProfileDto);

    void deleteUserProfile(String username);

    List<String> getUserRoles(String username);

    String getHashedUserPassword(String username);
}

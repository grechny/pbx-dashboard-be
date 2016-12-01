package by.sysadmins.dashboard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import by.sysadmins.dashboard.dto.UserProfileDto;
import by.sysadmins.dashboard.services.UserProfileService;

@Component
public class RestUserDetailsService implements UserDetailsService {

    private final UserProfileService userService;

    @Autowired
    public RestUserDetailsService(UserProfileService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;
        List<GrantedAuthority> authorities = new ArrayList<>();

        UserProfileDto user = userService.getUserProfile(username);
        String userPassword = userService.getHashedUserPassword(username);
        List<String> userRoles = userService.getUserRoles(username);

        authorities.addAll(userRoles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        loadedUser = new User(user.getUsername(), userPassword, user.getEnabled(), true, true, true, authorities);
        return loadedUser;
    }
}

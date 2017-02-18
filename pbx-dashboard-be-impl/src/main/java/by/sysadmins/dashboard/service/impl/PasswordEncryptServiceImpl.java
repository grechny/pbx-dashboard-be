package by.sysadmins.dashboard.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import by.sysadmins.dashboard.services.PasswordEncryptService;

@Component
public class PasswordEncryptServiceImpl implements PasswordEncryptService {

    private final PasswordEncoder passwordEncoder;

    public PasswordEncryptServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}

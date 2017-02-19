package by.sysadmins.dashboard.services;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface PasswordEncryptService {
    String encryptPassword(String password);

    PasswordEncoder getPasswordEncoder();
}

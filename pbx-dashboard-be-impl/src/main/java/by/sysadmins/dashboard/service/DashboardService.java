package by.sysadmins.dashboard.service;

import by.sysadmins.dashboard.entities.Layouts;
import by.sysadmins.dashboard.entities.Users;
import by.sysadmins.dashboard.entities.repositories.LayoutsRepository;
import by.sysadmins.dashboard.entities.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private LayoutsRepository layoutsRepository;

    public String getLayout (String username) {
        return layoutsRepository.getLayoutByUsername(username);
    }

    /**
     * Creating layout string for authorized user
     * @param username Authorized user's username
     * @param layout Layout string from FE
     * @return -1 if not saved, 0 - if layouts already exists, 1 - if OK
     */
    public synchronized Integer createLayout (String username, String layout){
        Users user = usersRepository.findByUsername(username);
        Layouts layouts = layoutsRepository.findByUsers(user);
        if (layouts != null)
            return 0;
        layouts = new Layouts(usersRepository.findByUsername(username), layout);
        return layoutsRepository.save(layouts) != null ? 1 : -1;
    }

    /**
     * Updating layout string
     * @param username Authorized user's username
     * @param layout Layout string from FE
     * @return -1 if not saved, 0 - if layouts not exists, 1 - if OK
     */
    public synchronized Integer updateLayout (String username, String layout){
        Users user = usersRepository.findByUsername(username);
        Layouts layouts = layoutsRepository.findByUsers(user);
        if (layouts == null)
            return 0;
        layouts.setLayout(layout);
        return layoutsRepository.save(layouts) != null ? 1 : -1;
    }
}

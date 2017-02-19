package by.sysadmins.dashboard.rest.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import by.sysadmins.dashboard.rest.controllers.UserActionsController;
import by.sysadmins.dashboard.rest.filters.CorsResponseFilter;

/**
 * Created by grechny on 07.01.2016.
 * Register all the Jersey endpoints
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CorsResponseFilter.class);
        register(UserActionsController.class);
//        register(CallTracking.class);
//        register(Dashboard.class);
    }

}

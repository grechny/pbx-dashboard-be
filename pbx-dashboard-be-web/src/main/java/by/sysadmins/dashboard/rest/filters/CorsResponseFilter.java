package by.sysadmins.dashboard.rest.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;

/**
 * Created by grechny on 13.01.2016.
 * Enable CORS support for application
 */
@PreMatching
public class CorsResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
//        response.getHeaders().add("Access-Control-Allow-Origin", "*");
//        response.getHeaders().add("Access-Control-Allow-Headers", "accept, content-type, x-requested-with");
//        response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");

        if (request.getRequest().getMethod().equals("OPTIONS")) {
            // Just send a OK signal back to the browser
            response.setStatusInfo(Response.Status.OK);
        }
    }
}
package by.sysadmins.dashboard.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import by.sysadmins.dashboard.dto.InboundRouteDto;
import by.sysadmins.dashboard.services.InboundRoutesService;

@Component
@Path("/api/dashboard/connectivity")
public class InboundRoutesController {

    private final InboundRoutesService inboundRoutesService;

    @Autowired
    public InboundRoutesController(InboundRoutesService inboundRoutesService) {
        this.inboundRoutesService = inboundRoutesService;
    }

    @GET
    @Path("/inbound-routes")
    @Produces("application/json")
    public List<InboundRouteDto> getAllRoutes() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return inboundRoutesService.getAllInboundRoutes(username);
    }
}

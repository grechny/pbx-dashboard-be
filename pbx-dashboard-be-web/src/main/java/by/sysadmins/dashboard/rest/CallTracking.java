package by.sysadmins.dashboard.rest;
//
//import by.sysadmins.dashboard.dto.InboundRouteDto;
//import by.sysadmins.dashboard.service.CallTrackingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//
//import java.util.List;
//
///**
// * Created by grechny on 07.01.2016.
// */
//@Component
//@Path("/api/calltracking")
//public class CallTracking {
//
//    @Autowired
//    private CallTrackingService callTrackingService;
//
//    @GET
//    @Path("/prefixes")
//    @Produces("application/json")
//    public List<InboundRouteDto> getPrefixes() {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        return callTrackingService.getPrefixList(username);
//    }
//}

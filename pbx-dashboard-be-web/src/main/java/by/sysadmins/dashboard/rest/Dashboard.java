package by.sysadmins.dashboard.rest;
//
//import by.sysadmins.dashboard.service.DashboardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.Response;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//@Path("/api/dashboard")
//public class Dashboard {
//
//    @Autowired
//    private DashboardService dashboardService;
//
//    private String getUsername (){
//        return SecurityContextHolder.getContext().getAuthentication().getName();
//    }
//
//    @GET
//    @Path("/layout")
//    @Produces("application/json")
//    public Map getLayout(){
//        Map<String, String> layout = new HashMap<>();
//        layout.put("layout", dashboardService.getLayout(getUsername()));
//        return layout;
//    }
//
//    @POST
//    @Path("/layout")
//    @Consumes("application/json")
//    public Response createLayout(Map<String, String> map){
//        if (map.get("layout") == null) {
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        return getResponseByStatus(dashboardService.createLayout(getUsername(), map.get("layout")));
//    }
//
//    @PUT
//    @Path("/layout")
//    @Consumes("application/json")
//    public Response updateLayout(Map<String, String> map){
//        if (map.get("layout") == null) {
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        return getResponseByStatus(dashboardService.updateLayout(getUsername(), map.get("layout")));
//    }
//
//    private Response getResponseByStatus (Integer status){
//        if (status == 1){
//            return Response.status(Response.Status.OK).build();
//        } else if (status == 0){
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        } else {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//}

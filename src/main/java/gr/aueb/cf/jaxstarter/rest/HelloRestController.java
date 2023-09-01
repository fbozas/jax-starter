package gr.aueb.cf.jaxstarter.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloRestController {

    @GET
    @Path("/get-hello-cf")
    @Produces(MediaType.TEXT_PLAIN)
    public  String getHello(){
        return "Hello Coding Factory";
    }
    
    @GET
    @Path("/get-hello-res")
    @Produces(MediaType.TEXT_PLAIN)
    public  Response getHelloRes(){
//        return Response.ok("Hello Coding Factory").build();
        return Response.status(Response.Status.OK).entity("Hello Coding Factory").build();
    }
}

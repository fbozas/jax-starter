package gr.aueb.cf.jaxstarter.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloRestController {

    @GET
    @Path("/get-hello-cf")
    @Produces(MediaType.TEXT_PLAIN)
    public  String getHello(){
        return "Hello Coding Factory";
    }
}

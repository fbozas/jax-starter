package gr.aueb.cf.jaxstarter.rest;

import gr.aueb.cf.jaxstarter.model.Teacher;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;

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

    @GET
    @Path("/get-teacher")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getTeacher(){
        return Response.status(Response.Status.OK).entity(new Teacher(1L,"123456", "Nick", "Pappas")).build();
    }

    @POST
    @Path("/messages")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public  Response insertMessage(@FormParam("message") String message, @Context UriInfo uriInfo){
        // insert to DB
        String id = "1";

        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder();
        URI uri = uriBuilder.path(id).build();
        return Response.status(Response.Status.CREATED).location(uri).entity(message).build();
    }

    @GET
    @Path("/messages/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getMessage(@PathParam("id") String id){
        // Get from DB the message with id == 1 :P
        String message = "Hello World!";
        return Response.status(Response.Status.OK).entity(message).build();
    }

}

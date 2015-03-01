package ru.vmakarenko.rest;

import ru.vmakarenko.common.AppConsts;
import ru.vmakarenko.entities.Test;
import ru.vmakarenko.services.TestService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */

@ApplicationScoped
@Path("test")
public class TestResource {
    @Inject
    private TestService testService;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Test getById(@PathParam(value = "id") Long id){
        return testService.getById(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateExpense(Test expense){
        return Response.ok(testService.update(expense)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createExpense(Test expense){
        return Response.ok(
                testService.create(expense
        )).build();
    }


    @DELETE
    @Path("{id}")
    public Response deleteExpense(@PathParam(value = "id") Long id){
        testService.delete(id);
        return Response.ok().build();
    }

}

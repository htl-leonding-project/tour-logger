package at.htl.boundary;

import at.htl.model.Tour;
import at.htl.persistence.TourRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/tours")
public class TourResource {

    @Inject
    TourRepository tr;

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tour> getAllTours(){
        return tr.listAll();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public long countTours(){
        return tr.count();
    }

    @POST
    @Transactional
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Tour tour, @Context UriInfo info) {
        tr.persist(tour);
        return Response.
                created(URI.create(info.getPath() + "/" + tour.getId()))
                .build();
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tour> findAll(){
        return tr.listAll();
    }

    @DELETE
    @Transactional
    @Path("/deletebyid/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") long id) {
        try{
            tr.deleteById(id);
            return Response.noContent().build();
        } catch (IllegalArgumentException e){
            return Response.status(400).header("Reason", "Tour mit id " + id + " existiert nicht").build();
        }

    }


}
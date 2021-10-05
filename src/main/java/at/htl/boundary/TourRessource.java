package at.htl.boundary;

import at.htl.model.Tour;
import at.htl.persistance.TourRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/api")
@ApplicationScoped
public class TourRessource {

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

}

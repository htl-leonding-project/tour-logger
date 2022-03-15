package at.htl.client;

import at.htl.model.Tour;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:3000")
@Path("/tours")
public interface TourClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tour> getAll();

    @POST
    public Tour saveTour(Tour tour);

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id);

}

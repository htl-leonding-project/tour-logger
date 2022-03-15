package at.htl.client;

import at.htl.model.Tour;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:3000")
@Path("/tours")
public interface TourClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tour> getAll();

}

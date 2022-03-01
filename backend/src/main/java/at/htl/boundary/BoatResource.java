package at.htl.boundary;

import at.htl.model.Boat;
import at.htl.persistence.BoatRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/boats")
public class BoatResource {

    @Inject
    BoatRepository br;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Boat> findAll(){
        return br.listAll();
    }


}

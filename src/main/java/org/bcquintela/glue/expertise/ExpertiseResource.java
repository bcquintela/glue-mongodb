package org.bcquintela.glue.expertise;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/expertise")
public class ExpertiseResource {

    @Inject
    ExpertiseService expertiseService;

    @GET
    public List<Expertise> list() {
        return expertiseService.list();
    }

    @POST
    public List<Expertise> add(Expertise expertise) {
        expertiseService.add(expertise);
        return list();
    }
}

package org.bcquintela.glue.team;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/teams")
public class TeamResource {

    @Inject
    TeamService teamService;

    @GET
    public List<Team> list() {
        return teamService.list();
    }

    @POST
    public List<Team> add(Team team) {
        teamService.add(team);
        return list();
    }
}

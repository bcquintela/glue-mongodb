package org.bcquintela.glue.project;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/projects")
public class ProjectResource {

    @Inject ProjectService projectService;

    @GET
    public List<Project> list() {
        return projectService.list();
    }

    @POST
    public List<Project> add(Project project) {
        projectService.add(project);
        return list();
    }
}

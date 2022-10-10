package com.ctw.glue.unit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/units")
public class UnitResource {

    @Inject
    UnitService unitService;

    @GET
    public List<Unit> list() {
        return unitService.list();
    }

    @POST
    public List<Unit> add(Unit unit) {
        unitService.add(unit);
        return list();
    }
}

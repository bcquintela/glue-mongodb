package org.bcquintela.glue.employee;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/employees")
public class EmployeeResource {

    @Inject
    EmployeeService employeeService;

    @GET
    public List<Employee> list() {
        return employeeService.list();
    }

    @POST
    public List<Employee> add(Employee employee) {
        employeeService.add(employee);
        return list();
    }
}

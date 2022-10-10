package org.bcquintela.glue.employee;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class EmployeeService {

    @Inject MongoClient mongoClient;

    public List<Employee> list(){
        List<Employee> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Employee employee = new Employee();
                employee.setName(document.getString("name"));
                employee.setEmployeeNo(document.getString("employeeNo"));
                employee.setId(document.getString("id"));
                employee.setUnit(document.getString("unit"));
                employee.setProjects(document.getList("projects", String.class));
                employee.setExpertise(document.getList("expertise", String.class));
                list.add(employee);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(Employee employee){
        Document document = new Document()
                .append("name", employee.getName())
                .append("employeeNo", employee.getEmployeeNo())
                .append("id", UUID.randomUUID().toString())
                .append("unit", employee.getUnit())
                .append("projects", employee.getProjects())
                .append("expertise", employee.getExpertise());
        getCollection().insertOne(document);
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("glue").getCollection("employees");
    }
}

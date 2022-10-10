package org.bcquintela.glue.project;

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
public class ProjectService {

    @Inject MongoClient mongoClient;

    public List<Project> list(){
        List<Project> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Project project = new Project();
                project.setName(document.getString("name"));
                project.setDescription(document.getString("description"));
                project.setId(document.getString("id"));
                project.setUnit(document.getString("unit"));
                project.setTeams(document.getList("teams", String.class));
                list.add(project);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(Project project){
        Document document = new Document()
                .append("name", project.getName())
                .append("description", project.getDescription())
                .append("id", UUID.randomUUID().toString())
                .append("unit", project.getUnit())
                .append("teams", project.getTeams());
        getCollection().insertOne(document);
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("glue").getCollection("projects");
    }
}

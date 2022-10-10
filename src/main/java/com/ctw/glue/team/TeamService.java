package com.ctw.glue.team;

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
public class TeamService {

    @Inject
    MongoClient mongoClient;

    public List<Team> list(){
        List<Team> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Team team = new Team();
                team.setName(document.getString("name"));
                team.setDescription(document.getString("description"));
                team.setId(document.getString("id"));
                list.add(team);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(Team team){
        Document document = new Document()
                .append("name", team.getName())
                .append("description", team.getDescription())
                .append("id", UUID.randomUUID().toString());
        getCollection().insertOne(document);
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("glue").getCollection("teams");
    }
}

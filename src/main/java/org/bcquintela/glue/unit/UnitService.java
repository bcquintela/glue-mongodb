package org.bcquintela.glue.unit;

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
public class UnitService {

    @Inject
    MongoClient mongoClient;

    public List<Unit> list(){
        List<Unit> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Unit unit = new Unit();
                unit.setName(document.getString("name"));
                unit.setDescription(document.getString("description"));
                unit.setId(document.getString("id"));
                unit.setTeams(document.getList("teams", String.class));
                list.add(unit);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(Unit unit){
        Document document = new Document()
                .append("name", unit.getName())
                .append("description", unit.getDescription())
                .append("id", UUID.randomUUID().toString())
                .append("teams", unit.getTeams());
        getCollection().insertOne(document);
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("glue").getCollection("units");
    }
}

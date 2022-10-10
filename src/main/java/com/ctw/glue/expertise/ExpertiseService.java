package com.ctw.glue.expertise;

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
public class ExpertiseService {

    @Inject MongoClient mongoClient;

    public List<Expertise> list(){
        List<Expertise> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Expertise expertise = new Expertise();
                expertise.setName(document.getString("name"));
                expertise.setId(document.getString("id"));
                list.add(expertise);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(Expertise expertise){
        Document document = new Document()
                .append("name", expertise.getName())
                .append("id", UUID.randomUUID().toString());
        getCollection().insertOne(document);
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("glue").getCollection("expertise");
    }
}

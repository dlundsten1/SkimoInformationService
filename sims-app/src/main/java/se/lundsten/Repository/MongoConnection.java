package se.lundsten.Repository;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public final class MongoConnection {

    public MongoDatabase initConnection () {
    MongoClient mongoClient = MongoClients.create();
    MongoDatabase database = mongoClient.getDatabase(DbPath.DB_NAME);
    return database;
    }

}

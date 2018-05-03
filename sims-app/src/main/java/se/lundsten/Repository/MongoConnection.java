package se.lundsten.Repository;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import se.lundsten.model.Competition;

public final class MongoConnection {

    public MongoDatabase initMongoDatabase () {
    MongoClient mongoClient = MongoClients.create(DbPath.DB_HOST_CONNECTION);
    MongoDatabase database = mongoClient.getDatabase(DbPath.DB_NAME);

    return database;
    }



}

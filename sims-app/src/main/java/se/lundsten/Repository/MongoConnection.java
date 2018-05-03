package se.lundsten.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public final class MongoConnection {
   private MongoClient mongoClient = new MongoClient(DbPath.DB_HOST_CONNECTION, DbPath.DB_PORT);
   private DB database = mongoClient.getDB(DbPath.DB_NAME);
   private DBCollection collection = database.getCollection(DbPath.DB_INDIVIDUALS_COLLECTION);
}

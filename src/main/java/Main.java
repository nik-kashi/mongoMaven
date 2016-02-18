import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.function.Consumer;

/**
 * Created by Mohsen Kashi on 2/18/16.
 */
public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();//no argument, beacuase it is located in localhost and default port
        MongoDatabase db = mongoClient.getDatabase("mydb");
        MongoCollection<Document> coll = db.getCollection("testCollection");
        coll.insertOne(new Document("name", "Gholi"));

        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new BasicDBObject("x", 203).append("y", 102));

        coll.insertOne(doc);


        coll.find().forEach(new Consumer<Document>() {
            public void accept(Document document) {
                System.err.println("Current document:" + document);
            }
        });
        System.err.println("Count now is:" + coll.count());


    }
}

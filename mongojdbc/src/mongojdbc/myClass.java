package mongojdbc;

import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class myClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get database
		//create collection
		//get collection
		//insert into collection
		//read from out collection
		//update our collection
		//delete from our collection
		MongoClient mongo=new MongoClient("localhost",27017);
		System.out.println("Connection establised");
		
		
		MongoDatabase db=mongo.getDatabase("xyz");
		
		db.createCollection("student");
		
		MongoCollection<Document> collec=db.getCollection("student");
		
		Document d1=new Document("name","ABC").append("Id", "1");
		Document d2=new Document("name","DEF").append("Id", "2");
		Document d3=new Document("name","XYZ").append("Id", "3");
		Document d4=new Document("name","PQR").append("Id", "4");
		
		collec.insertMany(List.of(d1,d2,d3,d4));
		System.out.println("Documents inserted successfully!");
				
		
		FindIterable<Document> iterdoc=collec.find();
		
		Iterator it=iterdoc.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("Documents read successfully!");
		
		
		collec.updateOne(Filters.eq("name","ABC"),Updates.set("name", "KLM"));
		
		System.out.println("Document updated successfully");
		
		collec.deleteOne(Filters.eq("name","PQR"));
		
		System.out.println("Document deleted successfully");
		
		
		
		
	}

}

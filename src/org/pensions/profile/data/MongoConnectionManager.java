package org.pensions.profile.data;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public enum MongoConnectionManager {
	
	GET_MANAGER;
	

	
	private MongoClient mongoClient;
	private DB db;

	@SuppressWarnings("deprecation")
	private MongoConnectionManager() {


		mongoClient = new MongoClient( "localhost" , 27017 );
		db = mongoClient.getDB( "test" );
		System.out.println("connected to mongo db");
	}
	
	public DB getStore() {
		return this.db;
	}
	
}

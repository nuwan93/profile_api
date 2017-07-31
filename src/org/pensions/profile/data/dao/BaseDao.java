package org.pensions.profile.data.dao;

import org.pensions.profile.data.MongoConnectionManager;

import com.mongodb.DB;

public class BaseDao {
	
	private DB store = null;

	public BaseDao() {
		this.store = MongoConnectionManager.GET_MANAGER.getStore();
	}

	public DB getDs() {
		return this.store;
	}

}

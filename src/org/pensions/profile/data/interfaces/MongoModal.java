package org.pensions.profile.data.interfaces;

import org.bson.conversions.Bson;

public interface MongoModal {

	/*
	 *get the bson out of the given dto
	 * @return a bson
	 */
	Bson getDocument();
	
	
}

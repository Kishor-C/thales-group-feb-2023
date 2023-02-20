package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	@Autowired
	@Qualifier("b3")
	private DBSource db;

	public void setDb(DBSource db) {
		this.db = db;
	}
	
	public void store() {
		System.out.println("___store is using "+db.getUsername()+"____");
	}
}

package com.mdtsoft.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TestDB {

	@Test
	void hasAConnection() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false", "root", "123456.");
			assertTrue(conn != null);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package ques2;

import java.sql.*;
import ques2.ConnectionFactory;

public class BatchProcessing {

	public static void main(String[] args) {

		Connection connection = ConnectionFactory.getConnection();

		// WITH BATCH PROCESSING
		long start = System.currentTimeMillis();

		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement("insert into batchTable(name) values(?)");
			for (long i = 1; i <= 10000; i++) {
				pstmt.setString(1, "Harshdeep" + i);

				pstmt.addBatch(); 
				if (i % 200 == 0) {
					pstmt.executeBatch(); 
				}
			}
			connection.commit();
		} catch (SQLException e) {

			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

		long end = System.currentTimeMillis();

		System.out.println("time taken with batch: " + (end - start)); 

		// WITHOUT BATCH PROCESSING
		long start1 = System.currentTimeMillis();

		try {

			PreparedStatement pstmt = connection.prepareStatement("insert into batchTable(name) values(?)");
			for (long i = 1; i <= 10000; i++) {
				pstmt.setString(1, "Harshdeep" + i);
				pstmt.executeUpdate();

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		long end1 = System.currentTimeMillis();

		System.out.println("time taken without batch: " + (end1 - start1)); 

	}
}

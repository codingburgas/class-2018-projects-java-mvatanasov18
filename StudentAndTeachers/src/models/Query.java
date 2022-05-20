package models;

import java.sql.ResultSet;
import java.sql.Statement;

public class Query {
	//this will not be in production spoko
		public void testQuery() {
			try {
				
				ConnectionModel model=new ConnectionModel();
				
				Statement stm= model.createStatement();
				
				String selectSql = "USE BikeStores; SELECT * FROM sales.customers;";
	       	 ResultSet resultSet = stm.executeQuery(selectSql);

	           // Print results from select statement
	           while (resultSet.next()) {
	               System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
	           }
	           model.closeConnection();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}

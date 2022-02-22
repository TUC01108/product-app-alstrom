package com.training.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.training.pms.model.Product;
import com.training.pms.utility.DBConnection;

public class ProductDAOImpl implements ProductDAO {

	Connection con = DBConnection.getConnection();

	public void addProduct(Product product) {
		System.out.println("Adding product : " + product);
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("insert into product values(?,?,?,?)");

			statement.setInt(1, product.getProductId());
			statement.setString(2, product.getProductName());
			statement.setInt(3, product.getQuantityOnHand());
			statement.setInt(4, product.getPrice());

			int rows = statement.executeUpdate();
			System.out.println(rows + " inserted successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateProduct(Product product) {
		System.out.println("Updating product : " + product);

		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("update product set productName = ?, quantityonhand = ?, price = ? where productId = ?");

			statement.setString(1, product.getProductName());
			statement.setInt(2, product.getQuantityOnHand());
			statement.setInt(3, product.getPrice());
			statement.setInt(4, product.getProductId());

			int rows = statement.executeUpdate();
			System.out.println(rows + " updated successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteProduct(int productId) {
		System.out.println("Deleting product with productId : " + productId);

	}

	public void searchByProductId(int productId) {
		System.out.println("Searching for product with productId : " + productId);

	}

	public void searchByProductName(String productName) {
		System.out.println("Searching for product with product name : " + productName);

		try {
			// Statement stat = con.createStatement();
			PreparedStatement stat;
			stat = con.prepareStatement("select * from product where productName like ? ");
			stat.setString(1, productName);
			ResultSet res = stat.executeQuery();

			// Retrieve the column information
			ResultSetMetaData rsmd = res.getMetaData();
			int columnCount = rsmd.getColumnCount();

			// printing the column names
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rsmd.getColumnName(i) + "    ");
			}
			System.out.println();

			// takes the cursor to the next row
			// returns false if no record is there
			while (res.next()) {

				// printing all the values of the table
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(res.getString(i) + "    ");
				}
				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void printAllProducts() {
		System.out.println("Printing all products ");

		try {
			Statement stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from product");

			// Retrieve the column information
			ResultSetMetaData rsmd = res.getMetaData();
			int columnCount = rsmd.getColumnCount();

			// printing the column names
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rsmd.getColumnName(i) + "    ");
			}
			System.out.println();

			// takes the cursor to the next row
			// returns false if no record is there
			while (res.next()) {

				// printing all the values of the table
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(res.getString(i) + "    ");
				}
				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void searchProductByPrice(int lowerPrice, int upperPrice) {
		System.out.println("Searching product with product price :" + lowerPrice + " and " + upperPrice);
		PreparedStatement stat;
		try {
			// Statement stat = con.createStatement();

			stat = con.prepareStatement("select * from product where price between ? and ?");
			stat.setInt(1, lowerPrice);
			stat.setInt(2, upperPrice);
			ResultSet res = stat.executeQuery();

			// Retrieve the column information
			ResultSetMetaData rsmd = res.getMetaData();
			int columnCount = rsmd.getColumnCount();

			// printing the column names
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rsmd.getColumnName(i) + "    ");
			}
			System.out.println();

			// takes the cursor to the next row
			// returns false if no record is there
			while (res.next()) {

				// printing all the values of the table
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(res.getString(i) + "    ");
				}
				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

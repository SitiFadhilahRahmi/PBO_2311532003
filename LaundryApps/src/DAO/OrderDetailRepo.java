package DAO;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import config.Database;
import model.Order_Detail;

public class OrderDetailRepo implements OrderDetailDao {
	private Connection connection;
	final String insert = "INSERT INTO order_detail (order_id, service_id, harga, jumlah, total) VALUES (?,?,?,?,?)";
	final String delete = "DELETE FROM order_detail WHERE id=?;";
	final String update = "UPDATE order_detail SET order_id=?, service_id=?, harga=?, jumlah=?, total=? WHERE id=?;";

	
	public OrderDetailRepo() {
		connection = Database.getConnection();
	}
	
	public void save(Order_Detail cs) {

	    PreparedStatement st = null;
	    try {
	        st = connection.prepareStatement(insert);
	        st.setString(1, cs.getOrder_id());
	        st.setString(2, cs.getService_id());
	        st.setString(3, cs.getHarga());
	        st.setString(4, cs.getJumlah());
	        st.setString(5, cs.getTotal());
	        st.executeUpdate();

	    }catch(SQLException e) {
	        e.printStackTrace();
	    }finally {
	        try {
	            st.close();
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public List<Order_Detail> show(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Order_Detail od) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String total(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

}

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
import model.Customer;
import model.CustomerBuilder;

public class CustomerRepo implements CustomerDao {
	private Connection connection;
	final String insert = "INSERT INTO customer2 (nama, email, alamat, hp) VALUES (?,?,?,?)";
	final String select = "SELECT * FROM customer2;";
	final String delete = "DELETE FROM customer2 WHERE id=?;";
	final String update = "UPDATE customer2 SET nama=?, email=?, alamat=?, hp=? WHERE id=?;";
	
public CustomerRepo() {
	connection = Database.getConnection();
}

@Override
public void save(Customer customer) {
	PreparedStatement st = null;
	try {
		st = connection.prepareStatement(insert);
		st.setString(1, customer.getNama());
		st.setString(2, customer.getEmail());
		st.setString(3, customer.getAlamat());
		st.setString(4, customer.getHp());
		st.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(st!=null) {
		try {
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}}

	
}

@Override
public List<Customer> show() {
	List<Customer> ls=null;
	try {
		ls = new ArrayList<Customer>();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(select);
		while(rs.next()) {
			Customer customer = new CustomerBuilder()
			.setId(rs.getString("id"))
			.setNama(rs.getString("nama"))
			.setEmail(rs.getString("email"))
			.setAlamat(rs.getString("alamat"))
			.setHp(rs.getString("hp"))
			.build();
			ls.add(customer);
		}
		}catch(SQLException e) {
			Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE,null,e);
		}
	return ls;
}


@Override
public void delete(String id) {
	PreparedStatement st = null;
	try {
	st = connection.prepareStatement(delete);
	st.setString(1, id);
	st.executeUpdate();
	}catch(SQLException e) {
	e.printStackTrace();
	}finally {
	try {
	st.close();
	}catch(SQLException e) {
	e.printStackTrace();
	}}}
@Override
public void update(Customer customer) {
	PreparedStatement st = null;
	try {
	st = connection.prepareStatement (update);
	st.setString(1, customer.getNama());
	st.setString(2, customer.getEmail());
	st.setString(3, customer.getAlamat());
	st.setString(4, customer.getHp());
	st.setString(5, customer.getId());
	st.executeUpdate();
	}catch(SQLException e) {
	e.printStackTrace();
	}finally {
	try {
	st.close();
	}catch(SQLException e) {
	e.printStackTrace();
	}}}
}





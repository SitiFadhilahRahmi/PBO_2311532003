package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

import config.Database;
import model.Service;

public class ServiceRepo implements ServiceDao {
	private Connection connection;
	final String insert = "INSERT INTO service (jenis, satuan, status, harga) VALUES (?,?,?,?)";
	final String select = "SELECT * FROM service;";
	final String delete = "DELETE FROM service WHERE id=?;";
	final String update = "UPDATE service SET jenis=?, satuan=?,status=?, harga=? WHERE id=?;";
	
public ServiceRepo() {
	connection = Database.koneksi();
}

public void save(Service service) {
	PreparedStatement st = null;
    try {
        st = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, service.getJenis());
        st.setString(2, service.getSatuan());
        st.setString(3, service.getStatus());
        st.setDouble(4, service.getHarga());
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            service.setId(rs.getString(1));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

@Override
public List<Service> show() {
    List<Service> lv = new ArrayList<>(); // Inisialisasi list langsung
    try {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()) {
            Service service = new Service();
            service.setId(rs.getString("id"));
            System.out.println("ID: " + service.getId());
            service.setJenis(rs.getString("jenis"));
            service.setSatuan(rs.getString("satuan"));
            service.setStatus(rs.getString("status"));
            service.setHarga(rs.getDouble("harga")); // Sesuaikan tipe datanya jika perlu
            lv.add(service);
        }
    } catch (SQLException e) {
        Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, e);
    }
    return lv;
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
	}}	
}

public void update(Service service) {
	PreparedStatement st = null;
	try {
	st = connection.prepareStatement (update);
	st.setString(1, service.getJenis());
	st.setString(2, service.getSatuan());
	st.setString(3, service.getStatus());
	st.setDouble(4, service.getHarga());
	st.setString(5, service.getId());
	st.executeUpdate();
	}catch(SQLException e) {
	e.printStackTrace();
	}finally {
	try {
	st.close();
	}catch(SQLException e) {
	e.printStackTrace();
	}}
	
}

}

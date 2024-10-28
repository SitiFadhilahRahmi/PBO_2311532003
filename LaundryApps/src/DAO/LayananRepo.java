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
import model.Layanan;
public class LayananRepo implements LayananDao {
	private Connection connection;
	final String insert = "INSERT INTO layanan (jenis, satuan, status, harga) VALUES (?,?,?,?)";
	final String select = "SELECT * FROM layanan;";
	final String delete = "DELETE FROM layanan WHERE id=?;";
	final String update = "UPDATE layanan SET jenis=?, satuan=?, status=?, harga=? WHERE id=?;";
	
	public LayananRepo() {
		connection = Database.koneksi();
	}

	@Override
	public void save(Layanan layanan) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1, layanan.getJenis());
			st.setString(2, layanan.getSatuan());
			st.setString(3, layanan.getStatus());
			st.setDouble(4, layanan.getHarga());
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
	public List<Layanan> show() {
		List<Layanan> ls=null;
		try {
			ls = new ArrayList<Layanan>();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				Layanan layanan = new Layanan();
				layanan.setId(rs.getString("id"));
				layanan.setJenis(rs.getString("jenis"));
				layanan.setSatuan(rs.getString("satuan"));
				layanan.setStatus(rs.getString("status"));
				layanan.setHarga(rs.getDouble("harga"));
				ls.add(layanan);
			}
			}catch(SQLException e) {
				Logger.getLogger(LayananDao.class.getName()).log(Level.SEVERE,null,e);
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
		}}	
		
	}

	@Override
	public void update(Layanan layanan) {
		PreparedStatement st = null;
		try {
		st = connection.prepareStatement (update);
		st.setString(1, layanan.getJenis());
		st.setString(2, layanan.getSatuan());
		st.setString(3, layanan.getStatus());
		st.setDouble(4, layanan.getHarga());
		st.setString(5, layanan.getId());
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

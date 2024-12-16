package DAO;

import java.util.List;
import model.Layanan;

public interface LayananDao {
	void save(Layanan layanan);
	public List<Layanan> show();
	public void delete(String id);
	public void update(Layanan layanan);

}

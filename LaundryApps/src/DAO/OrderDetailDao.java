package DAO;

import java.util.List;

import model.Order_Detail;

public interface OrderDetailDao {
	void save(Order_Detail od);
	public List<Order_Detail> show (String order_id);
	public void delete(String id);
	public void update(Order_Detail od);
	public String total(String order_id);

}

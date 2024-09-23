package model;

public class Orders {
	String id, tgl_order, tgl_selesai, sts_bayar, sts_pesanan;
	Double totalharga;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		id = id;
	}
	public String getTgl_order() {
		return tgl_order;
	}
	public void setTgl_order(String tgl_order) {
		this.tgl_order = tgl_order;
	}
	public String getTgl_selesai() {
		return tgl_selesai;
	}
	public void setTgl_selesai(String tgl_selesai) {
		this.tgl_selesai = tgl_selesai;
	}
	public String getSts_bayar() {
		return sts_bayar;
	}
	public void setSts_bayar(String sts_bayar) {
		this.sts_bayar = sts_bayar;
	}
	public String getSts_pesanan() {
		return sts_pesanan;
	}
	public void setSts_pesanan(String sts_pesanan) {
		this.sts_pesanan = sts_pesanan;
	}
	public Double getTotalHarga() {
		return totalharga;
	}
	public void setTotalHarga(Double totalHarga) {
		totalharga = totalharga;
	}
	
	
}

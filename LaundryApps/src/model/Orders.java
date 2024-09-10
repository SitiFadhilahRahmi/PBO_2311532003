package model;

public class Orders {
	String Id, tgl_order, tgl_selesai, sts_bayar, sts_pesanan;
	Double TotalHarga;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
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
		return TotalHarga;
	}
	public void setTotalHarga(Double totalHarga) {
		TotalHarga = totalHarga;
	}
	
	
}

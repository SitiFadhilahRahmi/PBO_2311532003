package model;

public class Services {
	String Id, jenis, status;
	Double harga, satuan;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getJenis() {
		return jenis;
	}
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getHarga() {
		return harga;
	}
	public void setHarga(Double harga) {
		this.harga = harga;
	}
	public Double getSatuan() {
		return satuan;
	}
	public void setSatuan(Double satuan) {
		this.satuan = satuan;
	}
	
	
	
}

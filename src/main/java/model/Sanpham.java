package model;

public class Sanpham implements java.io.Serializable {
	private String id,tensp,mota;
	private double Gia;
	
	public Sanpham() {
		super();
		id="";
		tensp="";
		Gia=0.0;
		mota="";
	}

	public Sanpham(String id, String tensp, double Gia, String mota) {
		super();
		this.id = id;
		this.tensp = tensp;
		this.Gia = Gia;
		this.mota = mota;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public double getGia() {
		return Gia;
	}

	public void setGia(double gia) {
		Gia = gia;
	}

}
package models;

public class NhaCungCap {
	private int maNCC;
	private String tenNhaCC;
	private String diaChi;
	private String soDienThoai;

	public NhaCungCap() {
		super();
	}
	

	public NhaCungCap(int maNCC) {
		super();
		this.maNCC = maNCC;
	}



	public NhaCungCap(int maNCC, String tenNhaCC, String diaChi, String soDienThoai) {
		super();
		this.maNCC = maNCC;
		this.tenNhaCC = tenNhaCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public int getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNhaCC() {
		return tenNhaCC;
	}

	public void setTenNhaCC(String tenNhaCC) {
		this.tenNhaCC = tenNhaCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

}

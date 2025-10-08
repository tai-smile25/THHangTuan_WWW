package models;

import java.time.LocalDate;

public class DienThoai {
	private int maDT;
	private String tenDT;
	private int namSanXuat;
	private String cauHinh;
	private int maNCC;
	private String hinhAnh;

	public DienThoai() {
		super();
	}

	public DienThoai(int maDT, String tenDT, int namSanXuat, String cauHinh, int maNCC, String hinhAnh) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.namSanXuat = namSanXuat;
		this.cauHinh = cauHinh;
		this.maNCC = maNCC;
		this.hinhAnh = hinhAnh;
	}

	public int getMaDT() {
		return maDT;
	}

	public void setMaDT(int maDT) {
		this.maDT = maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public int getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String getCauHinh() {
		return cauHinh;
	}

	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}

	public int getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

}

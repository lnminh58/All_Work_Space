package lnminh.vn;

public abstract class NhanVien {
	private String ten;
	private String cmnd;
	
	public abstract int xuatLuong();
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	
	public NhanVien(String ten, String cmnd) {
		super();
		this.ten = ten;
		this.cmnd = cmnd;
	}
	
	
	public NhanVien() {
		super();
	}
	


	public String toString() {
		return this.ten+"==>"+xuatLuong();
	}
	
}

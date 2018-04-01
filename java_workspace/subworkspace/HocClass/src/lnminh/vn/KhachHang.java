package lnminh.vn;

public class KhachHang {
	private String ma;
	private String ten;
	private int tuoi;
	private String diaChi;
	
	private static double x;
	public void doiThongTinCuaX(int gtmoi)
	{
		x=gtmoi;
	}
	public double layThongTinCuaX()
	{
		return x;
	}
	public String getMa() {
		return ma;
	}


	public void setMa(String ma) {
		this.ma = ma;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public int getTuoi() {
		return tuoi;
	}


	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public KhachHang(String ma, String ten, int tuoi, String diaChi)
	{
		this.ma = ma;
		this.ten = ten;
		this.tuoi=tuoi;
		this.diaChi=diaChi;
	}
	
	public KhachHang()
	{
		System.out.println("Contructor mặc định tự động được gọi: ");
	}
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(this.ma);
		builder.append("\t");
		builder.append(this.ten);
		builder.append("\t");
		builder.append(this.tuoi);
		builder.append("\t");
		builder.append(this.diaChi);
		builder.append("\t");
		return builder.toString();
	}
}

package lnminh.vn;

public class NhanVien implements Comparable<NhanVien> {
	private int ma;
	private String ten;
	
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public NhanVien(int ma, String ten) {
		super();
		this.ma = ma;
		this.ten = ten;
	}
	public NhanVien() {
		super();
	}
	@Override
	public String toString() {
		return "NhanVien [ma=" + ma + ", ten=" + ten + "]";
	}
	
	//=0 ==> Bằng Nhau ,  >0 doi tuong 1 > doi tuong 2, <0 doi tuong 1 < doi tuong 2
	
	@Override
	public int compareTo(NhanVien o) {
		// TODO Auto-generated method stub
	    int ssten=this.ten.compareToIgnoreCase(o.getTen());
		if(ssten == 0)
		{
			if(this.ma==o.ma)
			{
			return 0;
			}
		else if(this.ma>o.ma)
		{
			return 1;
		}
		else 
		{
			return -1;
		}
		
		}
		return ssten;
	}
	
	
}

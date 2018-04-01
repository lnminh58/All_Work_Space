package lnminh.vn;

public class NhapSo {
	private int giaTri;
	
	public int getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(int giaTri) {
		this.giaTri = giaTri;
	}
	
	public NhapSo(int giaTri) {
		super();
		this.giaTri = giaTri;
	}
	
	public NhapSo() {
		super();
	}
	public void moiNhap() {
		System.out.println("Xin nhập vào một số");
	}
	public void soSanh(){
		if (giaTri>100) {
			System.out.println("Số vừa nhập lớn hơn 100");
		}else if(giaTri==100) {
			System.out.println("Số vừa nhập bằng 100");
		}else {
			System.out.println("Số vừa nhập nhỏ hơn 100");
		}
	}

	@Override
	public String toString() {
		return "Giá trị vừa nhập là: " + giaTri;
	}
	
}

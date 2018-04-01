package lnminh.vn;

public class HaiSo {
	private int soThuNhat;
	private int soThuHai;

	public int getSoThuNhat() {
		return soThuNhat;
	}

	public void setSoThuNhat(int soThuNhat) {
		this.soThuNhat = soThuNhat;
	}

	public int getSoThuHai() {
		return soThuHai;
	}

	public void setSoThuHai(int soThuHai) {
		this.soThuHai = soThuHai;
	}

	public HaiSo(int soThuNhat, int soThuHai) {
		super();
		this.soThuNhat = soThuNhat;
		this.soThuHai = soThuHai;
	}

	public void tinhTong() {
		System.out.println("Tổng bằng:"+(soThuNhat + soThuHai));
	}
	public void tinhHieu() {
		System.out.println("Hiệu bằng:"+Math.abs(soThuNhat - soThuHai));
	}
	public void tinhTich() {
		System.out.println("Tích bằng:"+(soThuNhat*soThuHai));
	}
	public void tinhThuong() {
		if(soThuHai==0 || soThuNhat==0) {
			System.out.println("Thương bằng: 0");
		}else if(soThuHai==0 && soThuNhat==0) {
			System.out.println("Không thể thực hiện phép chia");
		}else {
			if(soThuNhat>soThuHai){
				System.out.println("Thương bằng: "+(soThuNhat/soThuHai));
			}else {
				System.out.println("Thương bằng: "+(soThuHai/soThuNhat));
			}
		}
	
	}
	public HaiSo() {
		super();
	}

	@Override
	public String toString() {
		return "HaiSo [soThuNhat=" + soThuNhat + ", soThuHai=" + soThuHai + "]";
	}

}

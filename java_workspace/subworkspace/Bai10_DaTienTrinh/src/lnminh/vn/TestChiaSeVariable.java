package lnminh.vn;

public class TestChiaSeVariable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread2 mt = new MyThread2();
		Thread th1 = new Thread(mt);
		th1.setName("Tiến Trình 1");
		th1.start();
		Thread th2 = new Thread(mt);
		th1.setName("Tiến Trình 1");
		th2.start();
		Thread th3 = new Thread(mt);
		th1.setName("Tiến Trình 1");
		th3.start();
		System.out.println("x hiện tại lấy ra bằng : "+mt.getX());
	}

}

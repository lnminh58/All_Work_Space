package lnminh.vn;

public class TestMyThread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread th3 = new Thread(new MyThread2());
		th3.setName("Tiến Trình 3");
		th3.start();
		
		Thread th4 = new Thread(new MyThread2());
		th4.setName("Tiến Trình 4");
		th4.start();
	}

}

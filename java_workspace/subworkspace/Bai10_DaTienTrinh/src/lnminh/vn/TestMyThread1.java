package lnminh.vn;

public class TestMyThread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1 th1=new MyThread1();
		th1.setName("Tiến trình 1 ");
		th1.start(); //Kích Hoạt tiến trình (còn gọi là tiểu trình)
		MyThread1 th2= new MyThread1();
		th2.setName("Tiến Trình 2 ");
		th2.start();
	}

}

package lnminh.vn;

public class HocStatic {

	public static int x=5; // x chính là class member, class variable;
	public int y;
	public static void fn()
	{
		//System.out.println(y); // không cho phép
		System.out.println(x);
	}
	public void fn2()
	{
		System.out.println(y); 
		System.out.println(x);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

package lnminh.vn;

import org.omg.CORBA.PUBLIC_MEMBER;

public class MyThread2 implements Runnable {

	private int x=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<5;i++)
		{
			System.out.println(Thread.currentThread().getName() + " i= "+i+""
					+ "\n\t x= "+x);
			x++;	
		}
	} 
	public int getX(){
		return this.x;
	}

}


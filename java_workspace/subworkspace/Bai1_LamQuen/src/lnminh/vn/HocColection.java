package lnminh.vn;

import java.util.ArrayList;
import java.util.Iterator;

public class HocColection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList arr= new ArrayList();
		arr.add("Mot");
		arr.add(1);
		arr.add(1.5f);
		
		Iterator iter=arr.iterator();
		
		while(iter.hasNext()) {
			Object name = iter.next();
			if(String.valueOf(name).equalsIgnoreCase("mot"))
			{
				iter.remove();
			}
		}
		for (Object object : arr) {
			System.out.println(object);
		}
	}

}

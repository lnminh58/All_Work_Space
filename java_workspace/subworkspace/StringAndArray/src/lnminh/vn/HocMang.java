package lnminh.vn;

import java.util.Arrays;

public class HocMang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[]={1,3,5,0,11,9,17,6};
		System.out.println("Mảng của bạn là: ");
		for(int i=0;i<M.length;i++){
			System.out.print(M[i]+"\t");
		}
		Arrays.sort(M);
		System.out.println("\nMảng sau khi sắp xếp là: ");
		for(int i=0;i<M.length;i++){
			System.out.print(M[i]+"\t");
		}
		System.out.println("\nCác số nguyên tố là: ");
		/*boolean check= false;
		for(int i=0;i<M.length;i++)
		{
			check = true;
			for(int j=2;j<M[i];j++)
			{	
				if(M[i]%j==0)
				{	
					check=false;
					break;
				}
			}
			if(M[i]>=2 &&check==true)
			{
			System.out.print(M[i]+"\t");
			}
		}*/
		int dem=0;
		for(int i=0;i<M.length;i++){
			dem=0;
			for(int j=1;j<= M[i];j++){
				if(M[i]%j==0)
				{
					dem++;
				}
			}
			if(dem==2)
			{
			System.out.print(M[i]+"\t");
			}
		}
	}

}

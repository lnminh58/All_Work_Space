package lnminh.vn;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

	public class HocStringTokenizer {
		public static void main(String[] args) {
			String s="Học , học nữa .....   học, mãi";
			StringTokenizer token = new StringTokenizer(s);
			while(token.hasMoreTokens())
			{
				System.out.println(token.nextToken());
			}
			StringTokenizer token2 = new StringTokenizer(s,",");
			while(token2.hasMoreTokens())
			{
				System.out.println(token2.nextToken());
			}
			StringTokenizer token3 = new StringTokenizer(s, ",  ");
					while(token3.hasMoreTokens())
					{
						System.out.println(token3.nextToken());
					}
		
		}
		
}

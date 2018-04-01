package lnminh.vn;

public class TestString {

	public static void main(String[] args) {
		String str = "abaaacca";
	//	str=str.concat("123");
		System.out.println(str);
		
		System.out.println(str.charAt(0));
		
		//================= StringBuilder
/*		StringBuilder str1= new StringBuilder();
		str1.append(str);
		str1.append("123");
		System.out.println(str1);
		*/
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			System.out.print(a);
		}
		System.out.println("");
		System.out.println(str.lastIndexOf("a"));
		System.out.println(str.lastIndexOf("aa"));
		
		String str2 = "Lê    Ngọc      Minh    ";
		str2= str2.replace(" ", "");
		System.out.println(str2);
		
		StringBuilder str1 = new StringBuilder();
		str1.append(str2);
		System.out.println(str1.indexOf(str2));
		
		
	}

}

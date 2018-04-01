package lnminh.vn;

public class HocStringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
			for(int i=0; i<= 100; i++)
			{
				builder.append("Phần tử thứ: " +i);
				builder.append("\n");
			}
			System.out.println(builder.toString());
	}

}

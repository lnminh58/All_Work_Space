package lnminh.vn;

public class HocString {

	public static void main(String[] args) {
		String s="Lê Ngọc Minh sdt 0935889315";
		System.out.println("Chiều dài của chuỗi: "+s.length());
		int soChuSo=0;
		int soInHoa=0;
		int soInThuong=0;
		
		char arr[]=s.toCharArray();
		char c;
		for(int i=0; i<arr.length;i++ )
		{
			c= arr[i];
			if(Character.isUpperCase(c))
			{
				soInHoa++;
			}
			else if(Character.isLowerCase(c))
			{
				soInThuong++;
			}
			else if(Character.isDigit(c)){
				soChuSo++;
			}
		}
		System.out.println("Số chữ in hoa: "+ soInHoa);
		System.out.println("Số chữ in thường: "+ soInThuong);
		System.out.println("Số chữ số: "+ soChuSo);
		
		// phan 2
		String bh1="d:/Music/Nhactrinh/riengmotgoctroi.mp3";
	//	String bh2="d:\\Music\\Nhactrinh\\riengmotgoctroi.mp3";
		int vtcuoi=bh1.lastIndexOf("/");
		String tenBaiHat=bh1.substring(vtcuoi+1);
		System.out.println("Tên bài hát: "+ tenBaiHat);
		vtcuoi=tenBaiHat.lastIndexOf(".");
		tenBaiHat=tenBaiHat.substring(0,vtcuoi);
		System.out.println("Tên bài hát không đuôi: "+ tenBaiHat);
	}

}

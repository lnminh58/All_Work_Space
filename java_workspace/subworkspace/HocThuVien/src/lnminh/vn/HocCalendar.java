package lnminh.vn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HocCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		int nam = cal.get(Calendar.YEAR);
		
		int thang= cal.get(Calendar.MONTH);
		int ngay = cal.get(Calendar.DATE);
		System.out.println("Bây giờ là: ngày "+ ngay+ " tháng "+ (++thang)+ " năm "+ nam);
		Date thoigian = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Hôm Nay: " +sdf.format(thoigian));
		SimpleDateFormat sdf2 = new SimpleDateFormat("d/M/yyyy");
		System.out.println("Hôm Nay: " +sdf2.format(thoigian));
		
		SimpleDateFormat sdf3= new SimpleDateFormat("HH:mm:ss");
		System.out.println("Bây giờ là: "+ sdf3.format(thoigian));
		SimpleDateFormat sdf4= new SimpleDateFormat("hh:mm:ss aaa");
		System.out.println("Bây giờ là: "+ sdf4.format(thoigian));
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//6. Viết chương trình nhập vào điểm 3 môn thi: Toán, Lý, Hóa của học sinh. 
//Nếu tổng điểm >= 15 và không có môn nào dưới 4 thì in kết quả đậu. 
//Nếu đậu mà các môn đều lớn hơn 5 thì in ra lời phê "Học đều các môn", 
//ngược lại in ra "Học chưa đều các môn", các trường hợp khác là "Thi hỏng".
package session04_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session04_baitap6 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap diem Toan: ");
        float diemToan=nhap.nextFloat();
        System.out.print("Nhap diem Ly: ");
        float diemLy=nhap.nextFloat();
        System.out.print("Nhap diem Hoa: ");
        float diemHoa=nhap.nextFloat();
        if (((diemToan+diemLy+diemHoa)>=15)&&(diemToan>4)&&(diemLy>4)&&(diemHoa>4)){
            if ((diemToan>5)&&(diemLy>5)&&(diemHoa>5)){
                System.out.println("Thi dau. Hoc deu cac mon");
            }
            else{
                System.out.println("Thi dau. Hoc chua deu cac mon");
            }
        }
        else{
            System.out.println("Thi hong");
        }
    }
}

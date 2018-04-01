/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session07;

/**
 * <h1>Add and Sub Two Numbers!</h1>
 * Phuong thuc addNum trien khai mot ung dung ma cong hai so integer da cho va
 * in ket qua ra output.
 * <p>
 * Phuong thuc subNum trien khai mot ung dung ma tru hai so integer da cho va
 * in ket qua ra output.
 * <p>
 * <b>Note:</b> Viec cung cap comment thich hop trong chuong trinh giup no tro
 * nen than thien voi nguoi dung hon.
 *
 * @author nguyenducthao
 * @version 1.0
 * @since 2016-12-19
 */
public class javadoc {

    /**
     * Phuong thuc nay duoc su dung de cong hai so. Day la mot form don gian
     * nhat cua phuong thuc, de minh hoa cac su dung cua cac javadoc Tags.
     *
     * @param numA Day la tham so dau tien cua phuong thuc addNum
     * @param numB Day la tham so thu hai cua phuong thuc addNum
     * @return int Tra ve tong cua numA va numB.
     */
    public int addNum(int numA, int numB) {
        return numA + numB;
    }

    /**
     * Phuong thuc nay duoc su dung de tru hai so. Day la mot form don gian
     * nhat cua phuong thuc, de minh hoa cac su dung cua cac javadoc Tags.
     *
     * @param numA Day la tham so dau tien cua phuong thuc subNum
     * @param numB Day la tham so thu hai cua phuong thuc subNum
     * @return int Tra ve hieu cua numA va numB.
     */
    public int subNum(int numA, int numB) {
        return numA - numB;
    }

    /**
     * Day la phuong thuc chinh ma su dung phuong thuc addNum va subNum.
     *
     * @param args Unused.
//     * @return Nothing.
//     * @exception IOException On input error.
//     * @see IOException
     */
    public static void main(String[] args) {
        javadoc obj = new javadoc();
        int sum = obj.addNum(0, 0);
        int sub=obj.subNum(20, 10);

        System.out.println("Tong cua 10 va 20 la :" + sum);
        System.out.println("Hieu cua 20 va 10 la :" + sub);
    }
}

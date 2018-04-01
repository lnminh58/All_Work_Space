/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controllerBatch;
import controller.controllerStudent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import myException.myInputMismatchException_Float;
import util.myUtil;

/**
 *
 * @author nguyenducthao
 */
public class modelStudent {

    private String studentCode;
    private String studentName;
    private boolean studentGender;
    private Date studentBirthday;
    private String batchCode;
    private float studentEnglishMark;
    private float studentMathMark;
    private float studentComputerMark;
    private String filename_avatar;
    private byte[] image_avatar;

    public modelStudent() {
    }

    public modelStudent(String studentCode, String studentName, boolean studentGender, Date studentBirthday, String batchCode, float studentEnglishMark, float studentMathMark, float studentComputerMark, String filename_avatar, byte[] image_avatar) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentBirthday = studentBirthday;
        this.batchCode = batchCode;
        this.studentEnglishMark = studentEnglishMark;
        this.studentMathMark = studentMathMark;
        this.studentComputerMark = studentComputerMark;
        this.filename_avatar = filename_avatar;
        this.image_avatar = image_avatar;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isStudentGender() {
        return studentGender;
    }

    public void setStudentGender(boolean studentGender) {
        this.studentGender = studentGender;
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public float getStudentEnglishMark() {
        return studentEnglishMark;
    }

    public void setStudentEnglishMark(float studentEnglishMark) {
        this.studentEnglishMark = studentEnglishMark;
    }

    public float getStudentMathMark() {
        return studentMathMark;
    }

    public void setStudentMathMark(float studentMathMark) {
        this.studentMathMark = studentMathMark;
    }

    public float getStudentComputerMark() {
        return studentComputerMark;
    }

    public void setStudentComputerMark(float studentComputerMark) {
        this.studentComputerMark = studentComputerMark;
    }

    public String getFilename_avatar() {
        return filename_avatar;
    }

    public void setFilename_avatar(String filename_avatar) {
        this.filename_avatar = filename_avatar;
    }

    public byte[] getImage_avatar() {
        return image_avatar;
    }

    public void setImage_avatar(byte[] image_avatar) {
        this.image_avatar = image_avatar;
    }

    public void inputNewStudent() throws SQLException, ClassNotFoundException, IOException, myInputMismatchException_Float {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Input student code: ");
            this.studentCode = input.nextLine();
            if (this.studentCode.length() <= 10) {
                if (myUtil.checkValid(this.studentCode, "st\\d{8}")) {
                    if (!controllerStudent.searchStudentByCode(this.studentCode)) {
                        break;
                    } else {
                        System.out.println("Student code already exists!");
                    }

                } else {
                    System.out.println("Student code form: \"st\" and following after 8 digits");
                }
            } else {
                System.out.println("Student code maximum of 10 characters!");
            }
        } while (true);
        input = new Scanner(System.in);
        do {
            System.out.print("Input student name: ");
            this.studentName = input.nextLine();
            if (this.studentName.length() <= 50) {
                break;
            } else {
                System.out.println("Student gender maximum of 50 characters!");
            }
        } while (true);
        input = new Scanner(System.in);
        do {
            System.out.print("Input student gender (1:Male/0:Female): ");
            String str = input.nextLine();
            if (!myUtil.checkValid(str, "\\d")) {
                System.out.println("Only input 0 or 1 for student gender!");
            } else {
                if (Integer.valueOf(str) == 0) {
                    this.studentGender = false;
                } else {
                    this.studentGender = true;
                }
                break;
            }
        } while (true);
        input = new Scanner(System.in);
        do {
            System.out.print("Input student birthday (dd/MM/yyyy): ");
            String str = input.nextLine();
            if (!myUtil.checkValid(str, "\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println("Student birthday form: dd/MM/yyyyy!");
            } else {
                this.studentBirthday = myUtil.convertStringToJavaDate(str);
                break;
            }
        } while (true);
        input = new Scanner(System.in);
        do {
            System.out.print("Input batch code: ");
            this.batchCode = input.nextLine();
            if (this.batchCode.length() <= 10) {
                if (myUtil.checkValid(this.batchCode, "batch\\d{5}")) {
                    if (controllerBatch.searchBatchByCode(this.batchCode)) {
                        break;
                    } else {
                        System.out.println("Batch code is not exists!");
                    }
                } else {
                    System.out.println("Student code form: \"batch\" and following after 5 digits");
                }
            } else {
                System.out.println("Batch code maximum of 10 characters!");
            }
        } while (true);
        input = new Scanner(System.in);
        do {
            System.out.print("Input student english mark: ");
            try {
                this.studentEnglishMark = input.nextFloat();
                if (this.studentEnglishMark <= 10) {
                    break;
                } else {
                    System.out.println("The maximum english mark is 10!");
                }
            } catch (InputMismatchException error) {
                throw new myInputMismatchException_Float("Input student english mark: ");
            }
        } while (true);
        input = new Scanner(System.in);
        do {
            System.out.print("Input student math mark: ");
            try {
                this.studentMathMark = input.nextFloat();
                if (this.studentMathMark <= 10) {
                    break;
                } else {
                    System.out.println("The maximum math mark is 10!");
                }
            } catch (InputMismatchException error) {
                throw new myInputMismatchException_Float("Input student math mark: ");
            }
        } while (true);
        input = new Scanner(System.in);
        do {
            System.out.print("Input student computer mark: ");
            try {
                this.studentComputerMark = input.nextFloat();
                if (this.studentComputerMark <= 10) {
                    break;
                } else {
                    System.out.println("The maximum computer mark is 10!");
                }
            } catch (InputMismatchException error) {
                throw new myInputMismatchException_Float("Input student computer mark: ");
            }
        } while (true);
    }
}

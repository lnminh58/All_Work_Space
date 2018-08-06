/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.modelStudent;
import view.frmMain;
import static view.frmMain.arrayFileNameAvatar;
import static view.frmMain.arrayListAllStudent;
import static view.frmMain.mapBatchCodeBatchName;
import static view.frmMain.tableStudentData;

/**
 *
 * @author nguyenducthao
 */
public class myUtil {

    public static boolean checkValid(String input, String partten) {
//        String partten = "\\d{0,2}/\\d{0,2}/\\d{4}";
//        String input = "01/01/2017";
        Pattern pattern = Pattern.compile(partten);
        Matcher matcher = pattern.matcher(input);
        return (matcher.matches());
    }

    public static java.util.Date convertStringToJavaDate(String input) {
        return (new java.util.Date(input.substring(6) + "/" + input.substring(3, 5) + "/" + input.substring(0, 2)));

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        java.util.Date date = dateFormat.parse("2017-11-10");
//        System.out.println(dateFormat.format(date));
    }

    public static boolean checkValidFrmMain() {
        if (frmMain.txtStudentName.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please input student name!", "Error", JOptionPane.ERROR_MESSAGE);
            frmMain.txtStudentName.requestFocus();
            return false;
        }
        if (!frmMain.radioMale.isSelected() && !frmMain.radioFemale.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please select student gender!", "Error", JOptionPane.ERROR_MESSAGE);
            frmMain.radioMale.requestFocus();
            return false;
        }
        if (frmMain.txtBirthday.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please input student birthday!", "Error", JOptionPane.ERROR_MESSAGE);
            frmMain.txtBirthday.requestFocus();
            return false;
        }
        if (!myUtil.checkValid(frmMain.txtBirthday.getText().trim(), "\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(null, "Student birthday form: dd/MM/yyyy!", "Error", JOptionPane.ERROR_MESSAGE);
            frmMain.txtBirthday.requestFocus();
            return false;
        }
        if (frmMain.cboBatch.getSelectedItem().toString().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please select batch of student!", "Error", JOptionPane.ERROR_MESSAGE);
            frmMain.cboBatch.requestFocus();
            return false;
        }
        if (frmMain.txtEnglishMark.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please input student english mark!", "Error", JOptionPane.ERROR_MESSAGE);
            frmMain.txtEnglishMark.requestFocus();
            return false;
        }
        if (Float.valueOf(frmMain.txtEnglishMark.getText().trim()) > 10) {
            JOptionPane.showMessageDialog(null, "Student english mark incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
            frmMain.txtEnglishMark.requestFocus();
            return false;
        }
        if (frmMain.txtMathMark.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please input student math mark!", "Error", JOptionPane.ERROR_MESSAGE);
            frmMain.txtMathMark.requestFocus();
            return false;
        }
        if (Float.valueOf(frmMain.txtMathMark.getText().trim()) > 10) {
            JOptionPane.showMessageDialog(null, "Student math mark incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
            frmMain.txtMathMark.requestFocus();
            return false;
        }
        if (frmMain.txtComputerMark.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please input student computer mark!", "Error", JOptionPane.ERROR_MESSAGE);
            frmMain.txtComputerMark.requestFocus();
            return false;
        }
        if (Float.valueOf(frmMain.txtComputerMark.getText().trim()) > 10) {
            JOptionPane.showMessageDialog(null, "Student computer mark incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
            frmMain.txtComputerMark.requestFocus();
            return false;
        }
        if (frmMain.fileNameAvatar == null) {
            JOptionPane.showMessageDialog(null, "Please select student avatar!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static void updateAllInformationAfterInsertNewStudent() throws FileNotFoundException, IOException, InterruptedException {
        Vector temp = new Vector();
        temp.add(arrayListAllStudent.size() + 1);
        temp.add(frmMain.student.getStudentCode());
        temp.add(frmMain.student.getStudentName());
        temp.add(frmMain.student.isStudentGender());
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
//            temp.add(arrayListAllStudent.get(i).getStudentBirthday());
        temp.add(format.format(frmMain.student.getStudentBirthday()));
//            temp.add(arrayListAllStudent.get(i).getBatchCode());
        temp.add(mapBatchCodeBatchName.get(frmMain.student.getBatchCode()));
        temp.add(frmMain.student.getStudentEnglishMark());
        temp.add(frmMain.student.getStudentMathMark());
        temp.add(frmMain.student.getStudentComputerMark());
        temp.add("Delete");
        tableStudentData.add(temp);
        frmMain.showDataToTableStudent();

        arrayListAllStudent.add(frmMain.student);
//        OutputStream targetFile = new FileOutputStream("./src/view/temp/" + arrayListAllStudent.get(arrayListAllStudent.size() - 1).getFilename_avatar());
//        targetFile.write(arrayListAllStudent.get(arrayListAllStudent.size() - 1).getImage_avatar());
//        Thread.sleep(1000);
//        arrayFileNameAvatar.add("/view/temp/" + arrayListAllStudent.get(arrayListAllStudent.size() - 1).getFilename_avatar());
        File fileTemp = new File("");
        OutputStream targetFile = new FileOutputStream(fileTemp.getAbsolutePath() +"/data/images/temp/" + arrayListAllStudent.get(arrayListAllStudent.size() - 1).getFilename_avatar());
        targetFile.write(arrayListAllStudent.get(arrayListAllStudent.size() - 1).getImage_avatar());
        Thread.sleep(1000);
        arrayFileNameAvatar.add(fileTemp.getAbsolutePath() +"/data/images/temp/" + arrayListAllStudent.get(arrayListAllStudent.size() - 1).getFilename_avatar());
    }

    public static void updateAllInformationAfterUpdateNewStudent(modelStudent student) throws FileNotFoundException, IOException, InterruptedException {
        for (int i = 0; i < arrayListAllStudent.size(); i++) {
            if (arrayListAllStudent.get(i).getStudentCode().equalsIgnoreCase(frmMain.txtStudentCode.getText())) {
                arrayListAllStudent.set(i, student);
//                OutputStream targetFile = new FileOutputStream("./src/view/temp/" + arrayListAllStudent.get(i).getFilename_avatar());
//                targetFile.write(arrayListAllStudent.get(i).getImage_avatar());
//                Thread.sleep(1000);
                File fileTemp = new File("");
                OutputStream targetFile = new FileOutputStream(fileTemp.getAbsolutePath() +"/data/images/temp/" + arrayListAllStudent.get(i).getFilename_avatar());
                targetFile.write(arrayListAllStudent.get(i).getImage_avatar());
                Thread.sleep(1000);
                break;
            }

        }
        for (int i = 0; i < tableStudentData.size(); i++) {
            Vector vTemp = new Vector();
            vTemp = (Vector) tableStudentData.elementAt(i);
            if (vTemp.get(1).toString().equalsIgnoreCase(student.getStudentCode())) {
                vTemp.set(2, frmMain.txtStudentName.getText().trim());
                if (frmMain.radioMale.isSelected()) {
                    vTemp.set(3, true);
                } else {
                    vTemp.set(3, false);
                }
                vTemp.set(4, frmMain.txtBirthday.getText().trim());
                vTemp.set(5, frmMain.cboBatch.getSelectedItem().toString());
                vTemp.set(6, frmMain.txtEnglishMark.getText().trim());
                vTemp.set(7, frmMain.txtMathMark.getText().trim());
                vTemp.set(8, frmMain.txtComputerMark.getText().trim());
                tableStudentData.set(i, vTemp);
                break;
            }
        }
        frmMain.showDataToTableStudent();
    }

    public static void updateAllInformationAfterDeleteStudent() {
        for (int i = 0; i < frmMain.arrayListAllStudent.size(); i++) {
            Vector vTemp = new Vector();
//            vTemp = (Vector) frmMain.arrayListAllStudent.get(i).getStudentCode();
            if (frmMain.arrayListAllStudent.get(i).getStudentCode().equalsIgnoreCase(frmMain.tblStudent.getValueAt(frmMain.tblStudent.getSelectedRow(), 1).toString())) {
                frmMain.arrayListAllStudent.remove(i);
                frmMain.arrayFileNameAvatar.remove(i);
                break;
            }
        }
        for (int i = 0; i < frmMain.tableStudentData.size(); i++) {
            Vector vTemp = new Vector();
            vTemp = (Vector) frmMain.tableStudentData.elementAt(i);
            if (vTemp.get(0).toString().equalsIgnoreCase(frmMain.tblStudent.getValueAt(frmMain.tblStudent.getSelectedRow(), 0).toString())) {
                frmMain.tableStudentData.remove(i);
                break;
            }
        }
        for (int i = 0; i < tableStudentData.size(); i++) {
            Vector vTemp = new Vector();
            vTemp = (Vector) tableStudentData.elementAt(i);
            vTemp.set(0, i + 1);
            tableStudentData.set(i, vTemp);
        }
        frmMain.showDataToTableStudent();

    }
}

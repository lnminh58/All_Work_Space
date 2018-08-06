/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nguyenducthao
 */
public class users {

    private String username;
    private String password;
    private boolean gender;
    private String filename_avatar;
    private byte[] image_avatar;

    public users() {
    }

    public users(String username, String password, boolean gender, String filename_avatar, byte[] image_avatar) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.filename_avatar = filename_avatar;
        this.image_avatar = image_avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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

}

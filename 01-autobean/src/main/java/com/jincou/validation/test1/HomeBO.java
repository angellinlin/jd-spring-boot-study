package com.jincou.validation.test1;


import lombok.*;

/**
 * 07_户籍信息
 *
 * @author dongjian1
 * */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeBO extends AbstractBO {
    //身份证号 - UserInfoProcessor
    private String idNo;
    //姓名 - UserInfoProcessor
    private String realName;
    //性别 - UserInfoProcessor
    private String gender;
    //地址 - UserInfoProcessor
    private String address;
    //相片字节 - UserPhotoInfoProcessor
    private byte[] photo;
    //相片文件名称
    private String photoFileName;
    //相片本地存储位置
    private String photoFilePath;
    //身份证正面照
    private byte[] frontPhoto;
    //身份证正面照文件名
    private String frontPhotoName;
    // 身份证正面照存储位置
    private String frontPhotoPath;
    // 身份证反面照
    private byte[] backPhoto;
    //身份证反面照文件名
    private String backPhotoName;
    //身份证反面照存储位置
    private String backPhotoPath;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoFilePath() {
        return photoFilePath;
    }

    public void setPhotoFilePath(String photoFilePath) {
        this.photoFilePath = photoFilePath;
    }

    public byte[] getFrontPhoto() {
        return frontPhoto;
    }

    public void setFrontPhoto(byte[] frontPhoto) {
        this.frontPhoto = frontPhoto;
    }

    public String getFrontPhotoName() {
        return frontPhotoName;
    }

    public void setFrontPhotoName(String frontPhotoName) {
        this.frontPhotoName = frontPhotoName;
    }

    public String getFrontPhotoPath() {
        return frontPhotoPath;
    }

    public void setFrontPhotoPath(String frontPhotoPath) {
        this.frontPhotoPath = frontPhotoPath;
    }

    public byte[] getBackPhoto() {
        return backPhoto;
    }

    public void setBackPhoto(byte[] backPhoto) {
        this.backPhoto = backPhoto;
    }

    public String getBackPhotoName() {
        return backPhotoName;
    }

    public void setBackPhotoName(String backPhotoName) {
        this.backPhotoName = backPhotoName;
    }

    public String getBackPhotoPath() {
        return backPhotoPath;
    }

    public void setBackPhotoPath(String backPhotoPath) {
        this.backPhotoPath = backPhotoPath;
    }
}

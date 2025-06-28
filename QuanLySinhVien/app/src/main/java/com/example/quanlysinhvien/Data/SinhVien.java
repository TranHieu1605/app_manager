package com.example.quanlysinhvien.Data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

//@Entity(tableName = "TTSinhVien")
@Entity()
public class SinhVien implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id = 0;
//    @ColumnInfo(name = "Name")
    @ColumnInfo
    public String Name;
//    @ColumnInfo(name = "Date")
    @ColumnInfo
    public String date;
//    @ColumnInfo(name = "GioiTinh")
    @ColumnInfo
    public String gioiTinh;
//    @ColumnInfo(name = "CCCD")
    @ColumnInfo
    public String cccd;
//    @ColumnInfo(name = "QueQuan")
    @ColumnInfo
    public String queQuan;
//    @ColumnInfo(name = "MaSV")
    @ColumnInfo
    public String maSV;
//    @ColumnInfo(name = "Class")
    @ColumnInfo
    public String lop;
//    @ColumnInfo(name = "ChuyenNganh")
    @ColumnInfo
    public String chuyenNganh;
//    @ColumnInfo(name = "Khoa")
    @ColumnInfo
    public String khoa;
//    @ColumnInfo(name = "DiaChi")
    @ColumnInfo
    public String diaChi;
//    @ColumnInfo(name = "SDT")
    @ColumnInfo
    public String SDT;
//    @ColumnInfo(name = "Email")
    @ColumnInfo
    public String email;
    @ColumnInfo
    public String passwordEmail;
//    @ColumnInfo(name = "Facebook")
    @ColumnInfo
    public String face;

    public SinhVien(){

    }

    public SinhVien(String name, String date, String gioiTinh, String cccd, String queQuan, String maSV, String lop, String chuyenNganh, String khoa, String diaChi, String SDT, String email,String passwordEmail, String face) {
        Name = name;
        this.date = date;
        this.gioiTinh = gioiTinh;
        this.cccd = cccd;
        this.queQuan = queQuan;
        this.maSV = maSV;
        this.lop = lop;
        this.chuyenNganh = chuyenNganh;
        this.khoa = khoa;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.email = email;
        this.passwordEmail = passwordEmail;
        this.face = face;
    }




    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordEmail() {
        return passwordEmail;
    }

    public void setPasswordEmail(String passwordEmail) {
        this.passwordEmail = passwordEmail;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getId() {
        return id;
    }
}
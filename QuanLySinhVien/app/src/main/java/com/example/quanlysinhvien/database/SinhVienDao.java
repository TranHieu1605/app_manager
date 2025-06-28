package com.example.quanlysinhvien.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlysinhvien.Data.SinhVien;

import java.util.List;

@Dao
public interface SinhVienDao {
    @Insert
    void insert(SinhVien sinhvien);
    @Update
    void update(SinhVien sinhvien);
    @Delete
    void delete(SinhVien sinhvien);
    @Query("SELECT * FROM SinhVien")
    List<SinhVien> listSV();
    @Query("SELECT * FROM SinhVien WHERE id = :id")
    public SinhVien getItemById(int id);
}

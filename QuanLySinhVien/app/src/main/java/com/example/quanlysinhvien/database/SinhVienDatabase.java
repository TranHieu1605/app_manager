package com.example.quanlysinhvien.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.quanlysinhvien.Data.SinhVien;

@Database(entities = {SinhVien.class}, version = 1)
public abstract class SinhVienDatabase extends RoomDatabase {
    public abstract SinhVienDao getSinhVienDao();
    public static SinhVienDatabase instance;
    public static SinhVienDatabase getInstance(Context context) {
        if(instance==null){
           instance = Room.databaseBuilder(context,SinhVienDatabase.class,"thongtinsinhvien")
                .allowMainThreadQueries().build();

//            instance = Room.inMemoryDatabaseBuilder(context.getApplicationContext(),SinhVienDatabase.class)
//                    .allowMainThreadQueries().build();
        }
        return instance;
    }
}

package com.example.quanlysinhvien;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlysinhvien.Data.SinhVien;
import com.example.quanlysinhvien.database.SinhVienDao;
import com.example.quanlysinhvien.database.SinhVienDatabase;

import java.util.ArrayList;
import java.util.List;

public class DSSVActivity extends AppCompatActivity {
    RecyclerView rcvSV;
    private SinhVienDatabase svDatabase;
    private AdapterSV adapterSV;
    private SinhVienDao svDao;
    private List<SinhVien> sinhVienList = new ArrayList<>();
    CardView viewSV;

    public void chuyentrang() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dssv);
        rcvSV = findViewById(R.id.rcvSV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvSV.setLayoutManager(linearLayoutManager);
        svDatabase = SinhVienDatabase.getInstance(this);
        svDao = svDatabase.getSinhVienDao();
//        svDao.insert(new SinhVien("Thanh","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2"));
        sinhVienList = svDao.listSV();
//        sinhVienList.add(new SinhVien("Thanh","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2"));
//        sinhVienList.add(new SinhVien("Thanh","Thanh2","Thanh2","Thanh2","Thanh2","20CE044","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2","Thanh2"));
        adapterSV = new AdapterSV(sinhVienList,this);
        rcvSV.setAdapter(adapterSV);
        String maSV = AdapterSV.maSV;


//        viewSV = findViewById(R.id.viewSV);



    }


}
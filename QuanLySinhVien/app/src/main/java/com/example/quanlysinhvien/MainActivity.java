package com.example.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.quanlysinhvien.Data.SinhVien;
import com.example.quanlysinhvien.database.SinhVienDatabase;

public class MainActivity extends AppCompatActivity {
    CardView addSV,dsSV,close,about;
    MenuItem itemAccount,itemQuyenTruyCap;
    SinhVien sinhVien;
    SinhVienDatabase svDatabase;
//    SinhVienDatabase svData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        addSV = findViewById(R.id.addSV);
        addSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(LoginActivity.phanQuyen!="Admin"){
                    Toast.makeText(MainActivity.this,"Không thuộc phân quyền truy cập của bạn",Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });
        dsSV = findViewById(R.id.dsSV);
        dsSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(LoginActivity.phanQuyen!="Admin"){
                    Intent intent = new Intent(MainActivity.this, ChitietActivity.class);
                    sinhVien = svDatabase.getInstance(getApplication()).getSinhVienDao().getItemById(LoginActivity.id);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("sinhvien", sinhVien);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else {
                    startActivity(new Intent(MainActivity.this, DSSVActivity.class));
                }
            }
        });
        close = findViewById(R.id.cardClose);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        about = findViewById(R.id.cardAbout);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AbouAppActivity.class));
            }
        });

//        svData = SinhVienDatabase.getInstance(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        itemAccount = menu.findItem(R.id.itemAccount);
        itemQuyenTruyCap = menu.findItem(R.id.itemTruyCap);
        if(LoginActivity.phanQuyen=="Admin"){
            itemQuyenTruyCap.setTitle("Admin");
        }
        itemAccount.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                finish();
                startActivity(intent);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
package com.example.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.quanlysinhvien.Data.SinhVien;
import com.example.quanlysinhvien.database.SinhVienDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    public static String phanQuyen;
    public static int id;
    SinhVien sinhVien;
    SinhVienDatabase svDatabase;
    List<SinhVien> listSV = new ArrayList<>();

    TextInputEditText txtEmail, txtPassword;
    AppCompatButton btnDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.loginEmail);
        txtPassword = findViewById(R.id.loginPass);
        btnDangNhap = findViewById(R.id.btndangnhap);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = txtEmail.getText().toString();
                String strPass = txtPassword.getText().toString();
                String strEmail2 = "admin@gmail.com";
                String strPass2 = "admin";
                if((strEmail.equals(strEmail2)) && (strPass.equals(strPass2))){
                    phanQuyen = "Admin";
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    finish();
                    startActivity(intent);
                } else{
                    listSV = svDatabase.getInstance(getApplication()).getSinhVienDao().listSV();
                    int sizeList = listSV.size();
                    for(int i=0;i<sizeList;i++){
                        if(listSV.get(i).getEmail().equals(strEmail)&&(listSV.get(i).getPasswordEmail().equals(strPass))){
                            phanQuyen = strEmail;
                            id = listSV.get(i).getId();
                            finish();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}
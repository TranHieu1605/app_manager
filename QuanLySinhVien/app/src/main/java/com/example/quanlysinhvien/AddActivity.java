package com.example.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlysinhvien.Data.SinhVien;
import com.example.quanlysinhvien.database.SinhVienDao;
import com.example.quanlysinhvien.database.SinhVienDatabase;

public class AddActivity extends AppCompatActivity {
    private EditText editName,editGioiTinh,editNgaySinh,editCCCD,editQueQuan,editMSSV,editClass,editChuyenNganh,editKhoa,eidtDiaChi,editSDT,editEmail,editPasswordEmail,editFace;
    private MenuItem itemAdd;
    private SinhVienDatabase svDatabase;
    private SinhVienDao svDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        editName = findViewById(R.id.editTxtName);
        editGioiTinh = findViewById(R.id.editTxtGioiTinh);
        editNgaySinh = findViewById(R.id.editTxtNgaySinh);
        editCCCD = findViewById(R.id.editTxtCCCD);
        editQueQuan = findViewById(R.id.editTxtQueQuan);
        editMSSV = findViewById(R.id.editTxtMSSV);
        editClass = findViewById(R.id.editTxtClass);
        editChuyenNganh = findViewById(R.id.editTxtChuyenNganh);
        editKhoa = findViewById(R.id.editTxtKhoa);
        eidtDiaChi = findViewById(R.id.editTxtDiaChi);
        editSDT = findViewById(R.id.editTxtSDT);
        editEmail = findViewById(R.id.editTxtEmail);
        editFace = findViewById(R.id.editTxtFace);
        editPasswordEmail = findViewById(R.id.editTxtPassword);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        itemAdd = menu.findItem(R.id.itemAdd);
        itemAdd.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String name = editName.getText().toString();
                String gioiTinh = editGioiTinh.getText().toString();
                String ngaySinh = editNgaySinh.getText().toString();
                String CCCD = editCCCD.getText().toString();
                String queQuan = editQueQuan.getText().toString();
                String MSSV = editMSSV.getText().toString();
                String lop = editClass.getText().toString();
                String chuyenNganh = editChuyenNganh.getText().toString();
                String khoa = editKhoa.getText().toString();
                String diaChi = eidtDiaChi.getText().toString();
                String SDT = editSDT.getText().toString();
                String email = editEmail.getText().toString();
                String password = editPasswordEmail.getText().toString();
                String facebook = editFace.getText().toString();

                svDatabase = SinhVienDatabase.getInstance(getApplication());
                svDao = svDatabase.getSinhVienDao();
                svDao.insert(new SinhVien(name,gioiTinh,ngaySinh,CCCD,queQuan,MSSV,lop,chuyenNganh,khoa,diaChi,SDT,email,password,facebook));
                finish();
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                AddActivity.this.startActivity(intent);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
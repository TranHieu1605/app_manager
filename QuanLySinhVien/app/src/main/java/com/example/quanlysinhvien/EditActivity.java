package com.example.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlysinhvien.Data.SinhVien;
import com.example.quanlysinhvien.database.SinhVienDatabase;
import com.github.ivbaranov.mli.MaterialLetterIcon;

public class EditActivity extends AppCompatActivity {
    private EditText editName,editGioiTinh,editNgaySinh,editCCCD,editQueQuan,editMSSV,editClass,editChuyenNganh,editKhoa,eidtDiaChi,editSDT,editEmail,editPassword,editFace;
    MenuItem itemCancel, itemComplete;
    SinhVien sinhVien;
    SinhVienDatabase svDatabase;
    MaterialLetterIcon avatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Bundle bundle = getIntent().getExtras();
        if(bundle==null){
            return;
        }
        sinhVien = (SinhVien) bundle.get("editSinhVien");

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
        editPassword = findViewById(R.id.editTxtPassword);
        editFace = findViewById(R.id.editTxtFace);

        editName.setText(sinhVien.getName());
        editGioiTinh.setText(sinhVien.getGioiTinh());
        editNgaySinh.setText(sinhVien.getDate());
        editCCCD.setText(sinhVien.getCccd());
        editQueQuan.setText(sinhVien.getQueQuan());
        editMSSV.setText(sinhVien.getMaSV());
        editClass.setText(sinhVien.getLop());
        editChuyenNganh.setText(sinhVien.getChuyenNganh());
        editKhoa.setText(sinhVien.getKhoa());
        eidtDiaChi.setText(sinhVien.getDiaChi());
        editSDT.setText(sinhVien.getSDT());
        editEmail.setText(sinhVien.getEmail());
        editPassword.setText(sinhVien.getPasswordEmail());
        editFace.setText(sinhVien.getFace());

        avatar = findViewById(R.id.avataradd);
        avatar.setInitialsNumber(2);
        avatar.setLetterSize(25);
        avatar.setLetter(sinhVien.getName());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_menu,menu);
        itemCancel = menu.findItem(R.id.itemcancel);
        itemComplete = menu.findItem(R.id.itemcomplete);
        itemCancel.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(EditActivity.this,ChitietActivity.class));
                return true;
            }
        });

        itemComplete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
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
                String passWord = editPassword.getText().toString();
                String facebook = editFace.getText().toString();

                sinhVien.setName(name);
                sinhVien.setGioiTinh(gioiTinh);
                sinhVien.setDate(ngaySinh);
                sinhVien.setCccd(CCCD);
                sinhVien.setQueQuan(queQuan);
                sinhVien.setMaSV(MSSV);
                sinhVien.setLop(lop);
                sinhVien.setChuyenNganh(chuyenNganh);
                sinhVien.setKhoa(khoa);
                sinhVien.setDiaChi(diaChi);
                sinhVien.setSDT(SDT);
                sinhVien.setEmail(email);
                sinhVien.setPasswordEmail(passWord);
                sinhVien.setFace(facebook);
                svDatabase.getInstance(getApplication()).getSinhVienDao().update(sinhVien);
                finish();
                startActivity(new Intent(EditActivity.this,DSSVActivity.class));
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
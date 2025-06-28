package com.example.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlysinhvien.Data.SinhVien;
import com.github.ivbaranov.mli.MaterialLetterIcon;

public class ChitietActivity extends AppCompatActivity {
    SinhVien sinhVien;
    MenuItem itemEdit;
    TextView txtViewMSSV2,txtViewName2,txtViewName3,txtViewGioiTinh,txtViewNgaySinh,txtViewCCCD,txtViewQueQuan,txtViewMSSV3,txtViewClass,txtViewChuyenNganh,txtViewKhoa,txtViewDiaChi,txtViewSDT,txtViewEmail,txtViewPassword,txtViewFace;
    MaterialLetterIcon avatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet);
        Bundle bundle = getIntent().getExtras();
        if(bundle== null){
            return;
        }
        sinhVien = (SinhVien) bundle.get("sinhvien");

        txtViewName2 = findViewById(R.id.txtViewName2);
        txtViewName3 = findViewById(R.id.txtViewName3);
        txtViewGioiTinh = findViewById(R.id.txtViewGioiTinh);
        txtViewNgaySinh = findViewById(R.id.txtViewNgaySinh);
        txtViewCCCD = findViewById(R.id.txtViewCCCD);
        txtViewQueQuan = findViewById(R.id.txtViewQueQuan);
        txtViewMSSV3 = findViewById(R.id.txtViewMSSV3);
        txtViewClass = findViewById(R.id.txtViewClass);
        txtViewChuyenNganh = findViewById(R.id.txtViewChuyenNganh);
        txtViewKhoa = findViewById(R.id.txtViewKhoa);
        txtViewDiaChi = findViewById(R.id.txtViewDiaChi);
        txtViewSDT = findViewById(R.id.txtViewSDT);
        txtViewEmail = findViewById(R.id.txtViewEmail);
        txtViewPassword = findViewById(R.id.txtViewPassword);
        txtViewFace = findViewById(R.id.txtViewFace);




        txtViewMSSV2.setText(sinhVien.getMaSV());
        txtViewName2.setText(sinhVien.getName());
        txtViewName3.setText(sinhVien.getName());
        txtViewGioiTinh.setText(sinhVien.getGioiTinh());
        txtViewCCCD.setText(sinhVien.getCccd());
        txtViewNgaySinh.setText(sinhVien.getDate());
        txtViewQueQuan.setText(sinhVien.getQueQuan());
        txtViewMSSV3.setText(sinhVien.getMaSV());
        txtViewClass.setText(sinhVien.getLop());
        txtViewChuyenNganh.setText(sinhVien.getChuyenNganh());
        txtViewKhoa.setText(sinhVien.getKhoa());
        txtViewDiaChi.setText(sinhVien.getDiaChi());
        txtViewSDT.setText(sinhVien.getSDT());
        txtViewEmail.setText(sinhVien.getEmail());
        txtViewPassword.setText(sinhVien.getPasswordEmail());
        txtViewFace.setText(sinhVien.getFace());

        avatar = findViewById(R.id.chitietavatar);
        avatar.setInitialsNumber(2);
        avatar.setLetterSize(25);
        avatar.setLetter(sinhVien.getName());



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chitiet_menu,menu);
        itemEdit = menu.findItem(R.id.itemupdate);
        itemEdit.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(LoginActivity.phanQuyen!="Admin"){
                    Toast.makeText(ChitietActivity.this,"Không thuộc phân quyền truy cập của bạn",Toast.LENGTH_SHORT).show();
                    return false;
                }else {
                    Intent intent = new Intent(ChitietActivity.this, EditActivity.class);
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("editSinhVien", sinhVien);
                    intent.putExtras(bundle2);
                    finish();
                    startActivity(intent);
                    return true;
                }
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        itemEdit.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Intent intent = new Intent(ChitietActivity.this, EditActivity.class);
//                startActivity(intent);
//                return true;
//            }
//        });
//        return super.onOptionsItemSelected(item);
//    }
}
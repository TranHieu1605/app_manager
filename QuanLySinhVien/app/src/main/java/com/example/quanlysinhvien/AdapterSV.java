package com.example.quanlysinhvien;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlysinhvien.Data.SinhVien;
import com.example.quanlysinhvien.database.SinhVienDao;
import com.example.quanlysinhvien.database.SinhVienDatabase;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.List;

public class AdapterSV extends RecyclerView.Adapter<AdapterSV.ViewHolderSV> {
    public static String maSV = null;
    private static int id;
    private List<SinhVien> dsSV;
    private SinhVienDatabase svDatabase;
    private SinhVienDao svDao;
    private Context context;
    private int[] intColor;

    public AdapterSV(List<SinhVien> dsSV,Context context) {
        this.dsSV = dsSV;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolderSV onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sv,parent,false);
        return new ViewHolderSV(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSV holder, int position) {
        SinhVien sinhVien = dsSV.get(position);
        if(sinhVien==null){
            return;
        }
        holder.txtViewName.setText(sinhVien.getName());
        holder.txtViewMSSV.setText(sinhVien.getMaSV());
        holder.avatar.isInitials();
        holder.avatar.setInitialsNumber(2);
        holder.avatar.setLetterSize(25);
        holder.avatar.setLetter(sinhVien.getName());
//        intColor = context.getResources().getIntArray(R.array.color);
//        int min = 50;
//        int max = 100;
//        holder.avatar.setShapeColor(intColor[]);


        holder.viewSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                svDatabase = SinhVienDatabase.getInstance(view.getContext());
//                svDao = svDatabase.getSinhVienDao();
//                maSV = holder.txtViewMSSV.getText().toString();
                daClick(sinhVien);
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                svDatabase = SinhVienDatabase.getInstance(view.getContext());
                svDao = svDatabase.getSinhVienDao();
                svDatabase.getSinhVienDao().delete(sinhVien);
                dsSV = svDatabase.getSinhVienDao().listSV();
                notifyDataSetChanged();
            }
        });
    }

    private void daClick(SinhVien sinhVien) {
        Intent intent = new Intent(context, ChitietActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("sinhvien", sinhVien);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//    }

    @Override
    public int getItemCount() {
        if(dsSV!=null){
            return dsSV.size();
        }
        return 0;
    }

    public class ViewHolderSV extends RecyclerView.ViewHolder {
        TextView txtViewName,txtViewMSSV,txt1,txt2;
        CardView viewSV;
        ImageButton btnDelete;
        MaterialLetterIcon avatar;
        Button button_delete;
        public ViewHolderSV(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.textView15);
            txt2 = itemView.findViewById(R.id.textView17);
            txtViewName = itemView.findViewById(R.id.txtViewName);
            txtViewMSSV = itemView.findViewById(R.id.txtViewMSSV);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            avatar = itemView.findViewById(R.id.imageView6);
            viewSV = itemView.findViewById(R.id.viewSV);
        }
    }
}

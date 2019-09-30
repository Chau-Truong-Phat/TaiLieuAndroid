package com.example.bai3_tuan2_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SinhVienAdapter extends BaseAdapter {

    int MyLayout;
    Context MyContext;
    List<SinhVien> arraySinhVien;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> listSinhVien){
        MyContext = context;
        MyLayout = layout;
        arraySinhVien = listSinhVien;
    }
    @Override
    public int getCount() {
        return arraySinhVien.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Tạo View
        LayoutInflater inflater = (LayoutInflater) MyContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(MyLayout, null);

        TextView tvHoTen = (TextView)convertView.findViewById(R.id.tv_fullname);
        tvHoTen.setText(arraySinhVien.get(position).FullName);

        TextView tvNamSinh = (TextView)convertView.findViewById(R.id.tv_birthyear);
        tvNamSinh.setText(arraySinhVien.get(position).BirthYear);

        return convertView;
    }
}

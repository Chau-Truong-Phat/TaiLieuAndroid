package com.example.bai3_tuan2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private Button btn_Nhap;
    private TextView et_Nhap;
    private TextView tv_KetQua;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_KetQua = (TextView)findViewById(R.id.tv_KetQua);
        et_Nhap = (TextView)findViewById(R.id.et_Nhap);

        btn_Nhap = (Button)findViewById(R.id.btn_Nhap);
        myList = new ArrayList<String>();
        listView = (ListView)findViewById(R.id.lv_danhsach);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myList);
        listView.setAdapter(adapter);

        btn_Nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = et_Nhap.getText().toString();
                myList.add(s);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String msg = "position : " + arg2;
                msg += ";value : " + arg0.getItemAtPosition(arg2).toString();
                tv_KetQua.setText(msg);
            }
        });
    }
}

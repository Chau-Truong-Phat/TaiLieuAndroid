package com.example.a20190924_demo_lecturer;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_filename;
    EditText et_context;
    Button btn_NhapMoi;
    Button btn_Luu;
    Button btn_Xem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_context = (EditText)findViewById(R.id.et_context);
        et_filename = (EditText)findViewById(R.id.et_filename);
        btn_NhapMoi = (Button)findViewById(R.id.btn_NhapMoi);
        btn_Luu = (Button)findViewById(R.id.btn_Luu);
        btn_Xem = (Button)findViewById(R.id.btn_mo);

        btn_NhapMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_context.setText("");
                et_filename.setText("");
            }
        });

        btn_Xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = et_filename.getText().toString();
                SharedPreferences pref = getApplicationContext().getSharedPreferences(filename,0);

                String context = pref.getString("string", null);
                et_context.setText(pref.getString("string",null));
            }
        });

        btn_Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = et_filename.getText().toString();

                SharedPreferences pref = getApplicationContext().getSharedPreferences(filename,0);
                SharedPreferences.Editor editor = pref.edit();

                try {
                    editor.putString("string",et_context.getText().toString());
                    editor.commit();
                } catch (Exception e){
                    Toast.makeText(MainActivity.this,"Lỗi lưu", Toast.LENGTH_LONG);
                }
            }
        });

    }
}

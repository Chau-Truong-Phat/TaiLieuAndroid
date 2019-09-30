package com.example.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setIcon(R.drawable.mumat);
        mydialog.setTitle("Message");
        tv_ketqua = (TextView)findViewById(R.id.textView_ketqua);
        final boolean[] arrayCheck = {false,true,false};
        final CharSequence[] items = {"Đỏ", "Phát đẹp trai", "Cam"};
        mydialog.setMultiChoiceItems(items, arrayCheck, new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b){
                arrayCheck[i] = b;
            }
        });
        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String st = "";
                for (int j = 0; j < items.length; j++)
                    if(arrayCheck[j])
                        st += items[j].toString() + "\n";
                    tv_ketqua.setText(st);
            }
        });
        mydialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
//        mydialog.setItems(items, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int i) {
//                tv_ketqua.setText(items[i].toString());
//            }
//        });
        // comment lại
//        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                tv_ketqua.setText("You choice yes.");
//            }
//        });
        AlertDialog alertDialog = mydialog.create();
        alertDialog.show();
    }
}

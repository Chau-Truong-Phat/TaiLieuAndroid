package com.example.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(R.drawable.cat);
        list.add(R.drawable.cat);
        list.add(R.drawable.cat);
        list.add(R.drawable.cat);
        list.add(R.drawable.cat);
        list.add(R.drawable.cat);
        final ImageView imageView = (ImageView)findViewById(R.id.image_car);
        Gallery gallery = (Gallery)findViewById(R.id.gallery_car);
        MyAdapter adapter = new MyAdapter(list, MainActivity.this);
        gallery.setAdapter(adapter);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                imageView.setImageResource(list.get(i));
            }
        });
    }
//    public boolean onOptionsItemSelected(Menu item){
//        switch (item.getItemId()){
//
//        }
//    }
}

package com.example.multilanguage;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        setContentView(R.layout.activity_main);

        Button btchange = (Button)findViewById(R.id.btn_changeLang);
        btchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });

    }
    private void showChangeLanguageDialog(){
        final String[] listitems = {"English", "French", "Vietname"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose Language ...");
        builder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                switch (i){
                    case 0: {
                        setLocale("en");
                        recreate();
                        break;
                    }
                    case 1: {
                        setLocale("fr");
                        recreate();
                        break;
                    }
                    case 2: {
                        setLocale("vi");
                        recreate();
                        break;
                    }
                    default:dialog.dismiss();
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Setting",MODE_PRIVATE).edit();
        editor.putString("My_lang",lang);
        editor.apply();
    }

    public void loadLocale(){
        SharedPreferences pref = getSharedPreferences("Setting", Activity.MODE_PRIVATE);
        String language = pref.getString("My_lang","");
        setLocale(language);
    }
}

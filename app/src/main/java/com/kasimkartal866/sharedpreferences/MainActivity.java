package com.kasimkartal866.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = (Button) findViewById(R.id.btnSave);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("information", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("name","jonny");
                e.putInt("age", 23);
                e.putFloat("height", 1.78f);
                e.putBoolean("single",true);

                Set<String> friendList = new HashSet<>();
                friendList.add("Angelina");
                friendList.add("Ariana");
                e.putStringSet("friendList", friendList);
                e.commit();

                startActivity(new Intent(MainActivity.this, SecondActivity.class));


            }
        });
    }
}
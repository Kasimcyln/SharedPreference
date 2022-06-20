package com.kasimkartal866.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class SecondActivity extends AppCompatActivity {
    private Button btnUpdate, btnDelete;
    private TextView textViewResult;
    private SharedPreferences sp;
    private SharedPreferences.Editor e;
    private String name;
    private int age;
    private float height;
    private boolean single;
    private Set<String> friendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

        sp = getSharedPreferences("information", MODE_PRIVATE);
        e = sp.edit();

        name = sp.getString("name", "no name");
        age = sp.getInt("age", 0);
        height = sp.getFloat("height", 0.0f);
        single = sp.getBoolean("single", false);
        friendList = sp.getStringSet("friendList",null);

        final StringBuilder sb = new StringBuilder();
        for (String s : friendList){
            sb.append(s+" ");
        }
        textViewResult.setText("Name : "+name+" Age : "+age+" Height : "+height+" Single : "+single+" Friend : "+sb.toString());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.remove("name");
                e.commit();

                name = sp.getString("name", "no name");
                textViewResult.setText("Name : "+name+" Age : "+age+" Height : "+height+" Single : "+single+" Friend : "+sb.toString());


            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.putInt("age",400);
                e.commit();

                age = sp.getInt("age", 0);
                textViewResult.setText("Name : "+name+" Age : "+age+" Height : "+height+" Single : "+single+" Friend : "+sb.toString());



            }
        });



    }
}
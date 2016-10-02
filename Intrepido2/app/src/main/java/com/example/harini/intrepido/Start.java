package com.example.harini.intrepido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Start extends AppCompatActivity {
    ImageButton startbtn;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

public void start(View view){
    startbtn=(ImageButton)findViewById(R.id.start);
    startbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent("com.example.harini.intrepido.MapActivity");
            startActivity(intent);
        }
    });
}
    public void next(View view){
        next=(Button)findViewById(R.id.ok);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.harini.intrepido.Emergency");
                startActivity(intent);
            }
        });
    }
}

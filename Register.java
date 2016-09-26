package com.example.siddiqsami.intrepido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity {
    private static Button Signin;
    private static Button Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onsignin(View view)
    {
        Signin = (Button) findViewById (R.id.signin);
        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.siddiqsami.intrepido.Signin");
                startActivity(intent);
            }
        });
    }
    public void onsignup(View view)
    {
        Signup=(Button)findViewById(R.id.signup);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.siddiqsami.intrepido.Signup");
                startActivity(intent);
            }
        });
    }
}

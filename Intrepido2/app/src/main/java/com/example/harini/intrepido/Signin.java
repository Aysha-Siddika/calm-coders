package com.example.harini.intrepido;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Signin extends AppCompatActivity implements View.OnClickListener {
    private EditText  uname,pass_word;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        uname = (EditText) findViewById(R.id.uname);
        pass_word = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.Login);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (v == login)
        {
            LoginUser();



        }

    }
    private void LoginUser()
    {
        String username = uname.getText().toString();
        String password = pass_word.getText().toString();
        BackendProcess1 backendProcess1 = new BackendProcess1(Signin.this);
        backendProcess1.execute(username, password);
    }

}
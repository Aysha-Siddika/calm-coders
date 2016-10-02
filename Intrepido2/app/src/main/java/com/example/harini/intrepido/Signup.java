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


public class Signup extends AppCompatActivity implements View.OnClickListener
{
    private EditText fname, uname, pass_word, confirmpassword, emno1, emno2, emno3, emno4;
    private Button submit, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fname = (EditText) findViewById(R.id.FN);
        uname = (EditText) findViewById(R.id.UN);
        pass_word = (EditText) findViewById(R.id.pwd);
        confirmpassword = (EditText) findViewById(R.id.cpwd);
        emno1 = (EditText) findViewById(R.id.EM1);
        emno2 = (EditText) findViewById(R.id.EM2);
        emno3 = (EditText) findViewById(R.id.EM3);
        emno4 = (EditText) findViewById(R.id.EM4);

        submit = (Button) findViewById(R.id.submit);
        cancel = (Button) findViewById(R.id.cancel);

        submit.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == submit) {
            registerUser();
            Intent intent = new Intent("com.example.harini.intrepido.Signin");
            startActivity(intent);

        } else if (v == cancel) {
            cancelbtn();
        }
    }

    private void registerUser() {
        String full_name = fname.getText().toString();
        String username = uname.getText().toString();
        String password = pass_word.getText().toString();
        String c_password = confirmpassword.getText().toString();
        String emergency1 = emno1.getText().toString();
        String emergency2 = emno2.getText().toString();
        String emergency3 = emno3.getText().toString();
        String emergency4 = emno4.getText().toString();
        String type="send";
        BackendProcess backendProcess = new BackendProcess(Signup.this);
        backendProcess.execute(type,full_name, username, password, c_password, emergency1, emergency2, emergency3, emergency4);

    }

    private void cancelbtn() {

        fname.setText(" ");
        uname.setText(" ");
        pass_word.setText(" ");
        confirmpassword.setText(" ");
        emno1.setText(" ");
        emno2.setText(" ");
        emno3.setText(" ");
        emno4.setText(" ");
    }

}
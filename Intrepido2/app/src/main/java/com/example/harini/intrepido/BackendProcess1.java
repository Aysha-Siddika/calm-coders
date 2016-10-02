package com.example.harini.intrepido;

/**
 * Created by HARINI on 10/1/2016.
 */
import android.animation.AnimatorSet;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by HARINI on 9/29/2016.
 */
public class BackendProcess1 extends AsyncTask<String ,String,String> {
        HttpURLConnection http;
        URL REGISTER_URL = null;
        Signin context;
        AlertDialog alertDialog;

        BackendProcess1(Signin ct) {
                context = ct;
        }

        @Override
        protected String doInBackground(String... params)
        {
                String result1 = null;
                try {
                        REGISTER_URL = new URL("http://ahh.esy.es/Intrepido/signin.php");

                } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return "No internet";
                }
                try {
                        http = (HttpURLConnection) REGISTER_URL.openConnection();

                        http.setRequestMethod("POST");
                        http.setDoOutput(true);
                        http.setDoInput(true);
                        Uri.Builder builder = new Uri.Builder()
                                .appendQueryParameter("un", params[0])
                                .appendQueryParameter("pass", params[1]);
                        OutputStream out = http.getOutputStream();
                        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                        String query = builder.build().getEncodedQuery();
                        write.write(query);
                        write.flush();
                        write.close();
                        out.close();
                        http.connect();
                } catch (IOException e)

                {
                        e.printStackTrace();
                        return "execption";
                }

                try {
                        int response_code = http.getResponseCode();
                        if (response_code == HttpURLConnection.HTTP_OK) {
                                InputStream in = http.getInputStream();
                                BufferedReader read = new BufferedReader(new InputStreamReader(in, "iso-8859-1"));
                                StringBuilder result = new StringBuilder();
                                String line = "";
                                while ((line = read.readLine()) != null) {
                                        result.append(line);

                                }

                               result1= result.toString();
                        }

                }
                catch (IOException e)
                {
                        e.printStackTrace();
                } finally
                {
                        http.disconnect();
                }
                return result1;


        }




@Override
protected void onPreExecute() {
        super.onPreExecute();
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Message");
        alertDialog.setMessage("Please Wait");
        }

@Override
protected void onPostExecute(String result1)
{
        super.onPostExecute(result1);
        alertDialog.setMessage(result1);
        alertDialog.show();
}
@Override
protected void onProgressUpdate( String... values) {
        super.onProgressUpdate(values);

        }

        }

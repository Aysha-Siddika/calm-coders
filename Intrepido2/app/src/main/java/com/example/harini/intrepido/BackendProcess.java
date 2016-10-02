package com.example.harini.intrepido;

/**
 * Created by HARINI on 10/1/2016.
 */
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
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

/**
 * Created by HARINI on 9/29/2016.
 */
public class BackendProcess extends AsyncTask<String ,String,String>
{
    Signup context;
    AlertDialog alertDialog;
    BackendProcess(Signup ct)
    {
        context=  ct;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String fullname = params[1];
        String username = params[2];
        String password = params[3];
        String confirm_password = params[4];
        String emergency_no1 = params[5];
        String emergency_no2 = params[6];
        String emergency_no3 = params[7];
        String emergency_no4 = params[8];

        String  REGISTER_URL = "http://ahh.esy.es/Intrepido/signup.php";
        try {
            URL url = new URL(REGISTER_URL);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            OutputStream out = http.getOutputStream();
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
            String post_data= URLEncoder.encode("type", "UTF-8")+"="+URLEncoder.encode(type,"UTF-8")+"&"+
                    URLEncoder.encode("fn", "UTF-8")+"="+URLEncoder.encode(fullname,"UTF-8")+"&"+
                    URLEncoder.encode("un","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                    URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                    URLEncoder.encode("cpass","UTF-8")+"="+URLEncoder.encode(confirm_password,"UTF-8")+"&"+
                    URLEncoder.encode("en1","UTF-8")+"="+URLEncoder.encode(emergency_no1,"UTF-8")+"&"+
                    URLEncoder.encode("en2","UTF-8")+"="+URLEncoder.encode(emergency_no2,"UTF-8")+"&"+
                    URLEncoder.encode("en3","UTF-8")+"="+URLEncoder.encode(emergency_no3,"UTF-8")+"&"+
                    URLEncoder.encode("en4","UTF-8")+"="+URLEncoder.encode(emergency_no4,"UTF-8");
            write.write(post_data);
            write.flush();write.close();
            out.close();
            InputStream in = http.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in,"iso-8859-1"));
            String result = "";
            String line = "";
            while ((line=read.readLine())!=null){
                result += line;
            }
            read.close();
            in.close();
            http.disconnect();
            return result;

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return  null;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Message");
        alertDialog.setMessage("Please Wait");
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate( String... values) {
        super.onProgressUpdate(values);
    }

}

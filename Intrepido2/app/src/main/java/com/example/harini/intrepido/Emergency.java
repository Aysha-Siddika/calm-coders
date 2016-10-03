package com.example.harini.intrepido;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Emergency extends AppCompatActivity {

        ImageButton helpbtn,smugbtn;


        AppLocationService appLocationService;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_emergency);
            appLocationService = new AppLocationService(
                    Emergency.this);


            helpbtn = (ImageButton) findViewById(R.id.help);
            helpbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {

                    Location location = appLocationService
                            .getLocation(LocationManager.GPS_PROVIDER);

                    if (location != null) {
                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();

                        LocationAddress locationAddress = new LocationAddress();
                        locationAddress.getAddressFromLocation(latitude, longitude,
                                getApplicationContext(), new GeocoderHandler());
                        String result = "Latitude: " + latitude +
                                " Longitude: " + longitude;

                    }
                    else
                    {
                        showSettingsAlert();
                    }

                }
            });

            smugbtn = (ImageButton) findViewById(R.id.smug);
            smugbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {

                    Location location = appLocationService
                            .getLocation(LocationManager.GPS_PROVIDER);

                    if (location != null) {
                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();

                        LocationAddress locationAddress = new LocationAddress();
                        locationAddress.getAddressFromLocation(latitude, longitude,
                                getApplicationContext(), new GeocoderHandler1());
                        String result = "Latitude: " + latitude +
                                " Longitude: " + longitude;

                    }
                    else
                    {
                        showSettingsAlert();
                    }

                }
            });

        }




        public void showSettingsAlert() {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                    Emergency.this);
            alertDialog.setTitle("SETTINGS");
            alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
            alertDialog.setPositiveButton("Settings",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(
                                    Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            Emergency.this.startActivity(intent);
                        }
                    });
            alertDialog.setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            alertDialog.show();
        }

        private class GeocoderHandler extends Handler {
            @Override
            public void handleMessage(Message message) {
                String locationAddress;
                switch (message.what) {
                    case 1:
                        Bundle bundle = message.getData();
                        locationAddress = bundle.getString("address");
                        break;
                    default:
                        locationAddress = null;
                }
                sendSMSMessage(locationAddress);
            }
        }
        protected void sendSMSMessage(String ret) {

            // fetch the Sms Manager


            try {
                SmsManager sms = SmsManager.getDefault();

                // the message
                String message = "I am in danger pls help me this is my location" + ret;

// the phone numbers we want to send to
                String numbers[] = {"9487875668","9498085083"};

                for (String number : numbers)
                {
                    sms.sendTextMessage(number, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }


    private class GeocoderHandler1 extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            sendSMSMessage1(locationAddress);
        }
    }
    protected void sendSMSMessage1(String ret) {

        // fetch the Sms Manager


        try {
            SmsManager sms = SmsManager.getDefault();

            // the message
            String message = "A smuggler is found in my vechicle" + ret;

// the phone numbers we want to send to
            String numbers[] = {"9487875668","9498085083"};

            for (String number : numbers)
            {
                sms.sendTextMessage(number, null, message, null, null);
                Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }



}
package com.example.harini.intrepido;

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
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Start extends AppCompatActivity {
    ImageButton startbtn;
    Button next;
    AppLocationService appLocationService;
    Emergency emergency = new Emergency();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        appLocationService = new AppLocationService(
                Start.this);
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
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {

        switch (keyCode) {


            case KeyEvent.KEYCODE_VOLUME_UP:
                Toast.makeText(this, "Volume Up pressed", Toast.LENGTH_SHORT).show();
                Location location = appLocationService.getLocation(LocationManager.GPS_PROVIDER);
                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();

                    LocationAddress locationAddress = new LocationAddress();
                    locationAddress.getAddressFromLocation(latitude, longitude,
                            getApplicationContext(), new GeocoderHandler());
                    String result = "Latitude: " + latitude +
                            " Longitude: " + longitude;
                } else
                {
                    showSettingsAlert();
                }
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Toast.makeText(this,"Volumen Down pressed", Toast.LENGTH_SHORT).show();

                location = appLocationService
                        .getLocation(LocationManager.GPS_PROVIDER);

                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();

                    LocationAddress locationAddress = new LocationAddress();
                    locationAddress.getAddressFromLocation(latitude, longitude,
                            getApplicationContext(),new GeocoderHandler());
                    String result = "Latitude: " + latitude +
                            " Longitude: " + longitude;
                } else
                {
                    showSettingsAlert();
                }

        }
        return super.onKeyDown(keyCode, event);


    }

    private void showSettingsAlert()
    {


            AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                    Start.this);
            alertDialog.setTitle("SETTINGS");
            alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
            alertDialog.setPositiveButton("Settings",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(
                                    Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            Start.this.startActivity(intent);
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


    public class GeocoderHandler extends Handler {
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

            emergency.sendSMSMessage(locationAddress);
        }
    }
}


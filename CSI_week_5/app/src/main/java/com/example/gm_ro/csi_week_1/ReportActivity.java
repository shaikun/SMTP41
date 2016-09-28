package com.example.gm_ro.csi_week_1;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.common.api.GoogleApiClient;

public class ReportActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    public Integer taart = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final CriminalProvider criminalProvider = new CriminalProvider(getApplicationContext());
        super.onCreate(savedInstanceState);
        final GPSTracker gps = new GPSTracker(this);
        setContentView(R.layout.activity_report);

        Button button = (Button) findViewById(R.id.bBack);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CSI_week_1.class);
                startActivity(intent);
            }
        });

        final ToggleButton togybutton = (ToggleButton) findViewById(R.id.tbGps);
        assert togybutton != null;
        togybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // create class object
                    //gps = new GPSTracker(AndroidGPSTrackingActivity.this);
                if (taart == 0) {
                    // check if GPS enabled
                    taart++;
                    if (gps.canGetLocation()) {

                        double latitude = gps.getLatitude();
                        double longitude = gps.getLongitude();

                        // \n is for new line
                        Integer pos = getIntent().getExtras().getInt("lastloc");

                        Location loc1 = new Location("");
                        loc1 = criminalProvider.GetCriminal(pos).lastKnownLocation;

                        Location loc2 = new Location("");
                        loc2.setLatitude(latitude);
                        loc2.setLongitude(longitude);

                        float distanceInMeters = loc1.distanceTo(loc2);

                        Toast.makeText(getApplicationContext(), "You are  " + distanceInMeters + "meter from the last seen location of the criminal", Toast.LENGTH_LONG).show();
                    } else {
                        // can't get location
                        // GPS or Network is not enabled
                        // Ask user to enable GPS/network in settings
                        gps.showSettingsAlert();
                    }
                }
                else {
                    taart = 0;
                }
            }
        });
    }
}



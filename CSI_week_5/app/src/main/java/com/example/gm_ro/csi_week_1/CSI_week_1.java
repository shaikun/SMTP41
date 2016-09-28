package com.example.gm_ro.csi_week_1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class CSI_week_1 extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    public Integer pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Integer pos = 0;
        final CriminalProvider criminalProvider = new CriminalProvider(getApplicationContext());
        setContentView(R.layout.activity_csi_week_1);

        Button button = (Button) findViewById(R.id.bRepport);
        assert button != null;



        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Integer loco = getIntent().getExtras().getInt("posistion");
                Intent i = new Intent(getApplicationContext(), ReportActivity.class);
                i.putExtra("lastloc",loco);
                startActivity(i);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
               pos = 0;
            } else {
                pos = getIntent().getExtras().getInt("posistion");

                // getting objexts
                TextView tvName = (TextView) findViewById(R.id.tvName);
                TextView tvAge = (TextView) findViewById(R.id.tvAge);
                TextView tvGender = (TextView) findViewById(R.id.tvGender);
                TextView tvBounty = (TextView) findViewById(R.id.tvBounty);
                TextView tvDesc = (TextView) findViewById(R.id.tvDesc);
                // getting criminal details
                String name = criminalProvider.GetCriminal(pos).name;
                String gender = criminalProvider.GetCriminal(pos).gender;
                Integer iage = criminalProvider.GetCriminal(pos).age;
                String age = iage.toString();
                Integer ibounty = criminalProvider.GetCriminal(pos).getBountyInDollars();
                String bounty = ibounty.toString();
                String desc = criminalProvider.GetCriminal(pos).description;
                // setting values
                tvName.setText(name);
                tvAge.setText(age);
                tvGender.setText(gender);
                tvBounty.setText(bounty);
                tvDesc.setText(desc);
                //ListView listview = (ListView) findViewById(R.id.lvCrimes);
                //final String[] criminals = getResources().getStringArray(R.array.criminalNames);
                //Criminal criminal = criminalProvider.GetCriminal(pos);
                //final Crimelistadapter adapter = new Crimelistadapter(getApplicationContext(), criminal.crimes);
                //listview.setAdapter(adapter);

            }
        } else {
            /*newString= (String) savedInstanceState.getSerializable("posistion");
            TextView t = (TextView) findViewById(R.id.tvName);
            assert t != null;
            t.setText(newString);*/
        }
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CSI_week_1 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.gm_ro.csi_week_1/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CSI_week_1 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.gm_ro.csi_week_1/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

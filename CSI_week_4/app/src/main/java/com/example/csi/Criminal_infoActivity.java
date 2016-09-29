package com.example.csi;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import java.util.List;

public class Criminal_infoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminal_info);

        CriminalProvider provider = new CriminalProvider(getApplicationContext());

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();

            int chosenCriminalPosition = bundle.getInt("chosenCriminalPosition");

            Criminal criminal = provider.GetCriminals().get(chosenCriminalPosition);

            TextView name = (TextView) findViewById(R.id.nameDetailView);

            name.setText(criminal.name);
        }
    }
}

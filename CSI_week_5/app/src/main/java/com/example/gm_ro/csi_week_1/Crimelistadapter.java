package com.example.gm_ro.csi_week_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gm_ro on 22-9-2016.
 */

public class Crimelistadapter extends ArrayAdapter<Crime> {



    private Context context;
    public List<Crime> crimes;

    public Crimelistadapter(Context context, List<Crime> crimes) {
        super(context, R.layout.itemlist, crimes);

        this.context = context;
        this.crimes = crimes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Crime requestedCrime = crimes.get(position);

            View crimeview = convertView;

        if(crimeview == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            crimeview = inflater.inflate(R.layout.crimeitemlist, null);

        }

        //TOOD: replace this simple view by the layout as defined in criminallistitem.xml"
        TextView crimenaam = (TextView) crimeview.findViewById(R.id.tvCrimeNaam);
        crimenaam.setText("Naam: " + requestedCrime.name);

        TextView crimebounty = (TextView) crimeview.findViewById(R.id.tvCrimeBounty);
        crimebounty.setText("Bounty: " + requestedCrime.bountyInDollars);

        TextView crimDesc = (TextView) crimeview.findViewById(R.id.tvCrimeDesc);
        crimDesc.setText("Desc:  " + requestedCrime.description);
        return crimeview;
}}


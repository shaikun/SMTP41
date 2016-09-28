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

public class Criminallistadapter extends ArrayAdapter<Criminal> {

    private Context context;
    private List<Criminal> criminals;

    public Criminallistadapter(Context context, List<Criminal> criminals) {
        super(context, R.layout.itemlist, criminals);

        this.context = context;
        this.criminals = criminals;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Criminal requestedCriminal = criminals.get(position);

            View criminalView = convertView;

        if(criminalView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            criminalView = inflater.inflate(R.layout.itemlist, null);

        }

        //TOOD: replace this simple view by the layout as defined in criminallistitem.xml"
        ImageView image = (ImageView) criminalView.findViewById(R.id.ivmug);
        image.setImageDrawable(requestedCriminal.mugshot);

        TextView view = (TextView) criminalView.findViewById(R.id.tvnaam);
        view.setText("Criminal: " + requestedCriminal.name);

        TextView bountyview = (TextView) criminalView.findViewById(R.id.tvbounty);
        bountyview.setText("Total Bounty: $ " + requestedCriminal.getBountyInDollars());
        return criminalView;
}}


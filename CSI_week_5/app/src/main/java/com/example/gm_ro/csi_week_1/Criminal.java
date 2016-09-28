package com.example.gm_ro.csi_week_1;

import android.graphics.drawable.Drawable;
import android.location.Location;

import java.util.ArrayList;

/**
 * Created by gm_ro on 22-9-2016.
 */

public class Criminal {
    public String name;
    public String gender;
    public String description;
    public int age;

    public ArrayList<Crime> crimes;

    public Drawable mugshot;
    public Location lastKnownLocation;

    public int getBountyInDollars() {
        int bounty = 0;
        for(Crime crime : crimes) {
            bounty += crime.bountyInDollars;

        }

        return bounty;
    }
}

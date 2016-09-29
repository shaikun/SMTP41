package com.example.csi;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("InflateParams")  // See: https://code.google.com/p/android-developer-preview/issues/detail?id=1203
public class CriminalListAdapter extends ArrayAdapter<Criminal> {

	private Context context;
	private List<Criminal> criminals;

	public CriminalListAdapter(Context context, List<Criminal> criminals) {
		super(context, R.layout.criminallistitem, criminals);
		
		this.context = context;
		this.criminals = criminals;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		Criminal requestedCriminal = criminals.get(position);

		View criminalView = convertView;
		if(criminalView == null){
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			criminalView = inflater.inflate(R.layout.criminallistitem, null);
		}
		((TextView)criminalView.findViewById(R.id.nameView)).setText(requestedCriminal.name);
		((TextView)criminalView.findViewById(R.id.bountyView)).setText("" + requestedCriminal.getBountyInDollars());
		((ImageView)criminalView.findViewById(R.id.mugshotView)).setImageDrawable(requestedCriminal.mugshot);

		return criminalView;
	}

	@Override
	public int getCount() {
		return criminals.size();
	}

	@Override
	public Criminal getItem(int position) {
		return criminals.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}

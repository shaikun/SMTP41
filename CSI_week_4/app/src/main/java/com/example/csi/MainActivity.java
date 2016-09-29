package com.example.csi;

import java.util.List;

import com.example.csi.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//Some example code below on how to use CriminalProvider:
		CriminalProvider criminalProvider = new CriminalProvider(getApplicationContext() );
		List<Criminal> criminals = criminalProvider.GetCriminals();
		
		CriminalListAdapter adapter = new CriminalListAdapter(this, criminals);
		ListView listView = ((ListView)findViewById(R.id.criminalView));

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				Intent intent = new Intent(MainActivity.this, Criminal_infoActivity.class);

				intent.putExtra("chosenCriminalPosition", position);

				startActivity(intent);
			}
		});
		listView.setAdapter(adapter);
	}

}

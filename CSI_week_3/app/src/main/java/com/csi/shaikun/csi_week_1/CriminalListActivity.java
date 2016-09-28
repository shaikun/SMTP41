package com.csi.shaikun.csi_week_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CriminalListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminal_list);

        //Get a reference to the listview
        ListView listview = (ListView) findViewById(R.id.listview1);
        //Get a reference to the list with names
        final String[] criminals = getResources().getStringArray(R.array.names);
        //Create an adapter that feeds the data to the listview
        listview.setAdapter(
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        criminals
                )
        );

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get the name from the array that is in the same position as the chosen listitem.
                String name = criminals[position];

                Intent intent = new Intent(CriminalListActivity.this, MainActivity.class);
                intent.putExtra("name", name);

                startActivity(intent);

            }
        });

    }
}

package com.csi.shaikun.csi_week_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView nameTextView = (TextView)findViewById(R.id.textViewName);
        nameTextView.setText(name);

        findViewById(R.id.report_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReportActivity.class);
                startActivity(intent);
            }
        });
    }
}

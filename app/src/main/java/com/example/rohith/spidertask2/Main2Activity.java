package com.example.rohith.spidertask2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.sql.Time;

public class Main2Activity extends AppCompatActivity {

    TextView message,timestamp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        message = (TextView) findViewById(R.id.message);
        timestamp = (TextView) findViewById(R.id.timestamp);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String datetime = i.getStringExtra("time");
        message.setText("Thank you "+name+" for your response ... ");   //displaying thank ypu message
        timestamp.setText("Your responses has been recorded at "+datetime); //displaying timestamp
    }

    public void backing(View v) { //executing back button functions
        finish();
    }
}

package com.example.fragmentdatapass.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.fragmentdatapass.R;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        // Init Views
        TextView userName = findViewById(R.id.userName);
        TextView occupation = findViewById(R.id.occupation);
        TextView salary = findViewById(R.id.income);

        // Get and set intent data
        userName.setText(getIntent().getStringExtra("userName"));
        occupation.setText(getIntent().getStringExtra("occupation"));
        salary.setText(getIntent().getStringExtra("income"));

    }
}
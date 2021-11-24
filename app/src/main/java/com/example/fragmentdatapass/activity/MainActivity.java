package com.example.fragmentdatapass.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentdatapass.R;
import com.example.fragmentdatapass.fragments.FragmentA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Send data from Activity to Fragment
        FragmentA fragmentA = new FragmentA();
        Bundle bundle = new Bundle();
        bundle.putString("userName", "Mr. Sarowal");
        fragmentA.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerMainActivity, fragmentA)
                .commit();
    }
}
package com.example.fragmentdatapass.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fragmentdatapass.R;
import com.example.fragmentdatapass.activity.ChildActivity;

public class FragmentB extends Fragment {

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        // Init Views
        TextView textViewName = view.findViewById(R.id.textViewFragmentB);
        TextView textViewOccupation = view.findViewById(R.id.textViewOccupation);
        EditText editTextIncome = view.findViewById(R.id.editTextIncome);
        Button next = view.findViewById(R.id.next);

        // Change activity title
        getActivity().setTitle("Fragment B");

        // Get and set data to the view
        Bundle bundle = this.getArguments();
        String name = bundle.getString("userName");
        String occupation = bundle.getString("occupation");
        textViewName.setText(name);
        textViewOccupation.setText(occupation);

        // Send data from fragment to Activity on next button click
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChildActivity.class);
                intent.putExtra("userName", name);
                intent.putExtra("occupation", occupation);
                intent.putExtra("income", editTextIncome.getText().toString());
                startActivity(intent);
            }
        });

        return view;
    }
}
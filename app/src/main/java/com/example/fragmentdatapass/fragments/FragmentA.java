package com.example.fragmentdatapass.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fragmentdatapass.R;

public class FragmentA extends Fragment {

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        // Init Views
        TextView textViewName = view.findViewById(R.id.textViewFragmentA);
        EditText editTextOccupation = view.findViewById(R.id.editTextOccupation);
        Button buttonNext = view.findViewById(R.id.buttonNext);

        // Change activity title
        getActivity().setTitle("Fragment A");

        // Get and set data
        Bundle bundle = this.getArguments();
        String name = bundle.getString("userName");
        textViewName.setText(name);

        // Send data from fragment to fragment on next button click
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle1.putString("userName", name);
                bundle1.putString("occupation", editTextOccupation.getText().toString());
                FragmentB fragmentB = new FragmentB();
                fragmentB.setArguments(bundle1);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerMainActivity, fragmentB)
                        .commit();
            }
        });

        return view;
    }
}
package com.example.project01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Multiply extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_multiply, container, false);
        Button b1=(Button) view.findViewById(R.id.b1_f3);
        TextView res=(TextView)view.findViewById(R.id.res_f3);
        EditText t1=(EditText) view.findViewById(R.id.n1_f3);
        EditText t2=(EditText) view.findViewById(R.id.n2_f3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a=Float.parseFloat(t1.getText().toString());
                float b=Float.parseFloat(t2.getText().toString());

                res.setText(""+a*b);
            }
        });
        return view;
    }
}
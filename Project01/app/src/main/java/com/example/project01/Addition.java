package com.example.project01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Addition extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_addition, container, false);

        Button b1=(Button)view.findViewById(R.id.b1_f1);
        TextView res=view.findViewById(R.id.res_f1);
        EditText t1=(EditText) view.findViewById(R.id.n1_f1);
        EditText t2=(EditText) view.findViewById(R.id.n2_f1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float n1=Float.parseFloat(t1.getText().toString());
                float n2=Float.parseFloat(t2.getText().toString());

                float sum=n1+n2;
                res.setText(""+sum);


            }
        });

        return  view;
    }
}
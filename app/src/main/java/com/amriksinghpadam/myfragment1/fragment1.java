package com.amriksinghpadam.myfragment1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class fragment1 extends Fragment {

    private EditText te;
    private Button btn;
    private TextView tv;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        te = getActivity().findViewById(R.id.frag1EditTxt);
        tv = getActivity().findViewById(R.id.frag1TXTId);
        btn = getActivity().findViewById(R.id.frag1BTNID);
        final FragmentManager fm = getFragmentManager();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String s = te.getText().toString();

                fragment2 frag2 = (fragment2) fm.findFragmentById(R.id.layoutID2);

                frag2.changeData(s);
            }
        });

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }
    public void changeData(String s){

        tv.setText(s);
    }


}

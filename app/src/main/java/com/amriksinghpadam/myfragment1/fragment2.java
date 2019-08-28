package com.amriksinghpadam.myfragment1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class fragment2 extends Fragment {

    private TextView tv;
    private EditText et;
    private Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv = getActivity().findViewById(R.id.frag2TXTId);
        et = getActivity().findViewById(R.id.frag2EditTxt);
        btn = getActivity().findViewById(R.id.frag2BTNID);
        final FragmentManager fm = getFragmentManager();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = et.getText().toString();
                try {
                    fragment1 fragg = (fragment1) fm.findFragmentById(R.id.layoutID1);
                    if(fragg!=null){
                        fragg.changeData(s);
                    }else{
                        Toast.makeText(getContext(),"Fragment Is Not VIsible",Toast.LENGTH_SHORT).show();
                    }
                }catch (ClassCastException e){
                    Toast.makeText(getContext(),"Fragment Is Not VIsible",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public void changeData(String s){
        tv.setText(s);
    }


}

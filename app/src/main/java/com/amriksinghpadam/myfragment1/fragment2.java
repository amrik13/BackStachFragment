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

    private TextView tv,mt;
    private EditText et;
    private Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_fragment2, container, false);
        tv = v.findViewById(R.id.frag2TXTId);
        et = v.findViewById(R.id.frag2EditTxt);
        btn = v.findViewById(R.id.frag2BTNID);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                mt = getActivity().findViewById(R.id.mainTxtId);
                String s = et.getText().toString();
                try {
                    fragment1 fragg = (fragment1) fm.findFragmentById(R.id.layoutID1);
                    if(fragg!=null){
                        mt.setText(s);
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

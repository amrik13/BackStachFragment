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


public class fragment1 extends Fragment {

    private EditText te;
    private Button btn;
    private TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);
             btn = v.findViewById(R.id.frag1BTNID);
             tv = v.findViewById(R.id.frag1TXTId);
             te = v.findViewById(R.id.frag1EditTxt);
        return v;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                FragmentManager fm = getFragmentManager();
                String s = te.getText().toString();

                fragment2 frag = (fragment2) fm.findFragmentById(R.id.layoutID2);
                frag.changeData(s);
            }
        });
    }

    public void changeData(String s){ tv.setText(s); }
}

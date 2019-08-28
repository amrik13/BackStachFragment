package com.amriksinghpadam.myfragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button shiftBtn;
    private FragmentManager fm = getSupportFragmentManager();
    private int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Switch Fragment");

        shiftBtn = findViewById(R.id.shiftingID);

        shiftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment frag=null;
                if(count%2!=0){
                    frag = new fragment1();
                    count++;
                }else{
                    frag = new fragment2();
                    count++;
                }

                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.layoutID,frag,"abc");
                //ft.addToBackStack(null);
                ft.commit();
            }
        });


    }

    @Override
    public void onBackPressed() {
        Fragment frag1 = fm.findFragmentById(R.id.layoutID);
        if(frag1 != null){
            FragmentTransaction ft = fm.beginTransaction();
            ft.remove(frag1);
            count--;
            ft.commit();
        }else{
            super.onBackPressed();
        }

    }
}

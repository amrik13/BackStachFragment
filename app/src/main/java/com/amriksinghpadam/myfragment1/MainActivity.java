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

public class MainActivity extends AppCompatActivity implements Connetor {

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
                    frag = new fragment2();
                    count++;
                }else{
                    frag = new fragment1();
                    count++;
                }

                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.layoutID1,frag,"abc");
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        Fragment frag2 = new fragment2();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.layoutID2,frag2);
        ft.commit();

    }

//    @Override
//    public void onBackPressed() {
//        Fragment frag1 = fm.findFragmentById(R.id.layoutID1);
//        if(frag1 != null){
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.remove(frag1);
//            count--;
//            ft.commit();
//        }else{
//            super.onBackPressed();
//        }
//
//    }

    @Override
    public void connect(String str) {
        FragmentManager fm = getSupportFragmentManager();
        fragment2 frag2 = (fragment2) fm.findFragmentById(R.id.layoutID2);
        frag2.changeData(str);
    }
}

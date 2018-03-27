package com.arham.csdevbin.fragmentcommunication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnMessageReadListener {

    public static FragmentManager fragmentManager;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        textView = findViewById(R.id.textView);

        if (findViewById(R.id.frag_container) != null) {

            if (savedInstanceState != null) {
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.frag_container, homeFragment, null);
            fragmentTransaction.commit();

        }

    }

    @Override
    public void onMessageRead(String message) {
        textView.setText(message);
    }
}
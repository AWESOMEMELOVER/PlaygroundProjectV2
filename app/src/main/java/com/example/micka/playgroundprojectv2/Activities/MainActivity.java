package com.example.micka.playgroundprojectv2.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.micka.playgroundprojectv2.Fragments.BeaconFragment;
import com.example.micka.playgroundprojectv2.Fragments.SettingFragment;
import com.example.micka.playgroundprojectv2.Fragments.TrackingFragment;
import com.example.micka.playgroundprojectv2.Models.GlobalUser;
import com.example.micka.playgroundprojectv2.R;

public class MainActivity extends FragmentActivity {

    private TextView mTextMessage;
    static GlobalUser globalUser = new GlobalUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchFragment(new BeaconFragment());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_beacon:
                    switchFragment(new BeaconFragment());
                    return true;
                case R.id.navigation_tracking:
                    switchFragment(new TrackingFragment());
                    return true;
                case R.id.navigation_settings:
                    switchFragment(new SettingFragment());
                    return true;
            }

            return false;
        }
    };

    private void switchFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_replaceble_container,fragment);
        fragmentTransaction.commit();

    }

}

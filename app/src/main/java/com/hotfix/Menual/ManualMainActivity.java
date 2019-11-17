package com.hotfix.Menual;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.hotfix.Back.BackPressCloseHandler;
import com.hotfix.Cumu.ReviewList;
import com.hotfix.Start.StartActivity;
import com.bufsrepair.R;
import com.hotfix.toolguide.ToolList;
import com.hotfix.toolmaps.ToolMaps;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class ManualMainActivity extends AppCompatActivity {
    HomeRepairManualFragment homeRepairManualFragment;
    AllVideosFragment allVideosFragment;
    BottomNavigationView bottomNavigationView;

    private BackPressCloseHandler backPressCloseHandler;

    Intent intent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) { switch (item.getItemId()) {
            case R.id.navigation_start:
                intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();
                return  true;
            case R.id.navigation_menual:

                return true;
            case R.id.navigation_cumu1:
                intent = new Intent(getApplicationContext(), ReviewList.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.navigation_toolmaps:
                intent = new Intent(getApplicationContext(), ToolMaps.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.navigation_toolguide:
                intent = new Intent(getApplicationContext(), ToolList.class);
                startActivity(intent);
                finish();
                return true;
        }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_main);
        ActionBar abar = getSupportActionBar();
        abar.hide();


        backPressCloseHandler = new BackPressCloseHandler(this);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_menual);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        */

        homeRepairManualFragment = new HomeRepairManualFragment();
        allVideosFragment = new AllVideosFragment();

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("집수리 매뉴얼"));
        tabs.addTab(tabs.newTab().setText("모든 동영상"));

        tabs.setSelectedTabIndicatorColor( Color.WHITE);
        tabs.setTabTextColors(Color.DKGRAY,  Color.WHITE);


        intent = getIntent();
        String data = intent.getStringExtra("name");

        if (data.equals("집수리 매뉴얼")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeRepairManualFragment).commit();
            TabLayout.Tab tab = tabs.getTabAt(0);
            tab.select();
        } else if (data.equals("동영상")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, allVideosFragment).commit();
            TabLayout.Tab tab = tabs.getTabAt(1);
            tab.select();
        }

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected = null;
                if (position == 0) {
                    selected = homeRepairManualFragment;
                } else if (position == 1) {
                    selected = allVideosFragment;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }

}
package com.hotfix.Start;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.hotfix.Cumu.ReviewList;
import com.hotfix.Menual.ManualMainActivity;
import com.bufsrepair.R;
import com.hotfix.toolguide.ToolList;
import com.hotfix.toolmaps.ToolMaps;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class GuideList extends AppCompatActivity {
    com.hotfix.Start.SinkFragment sinkFragment;
    BasinFragment basinFragment;
    BathroomFragment bathroomFragment;
    com.hotfix.Start.TileFragment tileFragment;
    com.hotfix.Start.PaintFragment paintFragment;
    com.hotfix.Start.WallpaperFragment wallpaperFragment;
    com.hotfix.Start.ShelfFragment shelfFragment;
    com.hotfix.Start.MonitorFragment monitorFragment;
    DoorknobFragment doorknobFragment;


    Intent intent;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) { switch (item.getItemId()) {
            case R.id.navigation_start:
                intent = new Intent(getApplicationContext(), com.hotfix.Start.StartActivity.class);
                startActivity(intent);
                finish();
                return  true;
            case R.id.navigation_menual:
                intent = new Intent(getApplicationContext(), ManualMainActivity.class);
                intent.putExtra("name", "집수리 매뉴얼");
                finish();
                startActivity(intent);
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
        setContentView(R.layout.guide_list);

        ActionBar abar = getSupportActionBar();
        abar.hide();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_start);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        */

        sinkFragment = new com.hotfix.Start.SinkFragment();
        basinFragment = new BasinFragment();
        bathroomFragment = new BathroomFragment();
        tileFragment = new com.hotfix.Start.TileFragment();
        paintFragment = new com.hotfix.Start.PaintFragment();
        wallpaperFragment = new com.hotfix.Start.WallpaperFragment();
        shelfFragment = new com.hotfix.Start.ShelfFragment();
        monitorFragment = new com.hotfix.Start.MonitorFragment();
        doorknobFragment = new DoorknobFragment();

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("싱크대"));
        tabs.addTab(tabs.newTab().setText("세면대"));
        tabs.addTab(tabs.newTab().setText("화장실"));
        tabs.addTab(tabs.newTab().setText("타일"));
        tabs.addTab(tabs.newTab().setText("페인트"));
        tabs.addTab(tabs.newTab().setText("벽지"));
        tabs.addTab(tabs.newTab().setText("벽선반"));
        tabs.addTab(tabs.newTab().setText("모니터 받침대"));
        tabs.addTab(tabs.newTab().setText("문손잡이"));

        tabs.setSelectedTabIndicatorColor( Color.WHITE);
        tabs.setTabTextColors(Color.DKGRAY,  Color.WHITE);

        intent = getIntent();
        String data = intent.getStringExtra("value");

        if (data.equals("싱크대")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, sinkFragment).commit();
            TabLayout.Tab tab = tabs.getTabAt(0);
            tab.select();
        } else if (data.equals("세면대")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, basinFragment).commit();
            TabLayout.Tab tab = tabs.getTabAt(1);
            tab.select();
        } else if (data.equals("화장실")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, bathroomFragment).commit();
            TabLayout.Tab tab = tabs.getTabAt(2);
            tab.select();
        } else if (data.equals("타일")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, tileFragment).commit();
            TabLayout.Tab tab = tabs.getTabAt(3);
            tab.select();
        } else if (data.equals("페인트")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, paintFragment).commit();
            TabLayout.Tab tab = tabs.getTabAt(4);
            tab.select();
        } else if (data.equals("벽지")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, wallpaperFragment).commit();
            TabLayout.Tab tab = tabs.getTabAt(5);
            tab.select();
        } else if (data.equals("벽선반")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, shelfFragment).commit();
            TabLayout.Tab tab = tabs.getTabAt(6);
            tab.select();
        } else if (data.equals("모니터 받침대")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, monitorFragment).commit();
            TabLayout.Tab tab = tabs.getTabAt(7);
            tab.select();
        } else if (data.equals("문손잡이")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, doorknobFragment).commit();
            TabLayout.Tab tab = tabs.getTabAt(8);
            tab.select();
        }

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected = null;
                if (position == 0) {
                    selected = sinkFragment;
                } else if (position == 1) {
                    selected = basinFragment;
                } else if (position == 2) {
                    selected = bathroomFragment;
                } else if (position == 3) {
                    selected = tileFragment;
                } else if (position == 4) {
                    selected = paintFragment;
                } else if (position == 5) {
                    selected = wallpaperFragment;
                } else if (position == 6) {
                    selected = shelfFragment;
                } else if (position == 7) {
                    selected = monitorFragment;
                } else if (position == 8) {
                    selected = doorknobFragment;
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
}
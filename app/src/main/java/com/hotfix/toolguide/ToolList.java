package com.hotfix.toolguide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.hotfix.Back.BackPressCloseHandler;
import com.hotfix.Cumu.ReviewList;
import com.hotfix.Start.Fragmentcallback;
import com.hotfix.Start.StartActivity;
import com.hotfix.Menual.ManualMainActivity;
import com.bufsrepair.R;
import com.hotfix.toolmaps.ToolMaps;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class ToolList extends AppCompatActivity implements Fragmentcallback {
    Intent intent;
    ToolFragment toolFragment;
    ElectToolFragment electtoolFragment;
    CutToolFragment cuttoolFragment;
    AirToolFragment airtoolFragment;

    private BackPressCloseHandler backPressCloseHandler;

    Toolbar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) { switch (item.getItemId()) {
            case R.id.navigation_start:
                intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.navigation_menual:
                intent = new Intent(getApplicationContext(), ManualMainActivity.class);
                intent.putExtra("name", "집수리 매뉴얼");
                startActivity(intent);
                finish();
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

                return true;
        }
            return false;
        }
    };

    /* @Override
     public boolean onOptionsItemSelected(MenuItem item) {
         int curid = item.getItemId();
         switch (curid){
                 case R.id.menu_setting:
                 Toast.makeText(this,"설정메뉴클릭댐",Toast.LENGTH_LONG).show();
                 break;
             default:
                 break;
         }
         return super.onOptionsItemSelected(item);
     }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_main,menu);
         return true;
     }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tool_list);
        ActionBar abar = getSupportActionBar();
        abar.hide();

        backPressCloseHandler = new BackPressCloseHandler(this);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_toolguide);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //actionBar abar = getSupportActionBar();
        //abar.hide();
        // = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);//

        toolFragment = new ToolFragment();
        electtoolFragment = new ElectToolFragment();
        cuttoolFragment = new CutToolFragment();
        airtoolFragment = new AirToolFragment();
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("수공구"));
        tabs.addTab(tabs.newTab().setText("전동공구"));
        tabs.addTab(tabs.newTab().setText("절단공구"));
        tabs.addTab(tabs.newTab().setText("에어공구"));
        tabs.setSelectedTabIndicatorColor( Color.WHITE);
        tabs.setTabTextColors(Color.DKGRAY,  Color.WHITE);

        getSupportFragmentManager().beginTransaction().add(R.id.container1, toolFragment).commit();
        TabLayout.Tab tab = tabs.getTabAt(0);
        tab.select();
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if (position == 0) selected = toolFragment;
                else if (position == 1) selected = electtoolFragment;
                else if (position == 2) selected = cuttoolFragment;
                else if (position == 3) selected = airtoolFragment;
                getSupportFragmentManager().beginTransaction().replace(R.id.container1, selected).commit();
            }
        });
    }

    @Override
    public void onFragmentSelected(int position, Bundle bundle) {
        Fragment curFragment = null;

        if(position == 0){

            curFragment = airtoolFragment;

        } else if (position ==1){

            curFragment = cuttoolFragment;
        }else if (position ==2){

            curFragment = toolFragment;
        }else if (position ==3){

            curFragment = electtoolFragment;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container1,curFragment).commit();
    }

    @Override public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }
}

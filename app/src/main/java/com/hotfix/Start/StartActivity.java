package com.hotfix.Start;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import com.hotfix.Back.BackPressCloseHandler;
import com.hotfix.Cumu.BoardWrite;
import com.hotfix.Cumu.ReviewList;
import com.hotfix.Login.LoginPage;
import com.hotfix.Menual.ManualMainActivity;
import com.bufsrepair.R;
import com.hotfix.toolguide.ToolList;
import com.hotfix.toolmaps.ToolMaps;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StartActivity extends AppCompatActivity {

    private BackPressCloseHandler backPressCloseHandler;

    Intent intent;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int curId = item.getItemId();
        switch (curId) {
            case R.id.menu_refresh:

                SharedPreferences.Editor editor = getSharedPreferences("key", Activity.MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();

                Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
                finish();
                break;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) { switch (item.getItemId()) {
            case R.id.navigation_start:
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
        setContentView(R.layout.activity_start);



        backPressCloseHandler = new BackPressCloseHandler(this);

        intent = new Intent(getApplicationContext(), GuideList.class);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/badal.ttf");
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_start);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        Button button_sink = (Button) findViewById(R.id.button_sink);
        button_sink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), GuideList.class);
                intent.putExtra("value", "싱크대");
                startActivity(intent);
            }
        });
        button_sink.setTypeface(typeface);

        Button button_basin = (Button) findViewById(R.id.button_basin);
        button_basin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(getApplicationContext(), GuideList.class);
                intent.putExtra("value", "세면대");
                startActivity(intent);
            }
        });
        button_basin.setTypeface(typeface);


        Button button_bathroom = (Button) findViewById(R.id.button_bathroom);
        button_bathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(getApplicationContext(), GuideList.class);
                intent.putExtra("value", "화장실");
                startActivity(intent);
            }
        });
        button_bathroom.setTypeface(typeface);

        Button button_tile = (Button) findViewById(R.id.button_tile);
        button_tile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), GuideList.class);
                intent.putExtra("value", "타일");
                startActivity(intent);
            }
        });
        button_tile.setTypeface(typeface);

        Button button_paint = (Button) findViewById(R.id.button_paint);
        button_paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), GuideList.class);
                intent.putExtra("value", "페인트");
                startActivity(intent);
            }
        });
        button_paint.setTypeface(typeface);

        Button button_wallpaper = (Button) findViewById(R.id.button_wallpaper);
        button_wallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), GuideList.class);
                intent.putExtra("value", "벽지");
                startActivity(intent);
            }
        });
        button_wallpaper.setTypeface(typeface);

        Button button_shelf = (Button) findViewById(R.id.button_shelf);
        button_shelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), GuideList.class);
                intent.putExtra("value", "벽선반");
                startActivity(intent);
            }
        });
        button_shelf.setTypeface(typeface);

        Button button_monitor = (Button) findViewById(R.id.button_monitor);
        button_monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), GuideList.class);
                intent.putExtra("value", "모니터 받침대");
                startActivity(intent);
            }
        });
        button_monitor.setTypeface(typeface);

        Button button_doorknob = (Button) findViewById(R.id.button_doorknob);
        button_doorknob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), GuideList.class);
                intent.putExtra("value", "문손잡이");
                startActivity(intent);
            }
        });
        button_doorknob.setTypeface(typeface);
    }

    @Override public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }

}


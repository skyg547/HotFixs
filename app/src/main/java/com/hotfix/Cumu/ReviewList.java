package com.hotfix.Cumu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.hotfix.Back.BackPressCloseHandler;
import com.hotfix.Login.LoginPage;
import com.hotfix.Login.MySingleton;
import com.hotfix.Menual.ManualMainActivity;
import com.bufsrepair.R;
import com.hotfix.Start.StartActivity;
import com.hotfix.toolguide.ToolItem;
import com.hotfix.toolguide.ToolItemView;
import com.hotfix.toolguide.ToolList;
import com.hotfix.toolmaps.ToolMaps;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class ReviewList extends AppCompatActivity implements View.OnClickListener {
    ReviewAdapter adapter;
    SQLiteDatabase database;
    Cursor cursor;
    String title;
    String content;
    String name;
    int review_number;

    private BackPressCloseHandler backPressCloseHandler;

    private ListView listView = null;
    Intent intent;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.boardwirte_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int curId = item.getItemId();
        switch (curId) {
            case R.id.menu_write:

                intent = new Intent(getApplicationContext(), BoardWrite.class);
                startActivity(intent);

                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_start:
                    intent = new Intent(getApplicationContext(), StartActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_menual:
                    intent = new Intent(getApplicationContext(), ManualMainActivity.class);
                    intent.putExtra("name", "집수리 매뉴얼");
                    finish();
                    startActivity(intent);
                    return true;
                case R.id.navigation_cumu1:
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
        setContentView(R.layout.activity_review_list);

        backPressCloseHandler = new BackPressCloseHandler(this);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_cumu1);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        listView = (ListView) findViewById(R.id.listView);




        database = openOrCreateDatabase("database", MODE_PRIVATE, null);
        if (database != null) {
            // db 생성
            String tableName = "review_board";

            // 게시판 테이블
            String sql = "create table if not exists "+ tableName + "(_id integer PRIMARY KEY autoincrement, review_name text not null, review_title text not null, review_content text not null)";
            database.execSQL(sql);

            //댓글 테이블
            sql = "create table if not exists comment_table(_id integer PRIMARY KEY autoincrement, comment_name text not null, comment_content text not null)";
            database.execSQL(sql);




            sql = "select * from review_board";
            cursor = database.rawQuery(sql, null);

            adapter = new ReviewAdapter();

            for(int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                review_number = cursor.getInt(0);
                name = cursor.getString(1);
                title = cursor.getString(2);
                content = cursor.getString(3);
                adapter.addItem(new ReviewItem(review_number, name, title, content));
            }
            cursor.close();
        }



        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ReviewItem item = (ReviewItem) adapter.getItem(position);

                Intent intent = new Intent(getApplicationContext(), ReviewBoardClick.class);
                intent.putExtra("name", item.getName());
                intent.putExtra("title", item.getTitle());
                intent.putExtra("content", item.getContent());
                intent.putExtra("review_number", item.getReview_number());

                startActivity(intent);
            }
        });
    }

    class ReviewAdapter extends BaseAdapter {
        ArrayList<ReviewItem> items = new ArrayList<ReviewItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(ReviewItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ReviewItemView view = new ReviewItemView(getApplicationContext());

            ReviewItem item = items.get(position);
            view.setTitle(item.getTitle());
            view.setContent(item.getContent());

            return view;
        }
    }


    @Override
    public void onClick(View view) {

    }

    @Override public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }
}





//////////////////////////////////////
/* 종완이형 코드
public class ReviewList extends AppCompatActivity implements View.OnClickListener {
    private BackPressCloseHandler backPressCloseHandler;


    private JSONObject data;
    private ListView listView = null;
    Intent intent;
    private String serverUrl = "http://54.180.118.93:8080/comm/ReviewListGet.bo";
    ArrayList<ReviewDTO> oData = new ArrayList<ReviewDTO>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.boardwirte_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int curId = item.getItemId();
        switch (curId) {
            case R.id.menu_write:

                intent = new Intent(getApplicationContext(), BoardWrite.class);
                startActivity(intent);

                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_start:
                    intent = new Intent(getApplicationContext(), StartActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_menual:
                    intent = new Intent(getApplicationContext(), ManualMainActivity.class);
                    intent.putExtra("name", "집수리 매뉴얼");
                    finish();
                    startActivity(intent);
                    return true;
                case R.id.navigation_cumu1:
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
        setContentView(R.layout.activity_review_list);

        backPressCloseHandler = new BackPressCloseHandler(this);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_cumu1);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        listView = (ListView) findViewById(R.id.listView);

//        데이터 불러오기
        StringRequest stringRequest = new StringRequest(Request.Method.POST, serverUrl,
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            Log.i("zzzz", response);
                                            try {
                                                data = new JSONObject(response);

                            JSONArray item = data.getJSONArray("item");

                            for (int i = 0; i<item.length(); i++) {
                                JSONObject obj = new JSONObject(item.getString(i));

                                ReviewDTO reviewDTO = new ReviewDTO();

                                reviewDTO.setSeq(obj.getString("seq"));
                                reviewDTO.setReviewSubject(obj.getString("subject"));
                                reviewDTO.setReviewContent(obj.getString("content"));
                                reviewDTO.setReviewUserId(obj.getString("userId"));
                                reviewDTO.setReviewComment(obj.getString("comment"));
                                reviewDTO.setReviewLike(obj.getString("like"));
                                reviewDTO.setReviewInto(obj.getString("into"));


                                oData.add(reviewDTO);
                            }
                            //        ListView , Adapter 생성 및 연결


                            ReviewAdapter reviewAdapter = new ReviewAdapter();

                          //  reviewAdapter.addItem(oData);

                            listView.setAdapter(reviewAdapter);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), "현재 서버가 혼잡하오니 나중에 다시 시도해주시기 바랍니다",Toast.LENGTH_LONG).show();

                    }
                });
        MySingleton.getInstance(ReviewList.this).addToRequestque(stringRequest);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ReviewBoardClick.class);

                intent.putExtra("seq", oData.get(i).getSeq());
                intent.putExtra("userId", oData.get(i).getReviewUserId());
                intent.putExtra("subject", oData.get(i).getReviewSubject());
                intent.putExtra("content", oData.get(i).getReviewContent());
                intent.putExtra("comment", oData.get(i).getReviewComment());
                intent.putExtra("like", oData.get(i).getReviewLike());
                intent.putExtra("into", oData.get(i).getReviewInto());

                startActivity(intent);
            }
        });

    }



    @Override
    public void onClick(View view) {

    }

    @Override public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }

}

 */
package com.hotfix.Cumu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
import com.hotfix.toolguide.ToolList;
import com.hotfix.toolmaps.ToolMaps;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

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


                intent = new Intent(getApplicationContext(), com.hotfix.Cumu.BoardWrite.class);
                startActivity(intent);

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


                            com.hotfix.Cumu.ReviewAdapter reviewAdapter = new com.hotfix.Cumu.ReviewAdapter();

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
                Intent intent = new Intent(getApplicationContext(), com.hotfix.Cumu.ReviewBoardClick.class);

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
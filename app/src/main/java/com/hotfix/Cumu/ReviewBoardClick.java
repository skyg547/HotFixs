package com.hotfix.Cumu;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.Intent;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bufsrepair.R;
import com.hotfix.Login.MySingleton;
import com.hotfix.Login.PropertyManager;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//////////////////////////////////////////////////////////
//관우 코드

public class ReviewBoardClick extends AppCompatActivity {
    EditText edittext;
    String sql;
    RepleAdapter adapter;
    String content;
    String name;
    String loginId;
    TextView commentNumber;
    int commentSum = 0;

    int review_number;

    private AlertDialog dialog;
    SQLiteDatabase database;
    Cursor cursor;
    Intent intent;

    private String userId;
    private JSONObject data;
    private ListView listView = null;
    private String seq;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText reple = new EditText(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_board_click);

        button = (Button) findViewById(R.id.repleBtn);
        listView = (ListView) findViewById(R.id.repleView);
        commentNumber = (TextView) findViewById(R.id.commentData);


        /*Intent 데이터 불러오는 부분*/

        intent = getIntent();

        TextView userId = (TextView) findViewById(R.id.userId);
        TextView subjects = (TextView) findViewById(R.id.subjects);
        TextView contents = (TextView) findViewById(R.id.contents);

        userId.setText(intent.getStringExtra("name"));
        subjects.setText(intent.getStringExtra("title"));
        contents.setText(intent.getStringExtra("content"));

        review_number = intent.getIntExtra("review_number", 0);

        if (database == null) database = openOrCreateDatabase("database", MODE_PRIVATE, null);


        ///
        //database.execSQL("drop table if exists comment_table");
        ///


        SharedPreferences auto = getSharedPreferences("key", Activity.MODE_PRIVATE);
        loginId = auto.getString("user_id","");

        sql = "create table if not exists comment_table(_id integer PRIMARY KEY autoincrement, comment_id text not null, comment_name text not null, comment_content text not null)";
        database.execSQL(sql);


        sql = "select comment_name, comment_content from comment_table where comment_id = ?";
        String[] params = { Integer.toString(review_number) };
        cursor = database.rawQuery(sql, params);


        adapter = new RepleAdapter();

        for(int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            name = cursor.getString(0);
            content = cursor.getString(1);
            adapter.addItem(new RepleItem(name, content));
            commentSum++;
        }
        cursor.close();

        commentNumber.setText(Integer.toString(commentSum));

        listView.setAdapter(adapter);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opendialog();
            }
        });


    }

    public void opendialog() {
        edittext = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("댓글");
        builder.setMessage("내용을 입력하세요");
        builder.setView(edittext);
        builder.setPositiveButton("작성",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (edittext.getText().toString().trim().equals("")) {
                            Toast.makeText(getApplicationContext(), "내용이 없으면 추가가 되지 않습니다!" ,Toast.LENGTH_LONG).show();
                            return;
                        }

                        sql = "select user_name from user_table where user_id = ?";
                        String[] params = { loginId };
                        cursor = database.rawQuery(sql, params);
                        cursor.moveToNext();
                        String USERNAME = cursor.getString(0);

                        sql = "insert into comment_table(comment_id, comment_name, comment_content) values(?, ?, ?)";
                        String[] params2 = { Integer.toString(review_number), USERNAME, edittext.getText().toString() };
                        database.execSQL(sql, params2);

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);


                        Toast.makeText(getApplicationContext(), "댓글이 작성 되었습니다." ,Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }


    /*상단 메뉴 불러오고 함수 처리*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (database == null) database = openOrCreateDatabase("database", MODE_PRIVATE, null);
        String sql = "select user_id from user_table where user_name = ?";
        String[] params = {intent.getStringExtra("name")};
        cursor = database.rawQuery(sql, params);


        cursor.moveToNext();
        userId = cursor.getString(0);
        cursor.close();


        SharedPreferences auto = getSharedPreferences("key", Activity.MODE_PRIVATE);
        String loginId = auto.getString("user_id", "");

        if (loginId.equals(userId)) {
            getMenuInflater().inflate(R.menu.board_menu, menu);
            return true;
        }

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_02:
//                삭제버튼

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("안내").setMessage("삭제하시겠습니까?");
                builder.setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"글이 삭제되었습니다.",Toast.LENGTH_LONG).show();


                                String sql = "delete from review_board where review_name = ? and review_title = ?";
                                String[] params = {intent.getStringExtra("name"), intent.getStringExtra("title")};
                                database.execSQL(sql, params);


                                intent = new Intent(getApplicationContext(), ReviewList.class);
                                startActivity(intent);
                            }
                        });
                builder.setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"아니오를 선택했습니다.",Toast.LENGTH_LONG).show();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

        }


        return true;
    }



    class RepleAdapter extends BaseAdapter {
        ArrayList<RepleItem> items = new ArrayList<RepleItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(RepleItem item) {
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
            RepleItemView view = new RepleItemView(getApplicationContext());

            RepleItem item = items.get(position);
            view.setName(item.getName());
            view.setContent(item.getContent());

            return view;
        }
    }
}








/////////////////////////////////////////////////////////////////////////////////













//////////////////////////////////////////////////////////////////////////////////////
// 종완이형 코드


/*

public class ReviewBoardClick extends AppCompatActivity {
    private AlertDialog dialog;
    private String userId;
    private JSONObject data;
    private ListView listView = null;
    private String seq;
    private Button button;
    private String serverUrl = "http://54.180.118.93:8080/comm/RepleListGet.bo";
    private ArrayList<RepleDTO> oData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText reple = new EditText(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_board_click);

        button = (Button) findViewById(R.id.repleBtn);
        listView = (ListView) findViewById(R.id.repleView);

        */
/*Intent 데이터 불러오는 부분*//*

        Intent intent = getIntent();

        TextView user_id = (TextView) findViewById(R.id.userId);
        TextView subjects = (TextView)findViewById(R.id.subjects);
        TextView contents = (TextView)findViewById(R.id.contents);
        TextView comment = (TextView)findViewById(R.id.commentData);

        user_id.setText(intent.getStringExtra("userId"));
        subjects.setText(intent.getStringExtra("subject"));
        contents.setText(intent.getStringExtra("content"));
        comment.setText(intent.getStringExtra("comment"));
        */
/*끝*//*


        seq = intent.getStringExtra("seq");
        userId = intent.getStringExtra("userId");

        */
/*게시물 댓글 불러오는 부분*//*

        StringRequest stringRequest = new StringRequest(Request.Method.POST, serverUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("tiger", response);
                        try {
                            data = new JSONObject(response);

                            JSONArray repleItem = data.getJSONArray("repleItem");

                            for (int i = 0; i<repleItem.length(); i++) {
                                JSONObject obj = new JSONObject(repleItem.getString(i));

                                RepleDTO repleDTO = new RepleDTO();

                                repleDTO.setSeq(obj.getString("seq"));
                                repleDTO.setNumber(obj.getString("number"));
                                repleDTO.setUserid(obj.getString("userId"));
                                repleDTO.setComment(obj.getString("comment"));


                                oData.add(repleDTO);
                            }
                            //        ListView , Adapter 생성 및 연결


                            RepleAdapter repleAdapter = new RepleAdapter();

                           // repleAdapter.addItem(oData);

                            listView.setAdapter(repleAdapter);

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
                })
        {
            @Override
            protected Map<String,String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("seq", seq);

                return params;
            }
        };
        MySingleton.getInstance(ReviewBoardClick.this).addToRequestque(stringRequest);

        */
/*끝*//*





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog();
            }
        });


    }

    */
/*상단 메뉴 불러오고 함수 처리*//*


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        */
/*String id = PropertyManager.getInstance().getUserId();
         if(id.equals(userId)) {
            getMenuInflater().inflate(R.menu.board_menu, menu);
            return true;
        }

*//*

        SharedPreferences auto = getSharedPreferences("key", Activity.MODE_PRIVATE);;
        String loginId = auto.getString("user_id","");

        if(loginId.equals(userId)) {
            getMenuInflater().inflate(R.menu.board_menu, menu);
            return true;
        }

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            */
/*case R.id.menu_01:
//                수정버튼
                onClickAlter();
                return true;*//*

            case R.id.menu_02:
//                삭제버튼

                onClickDelete();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }
    */
/*끝*//*

    public void onClickAlter() {
        String url = "http://54.180.118.93:8080/comm/AlterProcess.bo";



    }

    public void onClickDelete() {
        final String url = "http://54.180.118.93:8080/comm/DeleteProcess.bo";
        AlertDialog.Builder builder = new AlertDialog.Builder(ReviewBoardClick.this);
        builder
                .setTitle("안내")
                .setMessage("삭제하시겠습니까?")
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        try {
                                            JSONObject json = new JSONObject(response);
                                            String code = json.getString("code");

                                            if (code.equals("1")) {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(ReviewBoardClick.this);
                                                dialog = builder.setMessage("글이 삭제되었습니다.")
                                                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                finish();
                                                            }
                                                        })
                                                        .create();
                                                dialog.show();

                                            }
                                        }
                                        catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "현재 서버가 혼잡하오니 나중에 다시 시도해주시기 바랍니다",Toast.LENGTH_LONG).show();

                            }
                        }){
                            @Override
                            protected Map<String,String> getParams()
                            {
                                Map<String, String> params = new HashMap<String, String>();
                                params.put("seq", seq);

                                return params;
                            }
                        };
                        MySingleton.getInstance(ReviewBoardClick.this).addToRequestque(stringRequest);
                    }
                })
                .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    */
/*커스텀 다이얼로그 오픈*//*

    public void opendialog() {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setSeq(seq);
        msgDialog.show(getSupportFragmentManager(), "msg_dialog");
    }
}*/

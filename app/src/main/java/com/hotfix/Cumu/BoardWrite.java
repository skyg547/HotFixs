package com.hotfix.Cumu;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.hotfix.Login.MySingleton;
import com.hotfix.Login.PropertyManager;
import com.bufsrepair.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * 1. 제목과 내용을 findViewById
 * 2. 글쓰기 버튼을 눌렀을 때 온클릭리스너
 * 3. StringRequest 를 이용해 미들웨어 연결
 * 4. ServerURL = http://172.22.201.235:8080/comm/ReviewBoardWrite.do
 *
 * */
public class BoardWrite extends AppCompatActivity {

    EditText subject;
    EditText content;
    private AlertDialog dialog;
    private String serverUrl ="http://54.180.118.93:8080/comm/ReviewBoardWrite.bo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_write);


        subject = (EditText) findViewById(R.id.subject);
        content = (EditText) findViewById(R.id.content);

        Button writeBtn = (Button) findViewById(R.id.writeBtn);

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String subjectData = subject.getText().toString();
                final String contentData = content.getText().toString();

                if (subjectData.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BoardWrite.this);
                    dialog = builder.setMessage("제목을 입력하세요.")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                    return;
                }
                if (contentData.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BoardWrite.this);
                    dialog = builder.setMessage("내용을 입력하세요.")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                    return;
                }
                StringRequest stringRequest = new StringRequest(Request.Method.POST, serverUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject json = new JSONObject(response);
                                    String code = json.getString("code");

                                    if(code.equals("1")) {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(BoardWrite.this);
                                        dialog = builder.setMessage("글을 등록하였습니다.")
                                                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        finish();
                                                    }
                                                })
                                                .create();
                                        dialog.show();
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "에러"+error,Toast.LENGTH_LONG).show();

                            }
                        }

                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        /*
                         * 제목, 내용, 유저아이디
                         * subject,content,userId
                         * */
                        SharedPreferences auto = getSharedPreferences("key", Activity.MODE_PRIVATE);
                        String loginId = auto.getString("user_id","");
                        params.put("user_id", loginId);
                        params.put("subject",subjectData);
                        params.put("content",contentData);

                        return params;
                    }
                };
                MySingleton.getInstance(BoardWrite.this).addToRequestque(stringRequest);
            }
        });
    }
}
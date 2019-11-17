package com.hotfix.Login;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;
import com.bufsrepair.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;


import org.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoinPage extends AppCompatActivity implements Validator.ValidationListener{
    @NotEmpty(message = "필수 입력항목입니다.")
    @Length(min = 4, max = 12, message="영문 4~12자로 입력해주세요")
    EditText user_id;

    //SQLite 변수 선언
    SQLiteDatabase database;

    @NotEmpty(message = "필수 입력항목입니다.")
    @Password
    EditText user_pw;
    @ConfirmPassword
    EditText user_chkpw;

    @NotEmpty(message = "필수 입력항목입니다.")
    EditText user_nick;

    @NotEmpty(message = "필수 입력항목입니다.")
    @Email(message = "이메일 형식으로 작성하세요")
    EditText user_email;

    String code;
    private AlertDialog dialog;
    private int valiCode = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_page);
        ActionBar abar = getSupportActionBar();
        abar.hide();

        user_id = (EditText) findViewById(R.id.user_id);
        user_pw = (EditText) findViewById(R.id.user_pw);
        user_chkpw = (EditText) findViewById(R.id.user_chpw);
        user_nick = (EditText) findViewById(R.id.user_nick);
        user_email = (EditText) findViewById(R.id.user_email);

        final Validator validator = new Validator(this);
        validator.setValidationListener(this);


        Button valiButton = (Button) findViewById(R.id.valiButton);

        //////////////////////////////////////////////////////////////////////
        // SQLite 코드 부분
        String databaseName = "database";
        openDatabase(databaseName);
        // //
        /////////////////////////////////////////////////////////////////////////

        valiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userId = user_id.getText().toString();
                if(userId.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinPage.this);
                    dialog = builder.setMessage("아이디를 입력해주세요.")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                    return;
                }
<<<<<<< HEAD
                //중복을 확인하는 코드

                 String sql = "select user_id from uesr_table Where user_id=' + '" + userId;
                 Cursor cursor =  database.rawQuery(sql,null);
=======
                //저장을

<<<<<<< HEAD
                String sql = "select user_id from user_table Where user_id=' + '" + userId;
=======
              String sql = "select user_id from uesr_table Where user_id=' + '" + userId;
                Cursor cursor = database.rawQuery(sql, null);

                Cursor cursor =  database.rawQuery(sql,null);
>>>>>>> a7e0505689175af89b9ac3209d58627dc718814c
                //
                if (cursor.getCount() == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinPage.this);
                    dialog = builder.setMessage("사용하셔도 좋은 아이디 입니다.")
                            .setNegativeButton("확인", null)
                            .create();
                    dialog.show();
                    valiCode = 1;
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinPage.this);
                    dialog = builder.setMessage("이미 존재하는 아이디 입니다.")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                    valiCode = 0;
                }

                cursor.close();
>>>>>>> fd55aa4bd940c3126d2ea597cb69cb74f622fa9b
                        
         /*      while(arrayList.isEmpty()){
                    int i=0;
                    if(user_id.equals(arrayList.get(i))){

                        code = "1";
                    }

<<<<<<< HEAD
                }*/
                code = "0";

=======
                }
*/
         /*
>>>>>>> fd55aa4bd940c3126d2ea597cb69cb74f622fa9b
                if (code.equals("1")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinPage.this);
                    dialog = builder.setMessage("이미 존재하는 아이디 입니다.")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                    valiCode = 0;

                } else if(code.equals("0")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinPage.this);
                    dialog = builder.setMessage("사용하셔도 좋은 아이디 입니다.")
                            .setNegativeButton("확인", null)
                            .create();
                    dialog.show();
                    valiCode = 1;
                }
<<<<<<< HEAD
=======

          */



>>>>>>> fd55aa4bd940c3126d2ea597cb69cb74f622fa9b
            }
        });


        Button join_button;
        join_button = (Button) findViewById(R.id.join_button);
        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();
            }
        });

    }

    // 데이터베이스 오픈 코드
    public void openDatabase(String databaseName) {
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);

        // db가 생성이 안됐으면 만들어주고
        if (database != null) {
            // db 생성
            String tableName = "user_table";
            createTable(tableName);
        }
        // 이미 돼 있으면 조회로 진행
        else {
             // 바로 조회
        }
    }

    // 테이블 생성 코드
    public void createTable(String tableName) {

        if (database != null) { // 데이터베이스가 오픈이 정상적으로 돼 있으면 실행
<<<<<<< HEAD
            String sql = "create table if not exists "+ tableName + " (user_id text PRIMARY KEY, user_pw text not null, user_name text not null, user_email text not null)";
=======
            String sql = "create table if not exists "+ tableName + " (user_id text PRIMARY KEY, password text not null, nickname text not null, email text not null)";
>>>>>>> fd55aa4bd940c3126d2ea597cb69cb74f622fa9b
            database.execSQL(sql);
        } else { //데이터베이스가 오픈이 안돼있으면 실행

        }
    }


    @Override
    public void onValidationSucceeded() {
        final String userId = user_id.getText().toString();
        final String userPw = user_pw.getText().toString();
        final String userName = user_nick.getText().toString();
        final String userEmail = user_email.getText().toString();

        if (valiCode == 1) {

            String sql = "insert into user_table(user_id,user_pw,user_nick,user_email) values( "+ userId + userPw+ userName+ userEmail+')';
            database.execSQL(sql);

            if (code.equals("1")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(JoinPage.this);
                dialog = builder.setMessage("회원가입에 성공했습니다.")
                        .setPositiveButton("확인", null)
                        .create();
                dialog.show();


                database.close();
                Intent intent = new Intent(getApplicationContext(), com.hotfix.Login.LoginPage.class);
                startActivity(intent);
                finish();

            } else if(code.equals("0")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(JoinPage.this);
                dialog = builder.setMessage("회원가입에 실패하였습니다.")
                        .setNegativeButton("확인", null)
                        .create();
                dialog.show();
            }



        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(JoinPage.this);
            dialog = builder.setMessage("아이디 중복체크 확인")
                    .setNegativeButton("확인", null)
                    .create();
            dialog.show();
        }


    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for(ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
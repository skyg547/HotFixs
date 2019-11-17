package com.hotfix.Login;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.hotfix.Back.BackPressCloseHandler;
import com.bufsrepair.R;
import com.hotfix.Start.StartActivity;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginPage extends AppCompatActivity implements Validator.ValidationListener{

    private BackPressCloseHandler backPressCloseHandler;
    SharedPreferences auto;
    @NotEmpty(message = "입력")
    @Length(min = 4, max = 12, message="4~12자로 입력해주세요")
    EditText etId;

    @Password
    @NotEmpty(message = "비밀번호를 입력하세요")
    EditText etPw;

    private String serverUrl = "http://54.180.118.93:8080/comm/UserLogin.do";
    private AlertDialog dialog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        backPressCloseHandler = new BackPressCloseHandler(this);



        ActionBar abar = getSupportActionBar();
        abar.hide();


    /*    if(loginId !=null && loginPwd != null) {

                Toast.makeText(getApplicationContext(), loginId +"님 자동로그인 입니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();

        }*/



        //처음에는 SharedPreferences에 아무런 정보도 없으므로 값을 저장할 키들을 생성한다.
        // getString의 첫 번째 인자는 저장될 키, 두 번쨰 인자는 값입니다.
        // 첨엔 값이 없으므로 키값은 원하는 것으로 하시고 값을 null을 줍니다.
        auto = getSharedPreferences("key", Activity.MODE_PRIVATE);
        String loginId = auto.getString("user_id","");
        String loginPwd= auto.getString("user_pw","");

        //MainActivity로 들어왔을 때 loginId와 loginPwd값을 가져와서 null이 아니면
        //값을 가져와 id가 부르곰이고 pwd가 네이버 이면 자동적으로 액티비티 이동.
        Log.d("loginId",loginId);
        Log.d("loginPwd",loginPwd);

        //loginId.equals(auto.getString("user_id","")) && loginPwd.equals(auto.getString("user_pw",""))
        if(!(loginId.equals("")&&loginPwd.equals(""))) {

                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();

        }



        etId = (EditText) findViewById(R.id.etId);
        etPw = (EditText) findViewById(R.id.etPass);

            final Validator validator = new Validator(this);
             validator.setValidationListener(this);

                Button joinButton = (Button)findViewById(R.id.joinButton);
                joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinPage.class);
                startActivity(intent);
            }
        });

        //로그인 버튼 클릭시..
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();


            }
        });


    }


    @Override
    public void onValidationSucceeded() {
        final String userId = etId.getText().toString();
        final String userPw = etPw.getText().toString();

        String code = "1";

        if (code.equals("1")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
            dialog = builder.setMessage("로그인 하였습니다.")
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                                        .create();
            dialog.show();

           // 기기에 사용자 정보(아이디, 비밀번호)를 등록함.
            //   PropertyManager.getInstance().setUserId(userId);
            // PropertyManager.getInstance().setUserPw(userPw);

            SharedPreferences.Editor autoLogin = auto.edit();
            autoLogin.putString("user_id", userId);
            autoLogin.putString("user_pw", userPw);
            //꼭 commit()을 해줘야 값이 저장됩니다 ㅎㅎ
            //
            autoLogin.commit();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
            dialog = builder.setMessage("아이디와 비밀번호를 확인하세요")
                    .setPositiveButton("확인", null)
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

    @Override public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }


}
package com.hotfix.Cumu;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

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

import static android.content.Context.MODE_PRIVATE;


///////////////////////////////////////////////
//관우 코드


public class MsgDialog extends AppCompatDialogFragment {
    SQLiteDatabase database;
    Cursor cursor;

    private AlertDialog dialog;

    private EditText msg;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.layout_dialog,null);

        msg = view.findViewById(R.id.edit_msg);

        String content = msg.getText().toString();


        String sql = "insert into comment_table(comment_name, comment_content) values(?, ?)";
                // "create table if not exists comment_table(_id integer PRIMARY KEY autoincrement, comment_name text not null, comment_content text not null)";
        database.execSQL(sql);

        return builder.create();
    }
}








//////////////////////////////////////








///////////////////////////////
// 종완이형 코드

/*

public class MsgDialog extends AppCompatDialogFragment {
    public String seq;
    private AlertDialog dialog;
    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    private TextView msg;
    private String serverUrl = "http://54.180.118.93:8080/comm/RepleWrite.bo";
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.layout_dialog,null);

        msg = view.findViewById(R.id.edit_msg);

        builder.setView(view)
                .setTitle("댓글")
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("작성", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject json = new JSONObject(response);
                                    String code = json.getString("code");

                                    if(code.equals("1")) {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext().getApplicationContext());
                                        dialog = builder.setMessage("등록완료.")
                                                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .create();
                                        dialog.show();
                                    } else if(code.equals("0")) {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext().getApplicationContext());
                                        dialog = builder.setMessage("등록실패.")
                                                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        dialog.dismiss();
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
                                        Toast.makeText(getActivity().getApplicationContext(), "현재 서버가 혼잡하오니 나중에 다시 시도해주시기 바랍니다",Toast.LENGTH_LONG).show();

                                    }
                                }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<String, String>();
                                String msgData = msg.getText().toString();

                                SharedPreferences auto = getActivity().getSharedPreferences("key", Activity.MODE_PRIVATE);
                                String loginId = auto.getString("user_id","");

                                params.put("user_id", loginId);
                                params.put("seq", getSeq());
                                params.put("edit_msg", msgData);

                                return params;
                            }
                        };
                        MySingleton.getInstance(MsgDialog.this.getActivity()).addToRequestque(stringRequest);
                    }
                });
        return builder.create();
    }
}*/

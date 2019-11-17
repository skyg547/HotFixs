package com.hotfix.Login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateUserId extends StringRequest {

    final static private String serverUrl = "http://54.180.118.93:8080/comm/ValidateUserId.do";

    private Map<String, String> parameters;

    public ValidateUserId(String userId, Response.Listener<String> listener) {
        super(Method.POST, serverUrl, listener, null);
        parameters = new HashMap<>();
        parameters.put("userId", userId);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }

}
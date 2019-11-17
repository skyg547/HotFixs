package com.hotfix.Login;

import android.content.Context;
import android.content.SharedPreferences;

public class PropertyManager {
    private static PropertyManager instance;

    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
        }
        return instance;
    }

    private static final String PREFS_NAME = "key";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_PW = "user_pw";

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    private PropertyManager() {
        mPrefs = MyApplication.getmContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();
    }

    public String getUserId() {
        return mPrefs.getString(KEY_USER_ID,"");
    }

    public void setUserId(String userId) {
        mEditor.putString(KEY_USER_ID, userId);
        mEditor.commit();
    }

    public String getUserPw() {
        return mPrefs.getString(KEY_USER_PW,"");
    }

    public void setUserPw(String userPw) {
        mEditor.putString(KEY_USER_PW, userPw);
        mEditor.commit();
    }
}
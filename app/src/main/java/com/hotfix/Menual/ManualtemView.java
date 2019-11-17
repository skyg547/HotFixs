package com.hotfix.Menual;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bufsrepair.R;

public class ManualtemView extends LinearLayout {
    TextView textView;
    public ManualtemView(Context context) {
        super(context);
    }

    public ManualtemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ManualtemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ManualtemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context){

       LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

       inflater.inflate(R.layout.menual_list_item,this,true);

        textView = (TextView) findViewById(R.id.items);
    }

    public void setName(String name){

        textView.setText(name);
    }
}

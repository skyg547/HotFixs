package com.hotfix.Menual;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bufsrepair.R;

public class ManualTextView extends LinearLayout {

    ImageView imageView;
    TextView textView;

    public ManualTextView(Context context) {
        super(context);
        init(context);
    }

    public ManualTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private  void init(Context context){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.manualtext_view,this,true);

        textView = (TextView) findViewById(R.id.itemtext);
    }


    public void setName(String name){

        textView.setText(name);

    }

    public void setImageView(int resid){
        imageView.setImageResource(resid);

    }

}

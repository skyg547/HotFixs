package com.hotfix.toolguide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bufsrepair.R;

public class ToolItemView extends LinearLayout {

    ImageView imageView;
    TextView textView;

    public ToolItemView(Context context) {
        super(context);
        init(context);
    }

    public ToolItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private  void init(Context context){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.toolitem_view,this,true);

        textView = (TextView) findViewById(R.id.itemtext);


        imageView = (ImageView) findViewById(R.id.itemimageview);

    }


    public void setName(String name){

        textView.setText(name);

    }

    public void setImageView(int resid){
        imageView.setImageResource(resid);

    }

}

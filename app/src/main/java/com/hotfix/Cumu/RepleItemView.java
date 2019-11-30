package com.hotfix.Cumu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bufsrepair.R;

public class RepleItemView extends ConstraintLayout {
    TextView textName;
    TextView textContent;

    public RepleItemView(Context context) {
        super(context);

        init(context);
    }

    public RepleItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.replelist_item, this, true);

        textName = (TextView) findViewById(R.id.repleUser);
        textContent = (TextView) findViewById(R.id.repleComment);
    }

    public void setName(String name) {
        textName.setText(name);
    }

    public void setContent(String content) {
        textContent.setText(content);
    }
}

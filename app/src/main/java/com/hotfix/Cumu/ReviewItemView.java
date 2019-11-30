package com.hotfix.Cumu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bufsrepair.R;

public class ReviewItemView extends ConstraintLayout {
    TextView textTitle;
    TextView textContent;

    public ReviewItemView(Context context) {
        super(context);

        init(context);
    }

    public ReviewItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.reviewlist_item, this, true);

        textTitle = (TextView) findViewById(R.id.textTitle);
        textContent = (TextView) findViewById(R.id.textContent);
    }

    public void setTitle(String title) {
        textTitle.setText(title);
    }

    public void setContent(String content) {
        textContent.setText(content);
    }
}

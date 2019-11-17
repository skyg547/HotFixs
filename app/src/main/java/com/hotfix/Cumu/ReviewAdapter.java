package com.hotfix.Cumu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hotfix.Login.ReviewDTO;
import com.bufsrepair.R;

import java.util.ArrayList;

public class ReviewAdapter extends BaseAdapter {

    private ArrayList<ReviewDTO> reviewDTOS = null;

//    public ReviewAdapter(ArrayList<ReviewDTO> reviewDTO) {
//        reviewDTOS = reviewDTO;
//        nListCnt = reviewDTOS.size();
//    }

    @Override
    public int getCount() {
        return reviewDTOS.size();
    }

    @Override
    public ReviewDTO getItem(int i) {
        return reviewDTOS.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();

        if(view == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.reviewlist_item, viewGroup, false);
        }

        TextView textTitle = (TextView) view.findViewById(R.id.textTitle);
        TextView textContent = (TextView) view.findViewById(R.id.textContent);

        ReviewDTO reviewDTO = getItem(i);

        textTitle.setText(reviewDTO.getReviewSubject());
        textContent.setText(reviewDTO.getReviewContent());

        return view;
    }
    public void addItem(ArrayList<com.hotfix.Cumu.ReviewDTO> oData) {

        reviewDTOS = new ArrayList<>();

        for (int i = 0; i<oData.size(); i++) {
            ReviewDTO reviewDTO = new ReviewDTO();

            reviewDTO.setReviewSubject(oData.get(i).getReviewSubject());
            reviewDTO.setReviewContent(oData.get(i).getReviewContent());
            reviewDTO.setReviewUserId(oData.get(i).getReviewUserId());
            reviewDTO.setSeq(oData.get(i).getSeq());
            reviewDTO.setReviewComment(oData.get(i).getReviewComment());
            reviewDTO.setReviewLike(oData.get(i).getReviewLike());
            reviewDTO.setReviewInto(oData.get(i).getReviewInto());


            reviewDTOS.add(reviewDTO);
        }
    }
}
package com.hotfix.Cumu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bufsrepair.R;

import java.util.ArrayList;

    public class RepleAdapter extends BaseAdapter {

        private ArrayList<RepleDTO> repleDTOS = null;

        @Override
        public int getCount() {
            return repleDTOS.size();
        }

        @Override
        public RepleDTO getItem(int i) {
            return repleDTOS.get(i);
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
                view = inflater.inflate(R.layout.replelist_item, viewGroup, false);
            }

            TextView textUser = (TextView) view.findViewById(R.id.repleUser);
            TextView textComment = (TextView) view.findViewById(R.id.repleComment);

            RepleDTO repleDTO = getItem(i);

            textUser.setText(repleDTO.getUserid());
            textComment.setText(repleDTO.getComment());

            return view;
        }

        public void addItem(ArrayList<RepleDTO> oData) {
            repleDTOS = new ArrayList<>();

            for (int i = 0; i<oData.size(); i++) {
                RepleDTO repleDTO = new com.hotfix.Cumu.RepleDTO();

                repleDTO.setNumber(oData.get(i).getNumber());
                repleDTO.setSeq(oData.get(i).getSeq());
                repleDTO.setUserid(oData.get(i).getUserid());
                repleDTO.setComment(oData.get(i).getComment());

                repleDTOS.add(repleDTO);
            }
        }
    }


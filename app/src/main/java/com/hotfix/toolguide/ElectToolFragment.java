package com.hotfix.toolguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bufsrepair.R;

import java.util.ArrayList;

public class ElectToolFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.tool_fragment, container, false);

        String[] list_menu = { "전동 드릴","햄머 드릴" };
        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        toolAdapter adapter = new toolAdapter();

        adapter.addItem(new com.hotfix.toolguide.ToolItem(list_menu[0],R.drawable.icon_drill3));
        adapter.addItem(new com.hotfix.toolguide.ToolItem(list_menu[1],R.drawable.icon_drill2));


        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                  Intent intent = new Intent(getActivity(), com.hotfix.toolguide.ToolExplain.class);
                  intent.putExtra("name", "electtool");
                  intent.putExtra("index", i);
                  startActivity(intent);


            }
        });





        return rootView;
    }



    public class toolAdapter extends BaseAdapter {

        ArrayList<com.hotfix.toolguide.ToolItem> items = new ArrayList<com.hotfix.toolguide.ToolItem>();

        public void addItem(com.hotfix.toolguide.ToolItem item){
            items.add(item);

        }
        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            com.hotfix.toolguide.ToolItemView views = new com.hotfix.toolguide.ToolItemView(getContext());

            com.hotfix.toolguide.ToolItem item = items.get(i);

            views.setImageView(item.getResId());
            views.setName(item.getName());

            return views;
        }
    }
}


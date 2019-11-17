package com.hotfix.Start;

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

import com.hotfix.Menual.MovieActivity;
import com.bufsrepair.R;
import com.hotfix.toolguide.ToolItem;
import com.hotfix.toolguide.ToolItemView;

import java.util.ArrayList;

public class SinkFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sink_fragment, container, false);

        String[] list_menu = { "싱크대 경첩(DIY)", "싱크대 배수관(DIY)", "싱크대(페인트-밑작업)", "싱크대(페인트-칠하기)", "싱크대(페인트-프라이머)" };

        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        toolAdapter adapter = new toolAdapter();

        adapter.addItem(new ToolItem(list_menu[0],R.drawable.sink));
        adapter.addItem(new ToolItem(list_menu[1],R.drawable.sink));
        adapter.addItem(new ToolItem(list_menu[2],R.drawable.sink));
        adapter.addItem(new ToolItem(list_menu[3],R.drawable.sink));
        adapter.addItem(new ToolItem(list_menu[4],R.drawable.sink));

        listView.setAdapter(adapter);

/*        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                list_menu
        );

        listView.setAdapter(listViewAdapter);*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getActivity(), MovieActivity.class);
                intent.putExtra("name", "Sink");
                intent.putExtra("index", i);
                startActivity(intent);


            }
        });

        return rootView;
    }

    public class toolAdapter extends BaseAdapter {

        ArrayList<ToolItem> items = new ArrayList<ToolItem>();



        public void addItem(ToolItem item){
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

            ToolItemView views = new ToolItemView(getContext());

            ToolItem item = items.get(i);

            views.setImageView(item.getResId());
            views.setName(item.getName());

            return views;
        }
    }
}

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

public class ToolFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.tool_fragment, container, false);

        String[] list_menu = { "망치","드라이버", "먹줄","펜치", "바이스 플라이어","압착 플라이어","롱로즈 플라이어","니퍼",};

        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        toolAdapter adapter = new toolAdapter();

        adapter.addItem(new com.hotfix.toolguide.ToolItem(list_menu[0],R.drawable.icon_hammer));
        adapter.addItem(new com.hotfix.toolguide.ToolItem(list_menu[1],R.drawable.icon_driver));
        adapter.addItem(new com.hotfix.toolguide.ToolItem(list_menu[2],R.drawable.chalkline));
        adapter.addItem(new com.hotfix.toolguide.ToolItem(list_menu[3],R.drawable.pench));
        adapter.addItem(new com.hotfix.toolguide.ToolItem(list_menu[4],R.drawable.viceplier));
        adapter.addItem(new com.hotfix.toolguide.ToolItem(list_menu[5],R.drawable.pressurepliers));
        adapter.addItem(new com.hotfix.toolguide.ToolItem(list_menu[6],R.drawable.icon_lonplier));
        adapter.addItem(new com.hotfix.toolguide.ToolItem(list_menu[7],R.drawable.nipper));

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

                Intent intent = new Intent(getActivity(), ToolExplain.class);
                intent.putExtra("name", "tool");
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

package com.hotfix.Menual;

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

import com.hotfix.Menual.ManualItem;
import com.hotfix.Menual.ManualTextActivity;
import com.hotfix.Menual.ManualTextView;
import com.bufsrepair.R;

import java.util.ArrayList;

public class HomeRepairManualFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_repair_manual_fragment, container, false);

        String[] list_menu = { "집을 오래 잘 쓰기 위해 적정한 수선, 교체가 필요합니다",
                "다양한 주택 유형", "노후주택이 처한 곤란",
                "집수리에도 순서가 있어요",
                "집의 문제를 진단해요",
                "견적서 작성 방법",
                "계약시 유의사항",
                "공정표를 만듭니다",
                "누수진단과 방수 공사",
                "에너지 진단과 단열공사",
                "창호공사",
                "집 사용설명서" };

        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        ManualAdapter adapter = new ManualAdapter();

        adapter.addItem(new ManualItem(list_menu[0]));
        adapter.addItem(new ManualItem(list_menu[1]));
        adapter.addItem(new ManualItem(list_menu[2]));
        adapter.addItem(new ManualItem(list_menu[3]));
        adapter.addItem(new ManualItem(list_menu[4]));
        adapter.addItem(new ManualItem(list_menu[5]));
        adapter.addItem(new ManualItem(list_menu[6]));
        adapter.addItem(new ManualItem(list_menu[7]));
        adapter.addItem(new ManualItem(list_menu[8]));
        adapter.addItem(new ManualItem(list_menu[9]));
        adapter.addItem(new ManualItem(list_menu[10]));
        adapter.addItem(new ManualItem(list_menu[11]));

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

                Intent intent = new Intent(getActivity(), ManualTextActivity.class);
                intent.putExtra("index", i);
                startActivity(intent);
            }
        });

        return rootView;
    }

    public class ManualAdapter extends BaseAdapter {

        ArrayList<ManualItem> items = new ArrayList<ManualItem>();



        public void addItem(ManualItem item){
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

            ManualTextView views = new ManualTextView(getContext());

            ManualItem item = items.get(i);

            views.setName(item.getName());

            return views;
        }
    }
}

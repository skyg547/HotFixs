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

import com.bufsrepair.R;
import com.hotfix.toolguide.ToolItem;
import com.hotfix.toolguide.ToolItemView;

import java.util.ArrayList;

public class AllVideosFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_repair_manual_fragment, container, false);

        String[] list_menu = { "알기쉬운 집수리(개요)", "집수리 준비과정(개요)", "집사용설명서(개요)", "전기와 에너지(전기)",
                "신재생에너지(전기)", "태양광발전설치와 전기(전기)", "구조일반사항(구조)", "균열원인(구조)", "균열사례 및 보수(구조)",
                "방수의 종류와 특징(방수)", "방수의 시공방법(방수)", "방수 사례와 해결(방수)", "단열은 꼭 해야 하는가?(단열)",
                "열의 이동경로 전도 대류 복사(단열)", "열전도율 열관류율 열저항(단열)", "단열재 종류별 특징(단열)", "목재의 종류와 특성(목공)",
                "자재구입과 안전수칙(목공)", "목재의 가공(목공)", "페인트 종류(페인트)", "페인트 공구(페인트)", "실린더 문손잡이 교체(DIY)",
                "레버 문손잡이 교체(DIY)", "싱크대 경첩(DIY)", "싱크대 배수관(DIY)", "세면대 배관(DIY)", "세면대 수전(DIY)", "세면대 교체(DIY)",
                "모니터 받침대(DIY)", "벽선반(DIY)", "화장실 변기(DIY)", "화장실 샤워 수전(DIY)", "화장실 타일(DIY)", "작은 타일 & 큰 타일(타일)",
                "줄눈(타일)", "바닥타일(타일)", "목재 실습:집성목으로 상자 만들기(목공)", "싱크대(페인트-밑작업)", "타일(페인트-밑작업)",
                "방문(페인트-밑작업)", "샷시(페인트-밑작업)", "현관문(페인트-밑작업)", "싱크대(페인트-프라이머)", "타일(페인트-프라이머)",
                "방문(페인트-프라이머)",  "샷시(페인트-프라이머)", "현관문(페인트-프라이머)", "싱크대(페인트-칠하기)", "타일(페인트-칠하기)",
                "방문(페인트-칠하기)", "샷시(페인트-칠하기)", "현관문(페인트-칠하기)", "천장(페인트-칠하기)", "벽지_한 색(1color)_하늘색(페인트-칠하기)",
                "벽지_두 색(2color)_분홍색+흰색(페인트-칠하기)", "수공구 소개 및 사용법(공구-절단공구)", "절단공구 소개 및 사용법-원형톱,직쏘우\n(공구-절단공구)",
                "각도절단기 소개 및 실습(공구-절단공구)", "테이블쏘우 소개 및 실습(공구-절단공구)", "컷쏘우 소개 및 사용법(공구-절단공구)",
                "그라인더 소개 및 사용법(공구-그라인더)", "그라인더 결합품 소개(공구-그라인더)", "그라인더 결합(공구-그라인더)", "그라인더 실습(공구-그라인더)",
                "에어공구 규격 별 종류와 소개(공구-에어공구)", "대형에어공구 소개(공구-에어공구)", "석고보드 이용한 에어공구 사용(공구-에어공구)",
                "전동공구 및 결합 비트 소개(공구-체결공구)", "전동 공구 실습(공구-체결공구)", "전동드릴 석고보드 앵커결합(공구-체결공구)",
                "햄머드릴 콘크리드 앵커 설치(공구-체결공구)" };

        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        toolAdapter adapter = new toolAdapter();

        adapter.addItem(new ToolItem(list_menu[0],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[1],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[2],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[3],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[4],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[5],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[6],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[7],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[8],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[9],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[10],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[11],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[12],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[13],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[14],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[15],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[16],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[17],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[18],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[19],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[20],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[21],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[22],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[23],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[24],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[25],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[26],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[27],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[28],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[29],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[30],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[31],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[32],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[33],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[34],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[35],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[36],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[37],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[38],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[39],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[40],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[41],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[42],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[43],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[44],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[45],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[46],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[47],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[48],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[49],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[50],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[51],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[52],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[53],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[54],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[55],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[56],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[57],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[58],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[59],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[60],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[61],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[62],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[63],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[64],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[65],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[66],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[67],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[68],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[69],R.drawable.play));
        adapter.addItem(new ToolItem(list_menu[70],R.drawable.play));

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

                Intent intent = new Intent(getActivity(), com.hotfix.Menual.MovieActivity.class);
                intent.putExtra("name", "동영상");
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

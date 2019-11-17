package com.hotfix.toolmaps;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.hotfix.Back.BackPressCloseHandler;
import com.hotfix.Cumu.ReviewList;
import com.hotfix.Menual.ManualMainActivity;
import com.bufsrepair.R;
import com.hotfix.Start.StartActivity;
import com.hotfix.toolguide.ToolList;
import com.hotfix.toolguide.ToolList;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;
import com.naver.maps.map.widget.ZoomControlView;

public class ToolMaps extends FragmentActivity implements OnMapReadyCallback {

    private BackPressCloseHandler backPressCloseHandler;

    private static  final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private  FusedLocationSource locationSource;

    int i= 0;
    int p1 = 0;

    String[] toolLib = {"우리동네공구상점","사직골 공구함 운영","생활공구 무료대여","창신제1동공구무상대여"," 소공동 공구도서관"," 회현동 공구도서관"," 명동 공구도서관"," 필동 공구도서관"," 장충동 공구도서관"," 광희동 공구도서관"," 을지로동 공구도서관"," 신당동 공구도서관"," 다산동 공구도서관"," 약수동 공구도서관"," 청구동 공구도서관",
            " 신당5동 공구도서관"," 동화동 공구도서관"," 황학동 공구도서관"," 중림동 공구도서관"," 한강로동 생활공구 대여소"," 원효2동"," 사근동 공구도서관"," 행당1동 공구도서관"," 금호2-3가동 공구도서관"," 용답동 공구도서관"," 금강아미움아파트 공구도서관"," 금호삼성아파트 공구도서관"," 어울림더리버 공구도서관"," 청구강변아파트 공구도서관",
            " 행당한진아파트 공구도서관"," 성수한강한신아파트 공구도서관"," 송정동 공구도서관(7월 중순 개소예정)"," 생활공구대여소(자양4동)"," 생활공구대여소(중곡4동)"," 생활공구대여사업", "래미안아름숲 물품공유센터", "장안1동 공구도서관", "청량리동 공유도서관", "망우생활지원센터 공구도서관"," 면목생활지원센터 공구도서관"," 아리랑정보도서관",
            " 성북정보도서관", "삼양동주민센터 공구도서관", "미아동주민센터 공구도서관", "송중동주민센터 공구도서관", "송천동주민센터 공구도서관", "삼각산동주민센터 공구도서관", "번1동주민센터 공구도서관", "번2동주민센터 공구도서관", "번3동주민센터 공구도서관", "수유1동주민센터 공구도서관", "수유2동주민센터 공구도서관", "수유3동주민센터 공구도서관",
            "우이동주민센터 공구도서관", "인수동주민센터 공구도서관", "강북문화정보도서관 공구도서관", "청소년문화정보도서관 공구도서관", "솔샘문화정보도서관 공구도서관", "송중문화정보도서관 공구도서관", "창동 삼성아파트 공유카페 휴", "쌍문1동 응답하라, 공구야", "쌍문2동 노해마을 공구대여점", "방학1동 우리동네 0.9.대여점", "방학2동 공구도서관",
            "창3동 공구대여점나눔공방", "상록아파트관리사무소", "월계2동주민센터 공구를빌려드립니다.", "함께 쓰는 마을 공구 (월계3동 주민센터)", "공릉2동주민센터 공구도서관"," 하계2동주민센터 공구도서관"," 상계5동주민센터 공구도서관"," 상계6,7동주민센터 공구도서관"," 녹번동 주민센터"," 불광1동 주민센터"," 불광2동 주민센터"," 갈현1동 주민센터"," 갈현2동 주민센터",
            " 구산동 주민센터"," 대조동 주민센터"," 응암1동 주민센터"," 응암2동 주민센터"," 응암3동 주민센터"," 역촌동 주민센터"," 신사1동 주민센터"," 신사2동 주민센터"," 증산동 주민센터"," 수색동 주민센터"," 진관동 주민센터"," 은평공유센터","태영으뜸아파트 공구도서관", "삼개나루 공유센터"," 서강GS아파트공구도서관"," 상암월드컵파크11단지공구함"," 목동복지관 공구 공유도서관",
            " 신월복지관 공구 공유도서관"," 한빛복지관 공구 공유도서관"," 신정복지관 공구 공유도서관"," 신목복지관 공구 공유도서관"," 한숲대림아파트 공구도서관"," 화곡본동 공구도서관"," 화곡4동 생활공구대여"," 우장산동공구도서관"," 신도림동공구도서관"," 구로1동공구도서관"," 고척2동공구도서관"," 가리봉동공구도서관"," 우리동네 공구도서관(당산1동)", "우리동네 공구도서관(문래동)",
            " 우리동네 공구도서관(신길3동)"," 우리동네 공구도서관(여의동)"," 우리동네 공구도서관(신길4동)"," 우리동네 공구도서관(신길6동)"," 우리동네 공구도서관(대림3동)"," 삼환공구마루"," 중앙동 공구도서관"," 신사동 공구도서관"," 행운동 공구도서관"," 낙성대동 공구도서관"," 신림동 공구도서관"," 청룡동 공구도서관"," 인헌동 공구도서관"," 서림동 공구도서관"," 난향동 공구도서관",
            " 방배반딧불센터 공구은행"," 양재반딧불센터 공구은행"," 반포반딧불센터 공구은행"," 풍납씨티극동 공구나눔터"," 풍납극동 공구도서관"," 현대리버빌2차 공구나눔터"," 오금현대 공구백화점"," 가락금호 공구나눔방"," 가락쌍용1차 공동공구함"," 문정현대 공동공구함"," 송파파인타운1단지 공구도서관"," 송파파인타운4단지 공구나눔터"," 송파인타운12단지 공동공구함"," 트리지움 공구도서관",
            " 잠실파크리오 공구나눔터"," 문정래미안"," 한강극동"," 거여1단지"," 강일동 공구도서관"," 상일동 공구도서관"," 명일1동 공구도서관"," 명일2동 공구도서관"," 고덕1동 공구도서관"," 고덕2동 공구도서관"," 암사1동 공구도서관"," 암사2동 공구도서관"," 암사3동 공구도서관"," 천호1동 공구도서관"," 천호2동 공구도서관"," 천호3동 공구도서관"," 성내1동 공구도서관"," 성내2동 공구도서관",
            " 성내3동 공구도서관"," 길동 공구도서관"," 둔촌1동공구도서관"," 둔촌2동공구도서관"," 강일리버파크10단지 공구도서관", "고덕현대 공구도서관", "프라이어팰리스 공구도서관", "고덕리엔파크1단지 공구도서관", "강일리버파크8단지 공구도서관", "천호중앙하이츠 공구도서관", "성안마을청구아파트"," 고덕상록아파트"," 둔촌동동아아파트","코오롱2차"
    };

    String[] toolLibadr ={
            "서울시 종로구 자하문로 92(궁정동), 청운효자동주민센터" ,"서울시 종로구 사직로9길 1(사직동), 사직동주민센터" ,"서울시 종로구 송월길 154(행촌동), 교남동주민센터" ,"서울시 종로구 지봉로8-6(창신동), 창신제1동주민센터" ,"서울시 중구 남대문로1길 31-5" ,"서울시 중구 퇴계로8길 46"
            ,"서울시 중구 퇴계로20길 3" ,"서울시 중구 퇴계로36길 42" ,"서울시 중구 장충단로8길 22" ,"서울시 중구 퇴계로 303-9" ,"서울시 중구 충무로9길 19" ,"서울시 중구 다산로 211"
            ,"서울시 중구 동호로15길 50" ,"서울시 중구 다산로 92" ,"서울시 중구 청구로3길 55" ,"서울시 중구 다산로44길 85" ,"서울시 중구 다산로36길 100" ,"서울시 중구 난계로11길 52" ,"서울시 중구 서소문로6길 16"
            ,"서울시 용산구 한강대로 38길 28" ,"서울시 용산구 효창원로8길 3" ,"서울시 성동구 사근동길 45-8" ,"서울시 성동구 고산자로10길 18" ,"서울시 성동구 무수막18길 1" ,"서울시 성동구 용답중앙23길 20 용답동 주민센터 2층" ,"서울시 성동구 아차산로9길 34" ,"서울시 성동구 독서당로 343" ,"서울시 성동구 독서당로40길 37"
            ,"서울시 성동구 둘레15길 7" ,"서울시 성동구 행당로 82" ,"서울시 성동구 성수2로 3" ,"서울시 성동구 동일로43길 13" ,"서울시 광진구 뚝섬로26길 58 자양4동 주민센터" ,"서울시 광진구 긴고랑로 131 중곡4동 주민센터"
            ,"서울시 광진구 긴고랑로12길 49, 중곡1동주민센터" ,"서울시 동대문구 전농로16길 51" ,"서울시 동대문구 한천로18길 52"
            ,"서울 동대문구 왕산로 43다길 5" ,"서울시 중랑구 망우로77길 12" ,"서울시 중랑구 사가정로 51길 48" ,"서울시 성북구 아리랑로 82" ,"서울시 성북구 화랑로18자길 13" ,"서울시 강북구 삼양로 268" ,"서울시 강북구 솔매로49길 14" ,"서울시 강북구 오패산로 162"
            ,"서울시 강북구 솔샘로 284" ,"서울시 강북구 삼양로19길 102" ,"서울시 강북구 덕릉로41길 74" ,"서울시 강북구 한천로 897" ,"서울시 강북구 한천로105길 21" ,"서울시 강북구 삼양로 299"
            ,"서울시 강북구 한천로 1117" ,"서울시 강북구 노해로 36" ,"서울시 강북구 삼양로139길 49" ,"서울시 강북구 인수봉로 255" ,"서울시 강북구 오현로 145" ,"서울시 강북구 삼양로54길 68" ,"서울시 강북구 솔샘로 177" ,"서울시 강북구 도봉로20나길 6" ,"서울시 도봉구 노해로 66길 21"
            ,"서울시 도봉구 노해로 147 쌍문1동주민센터" ,"서울시 도봉구 방학로3길 117 쌍문2동주민센터" ,"서울시 도봉구 방학로2길 27 방학1동주민센터" ,"서울시 도봉구 시루봉로 226 방학2동주민센터" ,"서울시 도봉구 덕릉로62길 89 창3동 주민센터" ,"서울시 노원구 동일로 227길 26  관리사무소" ,"서울시 노원구 초안산로5길 28" ,"서울시 노원구 마들로 57 월계3동주민센터 내" ,"서울시 노원구 노원로1길 68"
            ,"서울시 노원구 공릉로55길 88" ,"서울시 노원구 한글비석로 434" ,"서울시 노원구 노원로 429" ,"서울시 은평구 녹번동 87-1" ,"서울시 은평구 진흥로15길 10" ,"서울시 은평구 연서로41길 16" ,"서울시 은평구 갈현로 301" ,"서울시 은평구 연서로27길 31-6" ,"서울시 은평구 갈현로17길 10"
            ,"서울시 은평구 연서로20길 24-3" ,"서울시 은평구 백련산로 179" ,"서울시 은평구 백련산로 100" ,"서울시 은평구 불광천길 410-17" ,"서울시 은평구 연서로 59" ,"서울시 은평구 은평로길 2" ,"서울시 은평구 증산로15길 47"
            ,"서울시 은평구 증산서길 89" ,"서울시 은평구 은평터널로 27" ,"서울시 은평구 진관2로 31" ,"서울시 은평구 연서로34길 11"
            ,"서울시 서대문구 세검정로3길 63" ,"서울시 마포구 토정로 31길 31" ,"서울시 마포구 창전로26, 관리사무실(신정동,서강GS아파트)" ,"서울 마포구 월드컵북로502-37관리사무실(상암월드컵파크11단지아파트)" ,"서울시 양천구 목동중앙북로8길 104 (3층 복도)" ,"서울시 양천구 중앙로29길 61 (1층 로비)" ,"서울시 양천구 신월로11길 16 (3층 도서관)" ,"서울시 양천구 신정중앙로 80(신정동) (2층 창고 내부)"
            ,"서울시 양천구 신목로 5 (1층 로비)" ,"서울시 강서구 방화대로 259" ,"서울시 강서구 초록마을로5길 29" ,"서울시 강서구 곰달래로57가길 26"
            ,"서울시 강서구 우현로34" ,"서울시 구로구 신도림로40" ,"서울시 구로구 구일로4길 57" ,"서울시 구로구 중앙로15길 22" ,"서울시 구로구 남부순환로 105길 198" ,"서울시 영등포구 양산로23길 11" ,"서울시 영등포구 문래로28길15" ,"서울시 영등포구 신길로41라길 13-8"
            ,"서울시 영등포구 국제금융로124" ,"서울시 영등포구 신길로42길1" ,"서울시 영등포구 대방천로 169" ,"서울시 영등포구 대림로197"
            ,"서울시 영등포구 여의대방로43라길 9" ,"서울시 관악구 양녕로6다길 7" ,"서울시 관악구 조원로142" ,"서울시 관악구 행운1길 43" ,"서울시 관악구 낙성대로4가길 5" ,"서울시 관악구 신림동길 14" ,"서울시 관악구 쑥고개로 44"
            ,"서울시 관악구 남부순환로 246가길 20" ,"서울시 관악구 신림로29길 6" ,"서울시 관악구 난곡로 67" ,"서울시 서초구 효령로14다길 21" ,"서울시 서초구 강남대로12길 44" ,"서울시 서초구 신반포로42길 12" ,"서울시 송파구 한가람로 478" ,"서울시 송파구 올림픽로45길 11"
            ,"서울시 송파구 풍성로24길 42" ,"서울시 송파구 오금로35길 17" ,"서울시 송파대로32길 15" ,"서울시 송파구 동남로 193" ,"서울시 송파구 송이로34길 26" ,"서울시 송파구 충민로 188" ,"서울시 송파구 새말로 12길 16"
            ,"서울시 송파구 송파대로8길42" ,"서울시 송파구 잠실로 62" ,"서울시 송파구 올림픽로 435" ,"서울시 송파구 문정로 83" ,"서울시 송파구 토성로 38-6" ,"서울시 송파구 양산로8길 8" ,"서울시 강동구 아리수로93길 9-14" ,"서울시 강동구 고덕로80길 111" ,"서울시 강동구 양재대로138길 137" ,"서울시 강동구 상암로 260" ,"서울시 강동구 양재대로156길 123"
            ,"서울시 강동구 아리수로78길 43-12" ,"서울시 고덕로24길 49" ,"서울시 상암로3길 28" ,"서울시 강동구 고덕로 137" ,"서울시 강동구 구천면로42길 59" ,"서울시 강동구 올림픽로698"
            ,"민호빌딩 2층 (천호2동주민센터)" ,"서울시 강동구 진황도로23길 7" ,"서울 강동구 성내로 13" ,"서울시 강동구 풍성로37가길 62" ,"서울시 강동대로53길 76" ,"서울시 강동구 명일로 229-1" ,"서울시 강동구 양재대로 84길 31" ,"서울시 강동구 천호대로186길 7" ,"서울시 강동구 고덕로 97길 20" ,"서울시 강동구 동남로 71길 37" ,"서울시 강동구 고덕로 130" ,"서울시 강동구 상일로 152"
            ,"서울시 강동구 아리수로 94길 72" ,"서울시 강동구 구천면로 41길 79" ,"서울시 강동구 풍성로114-1" ,"서울시 강동구 고덕로61길34" ,"서울시 강동구 동남로49길 60-5" ,"서울시 강동구 올림픽로 572"
    };
    String[] toolLibCall = { "2148-5003","2148-5033","2148-5183","2148-5399","3396-6503","3396-6551","3396-6569","3396-6594","3396-6623", "3396-6652","3396-6682","3396-6713","3396-6743","3396-6775","3396-6808","3396-6835", "3396-6863","3396-6893","3396-6923","2199-8573","2199-8507","2286-7276","2286-7284", "2286-7364","2286-7523","3409-2087","6451-1500","2292-0850","467-1340","2281-4437","498-4571","2286-7504",
            "450-1822","450-1072","450-1012","2127-4045","2171-6283","2171-6363","2094-0452","2094-0452","2241-2616","2241-2616","901-2014","901-2024","901-2232","901-2043","901-2057","901-2064","901-2072","901-2084","901-2092","901-2102","901-2112","901-2123","901-2373","901-3102","901-3141","901-3151","901-3161","2091-2472","2091-5522","2091-5528","2091-5604","2091-5629","2091-5729","933-5056","2116-2448",
            "2116-2470","2116-2545","2116-2601","2116-2842","2116-2871","351-5004","351-5047","351-5063","351-5095","351-5124","351-5152","351-5183","351-5214","351-5244","351-5273","351-5304","351-5335","351-5361","351-5408","351-5424","351-5468","351-6824","330-8794","3153-6616","02-712-6853","02-302-5930","2651-2332","2605-8728","2690-8762","2603-1792","2643-7222","2600-6824","2600-7454","2600-7604","2600-7732",
            "860-3359","860-3359","860-3359","860-3359","2670-1105","2670-1178","2670-1268","2670-1083","2670-1287","2670-1330","2670-1426","2670-3657","879-5581","879-4535","879-4362","879-4415","879-4505","879-4388","879-4448","879-4750","879-4653","522-7500","2155-7922","516-7887","473-4664","473-6614","477-9989","402-2104","407-3582","3402-1037","408-7634","431-0070","449-2431","400-1894","425-7157","3431-7411~4",
            "402-4023","472-7159","431-8354","3425-7403","3425-7434","3425-7464","3425-7493","3425-7523","3425-7553","3425-7638","3425-7613","3425-7645","3425-7673","3425-7704","3425-7735","3425-7775","3425-7793","3425-7824","3425-7852","3425-7883","3425-7918","427-6675","481-6061","3427-4569","426-2085","429-1147","483-3045","3425-6004","3425-6004","3425-6004","3425-6004",
    };

    double[] wido = {37.584165, 37.576181, 37.571893, 37.570948, 37.562571, 37.557418, 37.560074, 37.560264, 37.561867, 37.564505, 37.566888,
            37.562107, 37.554519, 37.5524, 37.557071, 37.565207, 37.559435, 37.567592, 37.560055, 37.529349, 37.534547, 37.56143, 37.558511,
            37.552369, 37.564319, 37.546872, 37.549261, 37.542501, 37.535484, 37.556015, 37.549179, 37.554457, 37.534121, 37.559053, 37.560528, 37.580619, 37.567807,
            37.586323, 37.601398, 37.582963, 37.599879, 37.604927, 37.627249, 37.626939, 37.616079, 37.618256, 37.61674, 37.637854, 37.632203, 37.625817,
            37.630017, 37.644627, 37.638675, 37.647955, 37.641433, 37.624937, 37.623021, 37.620516, 37.618288, 37.648914, 37.648943, 37.649673,
            37.664425, 37.668216, 37.638101, 37.668642, 37.632522, 37.620983, 37.621271, 37.631989, 37.662962, 37.65485, 37.602555, 37.610347, 37.626433, 37.623647,
            37.618528, 37.611733, 37.614195, 37.600667, 37.594481, 37.592198, 37.604374, 37.598098, 37.590344, 37.58433, 37.584179, 37.634982, 37.621567,
            37.593855, 37.542284, 37.544225, 37.587611, 37.544151, 37.518832, 37.519112, 37.526449, 37.517282, 37.563609, 37.544037, 37.534607, 37.548227,
            37.50769, 37.493024, 37.506674, 37.484109, 37.525023, 37.517461, 37.507277, 37.517667, 37.508429, 37.49935, 37.498313, 37.507944, 37.484143,
            37.485408, 37.480648, 37.476265, 37.487363, 37.479009, 37.475095, 37.475015, 37.461498, 37.478231, 37.470578, 37.509732, 37.539622, 37.526603, 37.532024,
            37.50586, 37.49617, 37.495541, 37.485761, 37.486784, 37.481783, 37.478434, 37.509871, 37.521232, 37.490604, 37.52929, 37.490916, 37.565059, 37.549504,
            37.546339, 37.556274, 37.5605, 37.552367, 37.551752, 37.554975, 37.545013, 37.543449, 37.539958, 37.530368, 37.532366, 37.526062, 37.539262,
            37.523445, 37.533322, 37.560007, 37.550397, 37.553579, 37.561041, 37.561555, 37.547353, 37.53166, 37.556609, 37.533262, 37.532369
    };

    double [] geungdo = { 126.970598, 126.968804, 126.961971, 127.016393, 126.976974, 126.979332, 126.985802, 126.995598,
            127.00774, 127.005055, 126.991379, 127.014462, 127.008334, 127.008984, 127.014607, 127.021884, 127.019566, 127.021333, 126.966782, 126.968987,
            126.951432, 127.045879, 127.036073, 127.02269, 127.055595, 127.059617, 127.027234, 127.018121, 127.054857, 127.02916,
            127.05547, 127.069516, 127.066242, 127.089455, 127.079978, 127.060961, 127.066408, 127.04724, 127.106373, 127.088056, 127.013905,
            127.05053, 127.018274, 127.026905, 127.033813, 127.023816, 127.017489, 127.028808, 127.038847, 127.046599, 127.0175, 127.019876,
            127.023095, 127.011952, 127.010583, 127.036114, 127.021599, 127.012388, 127.029955, 127.048478, 127.027923, 127.02773, 127.040669,
            127.035044, 127.042965, 127.053381, 127.050775, 127.069226, 127.083388, 127.067873, 127.069327, 127.066936, 126.929588, 126.932108,
            126.927303, 126.916704, 126.91576, 126.910363, 126.920836, 126.926716, 126.92314, 126.91572, 126.915206, 126.911835, 126.908494,
            126.907052, 126.89751, 126.920906, 126.927709, 126.94689, 126.943002, 126.931109, 126.881259,
            126.866333, 126.847351, 126.835538, 126.860499, 126.876551, 126.815751, 126.847666, 126.860587, 126.841816, 126.880705, 126.875754,
            126.858577, 126.884084, 126.897371, 126.899788, 126.907744, 126.934544, 126.911265, 126.909878, 126.898055, 126.919309, 126.94976,
            126.918102, 126.957037, 126.958408, 126.927113, 126.941655, 126.96521, 126.934947, 126.918785, 126.991573, 127.041211,
            127.018473, 127.118148, 127.116651, 127.11675, 127.126328, 127.116381, 127.12812, 127.130313, 127.134691, 127.12968, 127.132098,
            127.089582, 127.109427, 127.130337, 127.112864, 127.144547, 127.173779, 127.165511, 127.145713, 127.151348, 127.14722, 127.164334,
            127.135704, 127.12725, 127.140834, 127.136792, 127.125432, 127.129791, 127.122399, 127.129528, 127.132884, 127.146145, 127.136635, 127.141978, 127.180671,
            127.15359, 127.139356, 127.171661, 127.176984, 127.130097, 127.124635, 127.154787, 127.145584, 127.121724
    };

    Intent intent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) { switch (item.getItemId()) {
            case R.id.navigation_start:
                intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.navigation_menual:
                intent = new Intent(getApplicationContext(), ManualMainActivity.class);
                intent.putExtra("name", "집수리 매뉴얼");
                startActivity(intent);
                finish();
                return true;
            case R.id.navigation_cumu1:
                intent = new Intent(getApplicationContext(), ReviewList.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.navigation_toolmaps:
                return true;
            case R.id.navigation_toolguide:
                intent = new Intent(getApplicationContext(), ToolList.class);
                startActivity(intent);
                finish();
                return true;
        }
            return false;
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        backPressCloseHandler = new BackPressCloseHandler(this);
        chkGpsService();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_toolmaps);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);

        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map);

        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }

        mapFragment.getMapAsync((OnMapReadyCallback) this);




    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(locationSource.onRequestPermissionsResult(requestCode,permissions,grantResults)){

            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onMapReady(@NonNull final NaverMap naverMap) {
        naverMap.setMapType(NaverMap.MapType.Basic);
        naverMap.setSymbolScale(1.5f);
        naverMap.setLocationSource(locationSource);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Face);



        ZoomControlView zoomControlView = new ZoomControlView(this);
        zoomControlView.setMap(naverMap);

        UiSettings uiSettings = naverMap.getUiSettings();


        uiSettings.setAllGesturesEnabled(true);
        uiSettings.setLocationButtonEnabled(true);

        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setZoomControlEnabled(true);
        uiSettings.setLogoClickEnabled(true);
        uiSettings.setCompassEnabled(true);

        final LatLng[] latlng1 = new LatLng[170];
        final InfoWindow[] infowindow1 = new InfoWindow[170];
        final Marker[] marker1 = new Marker[170];

        for (i=0; i<168; i++) {
            latlng1[i] = new LatLng(wido[i], geungdo[i]);
        }


        for ( i =0; i<168; i++){

            marker1[i] = new Marker();
            marker1[i].setPosition(latlng1[i]);
            marker1[i].setMap(naverMap);
            marker1[i].setSubCaptionText(toolLib[i]);
            marker1[i].setSubCaptionColor(Color.rgb(14,209,69));
            marker1[i].setSubCaptionHaloColor(Color.WHITE);
            marker1[i].setIcon(OverlayImage.fromResource(R.drawable.icon_tool));
            marker1[i].setIconTintColor(Color.rgb(14,209,69));
            marker1[i].setWidth(150);
            marker1[i].setHeight(150);

            infowindow1[i] = new InfoWindow();

            infowindow1[i].setAdapter(new InfoWindow.DefaultTextAdapter(this) {
                @NonNull
                @Override
                public CharSequence getText(@NonNull InfoWindow infoWindow) {
                    String s = "운영시간 : 평일 09 ~ 18시\n"+ "전화 : 02-"+toolLibCall[i]+"\n"+"주소 : " + toolLibadr[i];
                    return s;
                }
            });

        }

        Overlay.OnClickListener listener = new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {

                Marker marker = (Marker)overlay;


                for(i = 0; i<168; i++) {
                    if(marker == marker1[i]){
                        if (marker.getInfoWindow() == null) {
                         // 현재 마커에 정보 창이 열려있지 않을 경우 엶
                            infowindow1[i].open(marker);

                         } else {
                         // 이미 현재 마커에 정보 창이 열려있을 경우 닫음
                          infowindow1[i].close();
                         }
                    }
                }
                return true;

            }
        };

        for (i=0; i < 168; i++) {
            marker1[i].setOnClickListener(listener);
        }

        NaverMap.OnMapClickListener listenermap = new NaverMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull PointF pointF, @NonNull LatLng latLng) {

                for(i = 0; i < 168; i++ ){
                    infowindow1[i].close();
                }
            }
        };

        naverMap.setOnMapClickListener(listenermap);

    }

    @Override public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }

    private boolean chkGpsService() {

        String gps = android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

        Log.d(gps, "aaaa");

        if (!(gps.matches(".*gps.*") && gps.matches(".*network.*"))) {

            // GPS OFF 일때 Dialog 표시
            AlertDialog.Builder gsDialog = new AlertDialog.Builder(this);
            gsDialog.setTitle("위치 서비스 설정");
            gsDialog.setMessage("GPS 사용을 체크하셔야 위치 서비스가 가능합니다.\n위치 서비스 기능을 설정하시겠습니까?");
            gsDialog.setPositiveButton("허용", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // GPS설정 화면으로 이동
                    Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    startActivity(intent);
                }
            })
                    .setNegativeButton("거절", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    }).create().show();
            return false;

        } else {
            return true;
        }
    }


}
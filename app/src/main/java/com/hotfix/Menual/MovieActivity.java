package com.hotfix.Menual;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.hotfix.Cumu.ReviewList;
import com.hotfix.Menual.ManualMainActivity;
import com.bufsrepair.R;
import com.hotfix.Start.StartActivity;
import com.hotfix.toolguide.ToolList;
import com.hotfix.toolmaps.ToolMaps;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MovieActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController controller;
    Intent intent;
    String name;
    TextView textView;
    TextView textView2;
    int pandan = 0;
    BottomNavigationView nav_view;
    ScrollView scrollView;
    LinearLayout linearLayout;
    int index;


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
                finish();
                startActivity(intent);
                return true;
            case R.id.navigation_cumu1:
                intent = new Intent(getApplicationContext(), ReviewList.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.navigation_toolmaps:
                intent = new Intent(getApplicationContext(), ToolMaps.class);
                startActivity(intent);
                finish();
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

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_movie);
        ActionBar abar = getSupportActionBar();
        abar.hide();

        videoView = (VideoView) findViewById(R.id.videoView);

        nav_view = (BottomNavigationView) findViewById(R.id.nav_view);
        textView = (TextView) findViewById(R.id.textView);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        textView2 = (TextView) findViewById(R.id.textView2);

        intent = getIntent();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_menual);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        name = intent.getExtras().getString("name");
        index = intent.getExtras().getInt("index");

        index++;


        if (name.equals("Sink")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e24.mp4"));
                textView2.setText("싱크대 경첩(DIY)");
                textView.setText("- 건들지 말아야 할 것 \n" +
                        "\n" +
                        "# 몸체에 고정된 나사 \n" +
                        "\n" +
                        "# 문에 고정된 나사 \n" +
                        "\n" +
                        "- 돌출된 나사와 몸체 제일 안쪽의 나사를 조절해 '문의 균형'을 맞출 수 있습니다. \n" +
                        "\n" +
                        "- 시계 반대방향으로 드릴을 작동하면 나사가 바깥으로 나옵니다. \n" +
                        "\n" +
                        "- 좌우측 문을 열었다 닫았다 확인하며 조금씩 조정합니다. \n" +
                        "\n" +
                        "- 스토퍼와 경첩이 맞물리는 부분을 이용해 간편하게 결합할 수 있습니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e25.mp4"));
                textView2.setText("싱크대 배수관(DIY)");
                textView.setText("- 싱크대 옆 구멍은 물이 일정부분 차올랐을때 넘치는 물을 방지하는 구멍입니다. \n" +
                        "\n" +
                        "- 피스는 싱크대 옆 배수구멍 뒷 편에 위치합니다. \n" +
                        "\n" +
                        "- 싱크대 배수관을 구매시, 호스와 배관 등이 함께 구성됩니다. \n" +
                        "\n" +
                        "- 배관이 꼬이지 않도록 설치합니다. \n" +
                        "\n" +
                        "- 냄새 차단 배수 트랩도 따로 구매가 가능합니다. \n" +
                        "\n" +
                        "- 싱크대와 트랩이 밀착하지 않으면 누수의 위험이 있습니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 3) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e38.mp4"));
                textView2.setText("싱크대(페인트-밑작업)");
                textView.setText("<싱크대 옆면 밑작업> \n" +
                        "\n" +
                        "- 물티슈로 주변을 깨끗이 닦아냅니다. \n" +
                        "\n" +
                        "- 페인트 작업에서는 이물질이 없어야 깨끗하게 작업을 완료할 수 있습니다. \n" +
                        "\n" +
                        "- 바닥에 페인트가 묻지 않도록 커버링으로 꼼꼼하게 막아줍니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<퍼티 작업> \n" +
                        "\n" +
                        "- 퍼티로 구멍을 매꿉니다. \n" +
                        "\n" +
                        "- 구멍을 매꾸고 남은 퍼티는 다시 제거해줍니다. \n" +
                        "\n" +
                        "- 퍼티는 2회 반복합니다. \n" +
                        "\n" +
                        "- 퍼티가 건조된 후 면 전체를 사포로 정리합니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<상부장 밑작업> \n" +
                        "\n" +
                        "- 손잡이 부분을 먼저 제거합니다. \n" +
                        "\n" +
                        "- 페인트칠을 하기 어려운 매끈한 시트지면을 사포로 거칠게 만들어줍니다. \n" +
                        "\n" +
                        "- 페인트칠이 묻지 말아야 할 곳은 마스킹테이프를 붙여줍니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 4) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e48.mp4"));
                textView2.setText("싱크대(페인트-칠하기)");
                textView.setText("- 싱크대는 가구의 일종이므로 가구전용 페인트를 준비합니다. \n" +
                        "\n" +
                        "- 예시로 보여지는 상부장은 평평한 디자인이므로 붓을 사용할 필요가 없습니다. \n" +
                        "\n" +
                        "- 가구의 경우 페인트가 뭉칠 경우 더욱 티가 날 수 있습니다. \n" +
                        "\n" +
                        "- 롤러를 칠할때는 제일 위부터 칠하는 것이 아니라 중간 지점부터 칠합니다. \n" +
                        "\n" +
                        "- 건조한 후에 이물질이 붙었다면 사포로 정리 후 2~3차례 같은 작업을 반복합니다. \n" +
                        "\n" +
                        "- 틈새의 경우 페인트가 흘러내릴것을 주의하면서 칠합니다.  \n" +
                        "\n" +
                        " ");
            } else if (index == 5) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e43.mp4"));
                textView2.setText("싱크대(페인트-프라이머)");
                textView.setText("- 프라이머 작업을 위해 싱크대를 분리해 넓은 공간에서 작업합니다. \n" +
                        "\n" +
                        "- 면을 칠할 때는 위부터 칠하지 않고 중간 지점부터 칠합니다. \n" +
                        "\n" +
                        "- 롤러는 한 쪽으로 치우치거나 기울지 않도록 평평하게 칠합니다. \n" +
                        "\n" +
                        "- 좁은 면은 4인치 롤러를 사용합니다. \n" +
                        "\n" +
                        "- 칠이 다른면으로 넘어간 경우 롤러에 칠이 최대한 없는 상태로 펴바릅니다. \n" +
                        "\n" +
                        " ");
            }
        } else if (name.equals("Basin")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e28.mp4"));
                textView2.setText("세면대 교체(DIY)");
                textView.setText("- 세면대 높이는 허리를 숙였을 때 알맞은 높이에 맞춰주세요 \n" +
                        "\n" +
                        "- 세면대의 앵커가 들어가는 구멍높이를 체크해주세요 \n" +
                        "\n" +
                        "- 수평대를 이용해 수평을 확인한 뒤 구멍을 타공해주세요 \n" +
                        "\n" +
                        "- 벽에 설치할 때는 양쪽 앵커에 세면대를 건 후 밑에서 작업합니다 ");
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e26.mp4"));
                textView2.setText("세면대 배관(DIY)");
                textView.setText("- 고무가 제대로 결합되지 않으면 물이 샐 수 있습니다. \n" +
                        "\n" +
                        "- 주름관 형태는 플라스틱형 제품이므로 내구성이 비교적 약할 수 있습니다. \n" +
                        "\n" +
                        "- 배관에서는 고무 마킹이 매우 중요하므로 읿어버리면 안돼요! \n" +
                        "\n" +
                        "- 고무 마킹은 항상 배관에 꼭 맞도록 결합합니다. \n" +
                        "\n" +
                        "- 배관의 위치와 잘 맞출 수 있도록 미리 결합된 트랩의 방향을 설정합니다. \n" +
                        "\n" +
                        "- 물이 S자 안에 반 정도 차있으면서 냄새가 역류하지 않도록 합니다. \n" +
                        "\n" +
                        "- 주름관 형태의 트랩은 꼬아서 설치할 경우 물의 무게 때문에 주저 앉을 수 있습니다. \n" +
                        "\n" +
                        "- 최근 주름관 트랩은 내부에 냄새가 역류되는 현상을 막는 제품도 있습니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 3) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e27.mp4"));
                textView2.setText("세면대 수전(DIY)");
                textView.setText("- 작업시에 물이 나오지 않도록 밸브를 잠그고 진행합니다. \n" +
                        "\n" +
                        "- 가정 내 수도밸브를 아예 잠그셔도 무방합니다. \n" +
                        "\n" +
                        "- 호스를 뺄 때는 꼭 하나씩 순서대로 진행합니다. \n" +
                        "\n" +
                        "- 휴지 등을 붙여 누수 여부를 확인할 수 있습니다. ");
            }
        } else if (name.equals("Bathroom")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e31.mp4"));
                textView2.setText("화장실 변기(DIY)");
                textView.setText("- 변기를 들 수 있어야 설치 가능합니다 \n" +
                        "\n" +
                        "- 물높이 조절계를 적당한 높이에 위치 시켜주세요 \n" +
                        "\n" +
                        "- 손잡이 끈을 여유있게 잡아 주세요 \n" +
                        "\n" +
                        "- 수전을 열고 접합 부분에 물이 새는 지 확인해주세요 \n" +
                        "\n" +
                        "- 볼탑에 물이 차고 잘 내려가는지 확인합니다 \n" +
                        "\n" +
                        "- 앉았을 때 흔들리지 않는지 확인해주세요 \n" +
                        "\n" +
                        " ");
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e32.mp4"));
                textView2.setText("화장실 샤워 수전(DIY)");
                textView.setText("- 수전 몸체만 바꿀 시 밸브만 잠그고 작업하면 됩니다 \n" +
                        "\n" +
                        "- 수도관 교체 시에는 수도계량기를 잠가주세요 \n" +
                        "\n" +
                        "- 아파트는 보통 수도계량기가 복도에 위치해 있습니다 \n" +
                        "\n" +
                        "- 단독주택의 경우 수도계량기함을 찾아 잠가줍니다 \n" +
                        "\n" +
                        "- 밸브를 자주 조작하면 고무마킹이 닳아 없어질 수 있습니다 \n" +
                        "\n" +
                        "- 밸브가 너무 많이 열려 물이 샐 수 있으니 주의하세요 \n" +
                        "\n" +
                        "- 조절대 결합 후 수도계량기를 열어 물이 새지 않는지 확인해주세요 \n" +
                        "\n" +
                        "- 앞쪽 나사를 돌려 물이 새는지 확인하고 마지막으로 수압을 결정하세요 \n" +
                        "\n" +
                        " ");
            } else if (index == 3) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e33.mp4"));
                textView2.setText("화장실 타일(DIY)");
                textView.setText("- 줄눈보수용 실리콘을 타일 사이사이에 채워줍니다 \n" +
                        "\n" +
                        "- 줄눈칼을 이용해 줄눈을 제거해줍니다 \n" +
                        "\n" +
                        "- 줄눈 실리콘은 보수용입니다 \n" +
                        "\n" +
                        " ");
            }
        } else if (name.equals("Tile")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e34.mp4"));
                textView2.setText("작은 타일 & 큰 타일(타일)");
                textView.setText("<타일 자나무 그리기> \n" +
                        "\n" +
                        "1. 자나무 위에, 시공할 작은 타일을 3mm 간격으로 연달아 놓고 사인펜으로 금을 긋는다. \n" +
                        "\n" +
                        "2. 자신에게 제일 왼쪽, 첫칸부터 번호를 매긴다. \n" +
                        "\n" +
                        "3. 간격이 일정하게 3mm인지 확인한다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<작은 타일 시공> \n" +
                        "\n" +
                        "1. 앞서 그려놓은 자나무를 벽에 대고 빗금을 친다. \n" +
                        "\n" +
                        "2. 예시된 벽의 넓이를 고려하여 중간에 빗금을 한번 더 그어준다. \n" +
                        "\n" +
                        "3. 왼쪽 끝과 중간 지점에 그려놓은 빗금을 따라 수평을 유의하며 줄을 긋는다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<타일 붙이는 본드 작업> \n" +
                        "\n" +
                        "1. 본드가 한곳에만 많이 발라지지 않도록 고르게 벽에 바른다. \n" +
                        "\n" +
                        "2. 빗질을 하듯 곧게 아랫 방향으로 펴바른다. \n" +
                        "\n" +
                        "3. 타일을 모서리부터 조금씩 간격을 두고 채워나간다. \n" +
                        "\n" +
                        "4. 아랫줄은 반으로 자른 타일부터 시작하여 개성에 따라 모양을 낸다. \n" +
                        "\n" +
                        "5. 다음 줄도 마찬가지로, 벽면에 그어진 먹줄을 따라 작은 타일을 연달아 붙인다. \n" +
                        "\n" +
                        "6. 본드를 모든 벽면에 한번에 바르지 않고 위부터 아랫방향으로 조금씩 진행한다. \n" +
                        "\n" +
                        "7. 흐트러진 타일은 본드가 굳기 전, 조금씩 움직여 제자리에 맞춰준다. \n" +
                        "\n" +
                        "8. 타일과 타일 사이는 3mm로 띄워준다. \n" +
                        "\n" +
                        " ");
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e35.mp4"));
                textView2.setText("줄눈(타일)");
                textView.setText("<줄눈넣기> \n" +
                        "\n" +
                        "1. 백색 줄눈형 시멘트를 작업통에 붇습니다. \n" +
                        "\n" +
                        "2. 밀가루 반죽하듯 일정량의 물과 함께 반죽해줍니다. \n" +
                        "\n" +
                        "3. 반죽한 시멘트를 작업 팔레트에 사용량 만큼 덜어줍니다. \n" +
                        "\n" +
                        "4. 줄눈을 따라 스펀지 흙손으로 페인트를 발라 넣어줍니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "- 시공 후 바로 닦지 않으면 굳음현상이 생길 수 있습니다. \n" +
                        "\n" +
                        "- 타일로 굳은 곳을 벗기면 기스를 방지할 수 있습니다. \n" +
                        "\n" +
                        "- 스폰지를 자주, 물기 없이 짜주고 닦아내야 합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 3) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e36.mp4"));
                textView2.setText("바닥타일(타일)");
                textView.setText("<바닥타일> \n" +
                        "\n" +
                        "1. 배수구 위치를 먼저 바닥에 잡아줍니다. \n" +
                        "\n" +
                        "2. 타일 본드를 바닥에 군데군데 덩어리로 떨어뜨립니다. \n" +
                        "\n" +
                        "3. 본드를 넓게 펴바릅니다. \n" +
                        "\n" +
                        "4. 바닥 끝은 길이에 맞게 타일을 절단해 붙입니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 4) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e39.mp4"));
                textView2.setText("타일(페인트-밑작업)");
                textView.setText("- 타일에 붙어있는 스티커, 걸이 등을 모두 제거합니다. \n" +
                        "\n" +
                        "- 글루건으로 붙은 경우 스크래퍼 & 헤라 등을 이용합니다. \n" +
                        "\n" +
                        "- 오래된 스티커 자국은 헤어드라이기 등으로 열을 가하면 한결 수월합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 5) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e44.mp4"));
                textView2.setText("타일(페인트-프라이머)");
                textView.setText("- 모서리, 경계선 등부터 붓으로 먼저 프라이머를 칠합니다. \n" +
                        "\n" +
                        "- 상부장과 접하는 빈 틈은 붓을 이용하여 칠합니다. \n" +
                        "\n" +
                        "- 타일 경계면도 붓을 이용해서 매꾸어 줍니다. \n" +
                        "\n" +
                        "- 콘센트 주변도 롤러 작업이 힘들기 때문에 붓으로 작업합니다. \n" +
                        "\n" +
                        "- 실리콘 제거가 힘들시에는 프라이머로 실리콘 부분도 함께 칠합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 6) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e49.mp4"));
                textView2.setText("타일(페인트-칠하기)");
                textView.setText("- 롤러가 접하지 못하는 부위부터 붓 작업을 시작합니다. \n" +
                        "\n" +
                        "- 상부장 안쪽은 붓을 이용해서 페인트를 발라줍니다. \n" +
                        "\n" +
                        " ");
            }
        } else if (name.equals("Paint")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e40.mp4"));
                textView2.setText("페인트 종류(페인트)");
                textView.setText("- 유성 페인트의 장점은 저렴한 가격과 접착력 커버력 등이 우수하다는 장점이 있지만 유기용제인 '신나'로 희석하기 때문에 냄새 뿐만 아니라 유기화학물질이 함유되어 일반인이, 특히 실내에 작업하기에는 수월하지 않습니다 \n" +
                        "\n" +
                        "- 요즘은 건강까지 생각하는 친환경 인테리어가 대세입니다 \n" +
                        "\n" +
                        "- 100% 천연원료를 사용한 천연 페인트 및 유해물질 배출을 최대한 차단한 친환경 페인트 제품도 존재합니다 \n" +
                        "\n" +
                        "- 우리나라는 친환경페인트를 VOC(휘발성 유기화합물) 함유량이 리터랑 35g 이하면 친환경이라고 인증하고 있습니다 \n" +
                        "\n" +
                        "- 도장면에 적합한 페인트를 사용하는 것이 하자없는 올바른 페인트 작업입니다 \n" +
                        "\n" +
                        "- 프라이머는 커버력/접착력/발색력을 높여주는 역할을 하고 페인트를 떨어지지 않게 잡아주는 일종의 본드, 하도로 이해할 수 있습니다 \n" +
                        "\n" +
                        "- 다목적/철제갈바용/타일용 등으로 다양하게 있으니 목적에 맞게 선택 작업 후 작업을 진행하면 되겠습니다 \n" +
                        "\n" +
                        "- 수성페인트 작업 전 프라이머 작업을 진행하지 않으면 쉽게 벗겨지고 까지므로 꼭 페인팅 시공 전 작업을 진행하여야 합니다 \n" +
                        "\n" +
                        "- 단, 벽지 페인트 작업 시 종이 벽지는 페인트를 흡수하므로 프라이머를 생략해도 되지만 실크 벽지는 PVC재질에 코팅되어 있으므로 프라이머 사용을 권장합니다 \n" +
                        "\n" +
                        "- 붓이나 롤러, 스프레이를 이용해서 1~2회 바르고 충분히 건조하면 되겠습니다 \n" +
                        "\n" +
                        "- 날씨와 습도 등에 따라 페인트 주변 온도가 높으면 건조가 빨라집니다 \n" +
                        "\n" +
                        "- 프라이머 건조 후, 붓이나 롤러, 스프레이를 이용해서 시공하면 되겠습니다 \n" +
                        "\n" +
                        " ");
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e50.mp4"));
                textView2.setText("페인트 공구(페인트)");
                textView.setText("- 페인트 작업은, 붓과 롤러를 사용한 수제작업과 기계를 이용한 스프레이 작업이 있습니다 \n" +
                        "\n" +
                        "- 페인트 도구는 크게 작업도구, 밑작업도구, 기타도구로 나뉘는데요 \n" +
                        "\n" +
                        "- 수성 페인트를 사용할 때에는 수성 붓을 사용하시면 됩니다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<붓> \n" +
                        "\n" +
                        "- 평붓은 페인트 시공시 편리하게 사용할 수 있는 붓이며 앵글붓은 모서리나 섬세한 작업시에 사용하기 좋은 붓입니다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<롤러> \n" +
                        "\n" +
                        "- 롤러에서 가장 중요한 것은 털의 길이입니다 \n" +
                        "\n" +
                        "- 도장면 상태가 좋은 가구나 문 등은 단모를 사용합니다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<커버링테이프> \n" +
                        "\n" +
                        "- 넓은 면적에 칠이 묻지 않도록 해줍니다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<스크래퍼> \n" +
                        "\n" +
                        "- 도장면에 사포로 제거가 어려운 오염물이나 거친 면을 긁어내는데 사용합니다 \n" +
                        "\n" +
                        "- 작업이 끝난 롤러의 칠을 떼어낼 때 사용합니다 \n" +
                        "\n" +
                        " ");
            }
        } else if (name.equals("Wallpaper")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e54.mp4"));
                textView2.setText("벽지_한 색(1color)_하늘색(페인트-칠하기)");
                textView.setText("- 페인트 초보자는 ㅡ자로 작업하셔도 무방합니다. \n" +
                        "\n" +
                        "- 벽의 반을 칠한 후 나머지 밑부분을 칠합니다. \n" +
                        "\n" +
                        "- 윗부분 아랫부분을 칠한 후 균일하게 제일 윗쪽과 아랫쪽까지 롤러로 펴발라줍니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e55.mp4"));
                textView2.setText("벽지_두 색(2color)_분홍색+흰색(페인트-칠하기)");
                textView.setText("- 페인트가 묻으면 안되는 곳에 마스킹테이프를 붙입니다. \n" +
                        "\n" +
                        "- 마스킹테이프 경계 위에 기존 칠(흰 칠)을 한 번 더 작업합니다. \n" +
                        "\n" +
                        "- 2회 롤러 작업 이후에 마스킹테이프를 제거하면 흡수 없이 깔끔하게 완성물이 나올 수 있습니다. \n" +
                        "\n" +
                        " ");
            }
        } else if (name.equals("Shelf")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e30.mp4"));
                textView2.setText("벽선반(DIY)");
                textView.setText("- 벽 선반을 석고보드 위에 설치했을 때는 무거운 물건은 NO! \n" +
                        "\n" +
                        "- 석고보드에 설치한 선반에는 가벼운 소품으로 장식해보세요~! \n" +
                        "\n" +
                        " ");
            }
        } else if (name.equals("Monitor")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e29.mp4"));
                textView2.setText("모니터 받침대(DIY)");
                textView.setText("- 원하는 규격의 목재는 온라인에서도 구매할 수 있습니다 \n" +
                        "\n" +
                        "- 톱은 내려갈 때보다 톱을 당길 때 힘을 줍니다 \n" +
                        "\n" +
                        "- 톱밥을 정리해가며 톱질을 진행합니다 \n" +
                        "\n" +
                        "- 톱질은 끝으로 갈 수록 천천히 하도록 합니다 \n" +
                        "\n" +
                        "- 거친 면은 사포로 마무리 해줍니다 \n" +
                        "\n" +
                        " ");
            }
        } else if (name.equals("Doorknob")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e22.mp4"));
                textView2.setText("실린더 문손잡이 교체(DIY)");
                textView.setText("1. 실린더 해체 \n" +
                        "\n" +
                        "- 뒷쪽을 잡고 손잡이를 해체해주세요 \n" +
                        "\n" +
                        "2. 실린더 설치 \n" +
                        "\n" +
                        "- 위쪽부터 살살~ 고정 후 아래쪽을 단단하게! \n" +
                        "\n" +
                        "- 구멍을 맞춘 후 피스를 고정 \n" +
                        "\n" +
                        "- 손잡이의 구멍 위치를 확인 후 맞춰줍니다 ");
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e23.mp4"));
                textView2.setText("레버 문손잡이 교체(DIY)");
                textView.setText("1. 먼저 모든 피스를 분해합니다. \n" +
                        "\n" +
                        "2. 레버손잡이 교체 \n" +
                        "\n" +
                        "- 레버의 잠금장치 방향을 유의해주세요. \n" +
                        "\n" +
                        " ");
            }
        } else if (name.equals("동영상")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e01.mp4"));
                textView2.setText("알기쉬운 집수리(개요)");
                textView.setText("<교체주기> \n" +
                        "\n" +
                        "- 보일러 : 10년 \n" +
                        "\n" +
                        "- 수도꼭지, 실리콘 : 2~3년 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<단독주택> \n" +
                        "\n" +
                        "- 에너지효율이 가장 나쁨, \n" +
                        "\n" +
                        "- 증축으로 인한 배수 부족과 누수 \n" +
                        "\n" +
                        "- 곰팡이 문제 많음 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<다가구 주택> \n" +
                        "\n" +
                        "- 3개층 이하, 연면적 660㎡ 이하 \n" +
                        "\n" +
                        "- 소유를 구분하거나 분양할 수 없음 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<다세대 주택> \n" +
                        "\n" +
                        "- 4개층 이하, 연면적 660㎡ 이하 \n" +
                        "\n" +
                        "- 구분등기 가능 \n" +
                        "\n" +
                        "- 소유자, 입주자간 수리비 부담 조정이 어려움 \n" +
                        "\n" +
                        "- 장기수선충당금 적립 등 필요 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<노후주택의 곤란> \n" +
                        "\n" +
                        "● 누수 \n" +
                        "\n" +
                        "- 지반침하로 인한 균열 \n" +
                        "\n" +
                        "- 열화로 인한 벽체균열 \n" +
                        "\n" +
                        "- 창호주위 실링 노후 \n" +
                        "\n" +
                        "- 평지붕방수 노후 \n" +
                        "\n" +
                        "- 시공불량으로 인한 방추층 파단 \n" +
                        "\n" +
                        "- 배수드레인, 파라펫 방수턱 시공불량 \n" +
                        "\n" +
                        "- 차양이 없어 빗물이 들이칠 때 \n" +
                        "\n" +
                        "● 점검사항 \n" +
                        "\n" +
                        "- 배수드레인(물이 빠지는 구멍)을 봄철에 막히지 않도록 깨끗이 청소합니다. 비온 후 30분 이내에 집주변에서 모두 빠져나가도록 하는 것이 중요합니다. \n" +
                        "\n" +
                        "● 추위 \n" +
                        "\n" +
                        "- 높은 난방비에 비해 추운 집 \n" +
                        "\n" +
                        "- 단열재 부족 \n" +
                        "\n" +
                        "- 열교 많음 \n" +
                        "\n" +
                        "- 창호 성능 나쁨 \n" +
                        "\n" +
                        "- 시공 불량 \n" +
                        "\n" +
                        "- 전깃줄이 많이 지나가는 기존의 창문 : 에어컨 실외기, 전화선이 통과 \n" +
                        "\n" +
                        "● 곰팡이 \n" +
                        "\n" +
                        "- 누수, 단열부족으로 인한 결로 \n" +
                        "\n" +
                        "- 땅에서 올라오는 습기(반지하) \n" +
                        "\n" +
                        "- 간헐난방, 내단열 \n" +
                        "\n" +
                        "- 잘못된 가구배치 \n" +
                        "\n" +
                        "- 천식, 두통, 피로, 메스꺼움, 기침, 구통 등 유발 \n" +
                        "\n" +
                        "● 곰팡이 해결 \n" +
                        "\n" +
                        "- 반지하집은 여름철에 곰팡이가 많이 생기며 해결이 가장 어려움 \n" +
                        "\n" +
                        "- 도배나 장판을 하지 않는 것이 좋다 \n" +
                        "\n" +
                        "- 바닥 습기가 날아가지 않는 장판 대신에 습기가 날아갈 수 있는 타일이나 다른 재료를 추천! \n" +
                        "\n" +
                        "● 곰팡이 해결 \n" +
                        "\n" +
                        "- 발코니 곰팡이는 열이 지나다니는 통로(열교) 중 단열재가 부족한 부분에 생김 \n" +
                        "\n" +
                        "- 결로방지 페인트로 해결 가능 ");
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e02.mp4"));
                textView2.setText("집수리 준비과정(개요)");
                textView.setText("1. 집수리계획 \n" +
                        "\n" +
                        "- 스스로 조사, 진단, 공사범위, 일정계획 \n" +
                        "\n" +
                        "2. 조사, 진단 \n" +
                        "\n" +
                        "- 집수리 전문가에게 의뢰(진단, 설계, 시공) \n" +
                        "\n" +
                        "3. 계획설계, 개산견적 \n" +
                        "\n" +
                        "- 비용, 설계, 공사 협의 \n" +
                        "\n" +
                        "4. 계약 \n" +
                        "\n" +
                        "- 계약 주체, 지불조건, 용역범위, 기간 결정 \n" +
                        "\n" +
                        "5. 비용 확정 \n" +
                        "\n" +
                        "- 상세 견적 \n" +
                        "\n" +
                        "6. 시공 계획 \n" +
                        "\n" +
                        "- 공정표 작성 \n" +
                        "\n" +
                        "7. 시공 \n" +
                        "\n" +
                        "8. 완료 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<견적서 만들기> \n" +
                        "\n" +
                        "● 개산견적 \n" +
                        "\n" +
                        "- 공사비 가늠, 어림짓기, 계획 초기 자재, 마감, 디자인 결정되기 전 상세견적 만들기 전, 계약전 \n" +
                        "\n" +
                        "● 상세견적 \n" +
                        "\n" +
                        "- 수량, 중량, 면적, 품 등을 공정별로 상세하게 산출 후 단위가격으로 셈 \n" +
                        "\n" +
                        "● 재료비 \n" +
                        "\n" +
                        "- 직접재료비 : 공사목적물의 실체를 형성하기 위한 물품의 가치 \n" +
                        "\n" +
                        "- 간접재료비 : 공사에 보조적으로 소비되는 물품의 가치 \n" +
                        "\n" +
                        "● 노무비 \n" +
                        "\n" +
                        "- 직접노무비 : 직접 작업 종사자, 노무자 \n" +
                        "\n" +
                        "- 간접노무비 : 현장에서 보조 작업을 하는 노무자, 종업원, 현장감독자 \n" +
                        "\n" +
                        "● 경비 \n" +
                        "\n" +
                        "- 공사 시공을 위해 소요되는 재료비, 노무비를 제외한 원가(관리비, 보혐료, 전력비, 운반비 등) \n" +
                        "\n" +
                        "● 일반관리비 \n" +
                        "\n" +
                        "- 기업유지를 위한 관리활동부분에서 발생하는 비용 \n" +
                        "\n" +
                        "● 이윤 \n" +
                        "\n" +
                        "- 영업이익(노무비+경비+일반관리비) x 이윤율(15%이하) \n" +
                        "\n" +
                        "● 수량산출서 \n" +
                        "\n" +
                        "- 공정별 소요되는 필요량 계산 \n" +
                        "\n" +
                        "● 내역서 \n" +
                        "\n" +
                        "- 공정별 재료의 규격, 수량, 단위, 재료비, 노무비 재상 \n" +
                        "\n" +
                        "● 공사원가계산서 \n" +
                        "\n" +
                        "- 직접공사비, 일반관리비, 이윤, 부가세 계상 \n" +
                        "\n" +
                        "● 갑지 \n" +
                        "\n" +
                        "- 공사예정총액, 견적조건, 유효기간, 제출일, 제출처, 제출자 ");
            } else if (index == 3) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e03.mp4"));
                textView2.setText("집사용설명서(개요)");
                textView.setText("<우리집 사용설명서> \n" +
                        "\n" +
                        "1. 토지대장, 건축물 대장, 지적도 등 부동산 표시에 관한 서류 \n" +
                        "\n" +
                        "2. 집현황 조사표 \n" +
                        "\n" +
                        "3. 실측도면(리모델링할 때는 도면, 시방서, 내역서 등 설계도서) \n" +
                        "\n" +
                        "4. 시공 중 부위별 사진 기록표(철근배근, 콘크리트, 설비 배선, 배관에 관한 사진) \n" +
                        "\n" +
                        "5. 사용자재 목록과 설명, 보증서 \n" +
                        "\n" +
                        "6. 사용 중 열화, 파손, 파손의 진행에 관한 사진 기록 \n" +
                        "\n" +
                        "7. 사용 중 변경내용 기록 \n" +
                        "\n" +
                        "8. 사용 중 변경 요소 사진 기록 \n" +
                        "\n" +
                        "9. 운용비용에 관한 자료(가스, 전기 요금) \n" +
                        "\n" +
                        "10. 기타 필요하다고 판단되는 기록과 자료 \n" +
                        "\n" +
                        " ");
            } else if (index == 4) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e04.mp4"));
                textView2.setText("전기와 에너지(전기)");
                textView.setText("● LED 등이 깜빡이는 현상이 생긴다면? \n" +
                        "\n" +
                        "- 가정전압이 210V 밑으로 떨어져서 생기는 현상 \n" +
                        "\n" +
                        "● 전압의 차이가 클수록 전류가 잘 흐릅니다. \n" +
                        "\n" +
                        "● 전선의 굵기가 굵을수록 전류가 많이 흐를 수 있습니다. \n" +
                        "\n" +
                        "● 차단기가 떨어지는 이유 \n" +
                        "\n" +
                        "- 전기선로가 얇아 흐르는 전기의 양이 적은데 쓰고자 하는 전기의 양이 많아 전기선에 부하가 걸리기 때문입니다. \n" +
                        "\n" +
                        "● 차단기 떨어짐 방지 \n" +
                        "\n" +
                        "- 벽 콘센트를 골고루 사용 \n" +
                        "\n" +
                        "- 굵은 선의 멀티 콘센트를 사용 \n" +
                        "\n" +
                        "- 개별 스위치가 달린 멀티콘센트 사용 \n" +
                        "\n" +
                        " ");
            } else if (index == 5) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e05.mp4"));
                textView2.setText("신재생에너지(전기)");
                textView.setText("<신재생에너지> \n" +
                        "\n" +
                        "- 화석 에너지의 고갈문제와 환경문제를 해결 할 수 있는 가장 깨끗한 에너지로 평가 \n" +
                        "\n" +
                        "- 2015년 프랑스 기후협약 체결 등으로 그 중요성이 재인식 되고 있음 \n" +
                        "\n" +
                        "- 차세대 가장 중요한 성장동력 중 하나 \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "<태양열> \n" +
                        "\n" +
                        "- 태양의 열에너지를 이용하여 물을 끓여 온수를 이용하거나 전기에너지를 생산한다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "<태양광> \n" +
                        "\n" +
                        "- 태양의 빛에너지를 이용하여 전기에너지로 변환시켜주는 발전형태를 뜻한다. \n" +
                        "\n" +
                        "- 태양광은 탄소배출양을 줄이는 친환경에너지이기 때문에 전세계적으로 채택하는 움직임이 있다. \n" +
                        "\n" +
                        "- 태양광은 날씨와 관계없이 발전을 한다. 다만, 구름이나 비 등의 태양빛에 영향을 주는 상황, 즉, 일조량에 따라 발전양의 차이가 난다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "<가정용 미니 태양광> \n" +
                        "\n" +
                        "- 가정에서 가전제품처럼 사용 : 계량기에 연결하는 방식이 아니라 가정의 콘센트에 연결하여 쓰는 방식입니다. \n" +
                        "\n" +
                        "- 콘센트 연결방식 : 베란다 난간에 태양광전지판을 설치하고 전기선 하나만 실내로 들어가서 가까이에 있는 콘센트에 꼽는다. \n" +
                        "\n" +
                        " ");
            } else if (index == 6) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e06.mp4"));
                textView2.setText("태양광발전설치와 전기(전기)");
                textView.setText("<미니태양광 옥상형> \n" +
                        "\n" +
                        "- 설치 각도는 30도 \n" +
                        "\n" +
                        "- 재질은 대부분 알루미늄 \n" +
                        "\n" +
                        "- 초속 50m의 풍속시험을 통과한 제품 \n" +
                        "\n" +
                        "- 한곳마다 1톤을 견디는 힘을 가지고 있음 \n" +
                        "\n" +
                        "- 상단과 하단은 25도 ");
            } else if (index == 7) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e07.mp4"));
                textView2.setText("구조일반사항(구조)");
                textView.setText("<건축이란> \n" +
                        "\n" +
                        "- 건축행위는 건물을 구현하고 유지하기 위한 모든 행위를 뜻함 \n" +
                        "\n" +
                        "ex) 기획, 설계, 시공, 유지관리, 리모델링 등의 총칭 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<건축구조> \n" +
                        "\n" +
                        "- 사람 몸의 뼈와 근육과 같은 골격에 해당 \n" +
                        "\n" +
                        "- 건축물의 뼈대를 구성하는 방식, 골조 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<콘크리트> \n" +
                        "\n" +
                        "- 시멘트 + 물 + 골재 \n" +
                        "\n" +
                        "- 압축에 강하고 인장에 약하다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<철근 콘크리트> \n" +
                        "\n" +
                        "- 철큰 + 콘크리트 \n" +
                        "\n" +
                        "- 압축에 약하고 인장에 강하다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<구조물에서의 힘의 흐름> \n" +
                        "\n" +
                        "- 구조 부재에서 힘을 받고 이를 다른 부재로 전달하는 과정 \n" +
                        "\n" +
                        "- 건물 전체가 외력을 받아서 지반으로 흘려 보내기까지의 과정 \n" +
                        "\n" +
                        "- 외력(하중)에 대해 원활한 흐름이 가능한 형태를 갖춰야 함 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<하중의 종류> \n" +
                        "\n" +
                        "● 고정하중 \n" +
                        "\n" +
                        "- 구조체의 하중을 포함하여 영구히 설치될 구성 요소의 무게 \n" +
                        "\n" +
                        "- 고정하중은 구조체 자체의 무게와 구조물에 영구적으로 작용하는 하중의 합으로, 시간의 흐름에 따라 변하지 않은 특성을 갖는다. \n" +
                        "\n" +
                        "- 골조, 마감재 칸막이, 조적 벽체, 고정기계 설비시설 및 기타 설비시스템의 무게를 포함한다. \n" +
                        "\n" +
                        "● 활하중 \n" +
                        "\n" +
                        "- 건물의 용도와 관련된 하중 \n" +
                        "\n" +
                        "- 건물의 입주자나 사용자와 함께 가구와 사무집기 등 건물의 점유에 관련된 하중 \n" +
                        "\n" +
                        "- 가변성이 크고 시간과 위치에 따라 변화(예측 불가능) \n" +
                        "\n" +
                        "- 바닥용 활하중 : 등분포 하중으로 정의하며 실바닥 용도에 따른 발생(거실, 안방, 발코니, 화장실, 복도 등) \n" +
                        "\n" +
                        "- 지붕 활하중 : 건설하중이나 물, 눈, 설비, 얼음 등에 의해 발생 \n" +
                        "\n" +
                        "● 풍하중 \n" +
                        "\n" +
                        "- 바람에 의한 건축물의 구조적 반응 \n" +
                        "\n" +
                        "- 바람에 의해서 주로 건물의 높이와 형태에 따라서 달라짐 \n" +
                        "\n" +
                        "- 일반적으로 수평하중으로 취급하며 사용시간으로는 단기하중으로 분류된다. \n" +
                        "\n" +
                        "- 지역에 따라 설계기본 풍속도가 다르다. \n" +
                        "\n" +
                        "● 시공하중 \n" +
                        "\n" +
                        "- 시공 중에 발생하는 하중 \n" +
                        "\n" +
                        "- 차량에 의한 하중, 자재의 적재에 의한 하중 \n" +
                        "\n" +
                        "- 설계시에는 반영하지 않고 별도의 서포터를 설치하는 방식으로 대비 \n" +
                        "\n" +
                        "● 기타하중 \n" +
                        "\n" +
                        "- 온도에 의해 발생하는 하중 \n" +
                        "\n" +
                        "- 지진하중 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<힘의 종류> \n" +
                        "\n" +
                        "● 축력 -> 누르는 힘과 잡아당기는 힘 \n" +
                        "\n" +
                        "- 누르는 힘 = 압축력 \n" +
                        "\n" +
                        "- 잡아당기는 힘 = 인장력 \n" +
                        "\n" +
                        "● 전단력 \n" +
                        "\n" +
                        "- 조적조의 건축물에서 몰타르는 조적과 조적을 연결시켜주는 매개체 역할 \n" +
                        "\n" +
                        "- 조적은 압축에는 강하지만 수평하중에는 약하다 \n" +
                        "\n" +
                        "- 수평하중은 몰타르가 받아야 한다 \n" +
                        "\n" +
                        "- 일반 주택에서 몰타르부분에 균열이 있는 경우에는 압축이 아니라 수평하중, 외력에 의해 균열이 발생한 것이다 \n" +
                        "\n" +
                        "- 지반의 침하로 인한 수평력 발생으로 균열이 생성한다 \n" +
                        "\n" +
                        "● 모멘트(Moment) \n" +
                        "\n" +
                        "- 일반적으로 휨이라고 한다 \n" +
                        "\n" +
                        "- 휨은 인장력이 발생하는 것과 마찬가지이기 때문에 하부에 철근이 들어가야 한다 \n" +
                        "\n" +
                        "- 철근이 외력에 의한 하중을 받는 가장 중요한 요소 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<기초의 종류> \n" +
                        "\n" +
                        "- 주택과 일반건물로 구분할 수 있다 \n" +
                        "\n" +
                        "- 지반의 단단함에 따라 기초 형식이 달라진다 \n" +
                        "\n" +
                        "- 일반 주택의 경우 온통기초를 한다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<동결선> \n" +
                        "\n" +
                        "- 겨울철에 땅이 어는 깊이를 말한다 \n" +
                        "\n" +
                        "- 땅이 얼게 되어 부피가 증가하게 되면 동결선 깊이를 지키지 않은 기초판을 들어올리게 된다. 이어 봄이 와서 해빙기가 오면 다시 침하하게 되어 건축물의 균열 원인이 되므로 지역의 기후조건에 따라 동결선의 깊이를 반영하여야 한다. \n" +
                        "\n" +
                        " ");
            } else if (index == 8) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e08.mp4"));
                textView2.setText("균열원인(구조)");
                textView.setText("<콘크리트 균열> \n" +
                        "\n" +
                        "● 주요 균열 지점 \n" +
                        "\n" +
                        "- 주택의 슬래브(천정), 기초, 칸막이 부분에서 균열이 발생 \n" +
                        "\n" +
                        "● 발생 원인에 의한 분류 \n" +
                        "\n" +
                        "- 설계조건에 의한 균열 \n" +
                        "\n" +
                        "- 시공조건에 의한 균열 \n" +
                        "\n" +
                        "- 재료조건에 의한 균열 \n" +
                        "\n" +
                        "- 사용환경에 의한 균열 \n" +
                        "\n" +
                        "● 내력 영향에 의한 분류 \n" +
                        "\n" +
                        "- 구조적 균열 \n" +
                        "\n" +
                        "# 사용하중의 작용으로 발생하는 균열 \n" +
                        "\n" +
                        "# 구조안전에 영향을 미치는 균열 \n" +
                        "\n" +
                        "# 반드시 보수 보강이 필요 \n" +
                        "\n" +
                        "- 비구조적 균열 \n" +
                        "\n" +
                        "# 구조적 안전에는 문제가 없지만 건물의 수명에 영향을 미치기 때문에 보수보강이 필요한 균열 \n" +
                        "\n" +
                        "● 발생시기별 분류 \n" +
                        "\n" +
                        "- 콘크리트 구조체 : 양생 전 / 후 \n" +
                        "\n" +
                        "- 조적조 건물 \n" +
                        "\n" +
                        "# 조적을 연결하는 몰타르에서 발생 \n" +
                        "\n" +
                        "# 경화 중 / 경화 후 발생으로 나뉨 \n" +
                        "\n" +
                        "# 대부분의 경우 경화 후 발생 \n" +
                        "\n" +
                        "# 건조수축에 의한 균열이 가장 많음 \n" +
                        "\n" +
                        "● 사용재료에 의한 균열 \n" +
                        "\n" +
                        "- 시멘트 \n" +
                        "\n" +
                        "# 이상응결, 수화열, 이상팽창 등이 원인 \n" +
                        "\n" +
                        "# 일반주택의 경우는 이상 팽창이 주요 원인 \n" +
                        "\n" +
                        "# 벽체보다는 슬래브(지붕)에 방사형 그물모양의 균열 \n" +
                        "\n" +
                        "# 반드시 보수 보강 후 방수 시공을 해야 함 \n" +
                        "\n" +
                        "● 시공환경에 의한 균열 \n" +
                        "\n" +
                        "- 급속한 타설 : 거푸집 변형, 침하 및 블리딩에 의한 균열 \n" +
                        "\n" +
                        "- 다짐 불충분 : 골재분리 발생, 설계시 강도와 내력에 영향 \n" +
                        "\n" +
                        "- 급격한 건조 : 건조의 시차 때문에 표면에 균열이 발생 \n" +
                        "\n" +
                        "- 거푸집 변형 : 보가 처지는 현상이 발생하여 안정성에 영향 \n" +
                        "\n" +
                        "- 동바리 부실설치 : 거푸집 변형에 영향을 크게 미침. \n" +
                        "\n" +
                        "● 환경요인에 의한 균열 \n" +
                        "\n" +
                        "- 외부 온습도 변화 : 건조수축 균열과 유사한 형태로 발생 \n" +
                        "\n" +
                        "- 동결융해 : 온도가 낮을 때 타설을 했을 경우 \n" +
                        "\n" +
                        "- 화재 \n" +
                        "\n" +
                        "# 표면전체에 거북등 모양의 가는 균열 발생 \n" +
                        "\n" +
                        "# 화재가 일어나는 경우 강도, 강성이 50% 감소 \n" +
                        "\n" +
                        "● 구조적요인에 의한 균열 \n" +
                        "\n" +
                        "- 하중에 의한 균열 : 가장 위험하고 중요한 균열 \n" +
                        "\n" +
                        "- 설계하중 초과 : 활하중에 의해 균열 발생 \n" +
                        "\n" +
                        "- 설계 오류의 경우는 많지 않다. \n" +
                        "\n" +
                        "- 사용목적에 따라 사용하중이 다르기 때문에 사용목적과 다르게 사용하는 경우 전문가와 상의 필요 \n" +
                        "\n" +
                        "● 발생시기에 의한 균열 \n" +
                        "\n" +
                        "- 경화 중 균열 ");
            } else if (index == 9) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e09.mp4"));
                textView2.setText("균열사례 및 보수(구조)");
                textView.setText("<콘크리트 균열> \n" +
                        "\n" +
                        "● 주요 균열 지점 \n" +
                        "\n" +
                        "- 주택의 슬래브(천정), 기초, 칸막이 부분에서 균열이 발생 \n" +
                        "\n" +
                        "● 발생 원인에 의한 분류 \n" +
                        "\n" +
                        "- 설계조건에 의한 균열 \n" +
                        "\n" +
                        "- 시공조건에 의한 균열 \n" +
                        "\n" +
                        "- 재료조건에 의한 균열 \n" +
                        "\n" +
                        "- 사용환경에 의한 균열 \n" +
                        "\n" +
                        "● 내력 영향에 의한 분류 \n" +
                        "\n" +
                        "- 구조적 균열 \n" +
                        "\n" +
                        "# 사용하중의 작용으로 발생하는 균열 \n" +
                        "\n" +
                        "# 구조안전에 영향을 미치는 균열 \n" +
                        "\n" +
                        "# 반드시 보수 보강이 필요 \n" +
                        "\n" +
                        "- 비구조적 균열 \n" +
                        "\n" +
                        "# 구조적 안전에는 문제가 없지만 건물의 수명에 영향을 미치기 때문에 보수보강이 필요한 균열 \n" +
                        "\n" +
                        "● 발생시기별 분류 \n" +
                        "\n" +
                        "- 콘크리트 구조체 : 양생 전 / 후 \n" +
                        "\n" +
                        "- 조적조 건물 \n" +
                        "\n" +
                        "# 조적을 연결하는 몰타르에서 발생 \n" +
                        "\n" +
                        "# 경화 중 / 경화 후 발생으로 나뉨 \n" +
                        "\n" +
                        "# 대부분의 경우 경화 후 발생 \n" +
                        "\n" +
                        "# 건조수축에 의한 균열이 가장 많음 \n" +
                        "\n" +
                        "● 사용재료에 의한 균열 \n" +
                        "\n" +
                        "- 시멘트 \n" +
                        "\n" +
                        "# 이상응결, 수화열, 이상팽창 등이 원인 \n" +
                        "\n" +
                        "# 일반주택의 경우는 이상 팽창이 주요 원인 \n" +
                        "\n" +
                        "# 벽체보다는 슬래브(지붕)에 방사형 그물모양의 균열 \n" +
                        "\n" +
                        "# 반드시 보수 보강 후 방수 시공을 해야 함 \n" +
                        "\n" +
                        "● 시공환경에 의한 균열 \n" +
                        "\n" +
                        "- 급속한 타설 : 거푸집 변형, 침하 및 블리딩에 의한 균열 \n" +
                        "\n" +
                        "- 다짐 불충분 : 골재분리 발생, 설계시 강도와 내력에 영향 \n" +
                        "\n" +
                        "- 급격한 건조 : 건조의 시차 때문에 표면에 균열이 발생 \n" +
                        "\n" +
                        "- 거푸집 변형 : 보가 처지는 현상이 발생하여 안정성에 영향 \n" +
                        "\n" +
                        "- 동바리 부실설치 : 거푸집 변형에 영향을 크게 미침. \n" +
                        "\n" +
                        "● 환경요인에 의한 균열 \n" +
                        "\n" +
                        "- 외부 온습도 변화 : 건조수축 균열과 유사한 형태로 발생 \n" +
                        "\n" +
                        "- 동결융해 : 온도가 낮을 때 타설을 했을 경우 \n" +
                        "\n" +
                        "- 화재 \n" +
                        "\n" +
                        "# 표면전체에 거북등 모양의 가는 균열 발생 \n" +
                        "\n" +
                        "# 화재가 일어나는 경우 강도, 강성이 50% 감소 \n" +
                        "\n" +
                        "● 구조적요인에 의한 균열 \n" +
                        "\n" +
                        "- 하중에 의한 균열 : 가장 위험하고 중요한 균열 \n" +
                        "\n" +
                        "- 설계하중 초과 : 활하중에 의해 균열 발생 \n" +
                        "\n" +
                        "- 설계 오류의 경우는 많지 않다. \n" +
                        "\n" +
                        "- 사용목적에 따라 사용하중이 다르기 때문에 사용목적과 다르게 사용하는 경우 전문가와 상의 필요 \n" +
                        "\n" +
                        "● 발생시기에 의한 균열 \n" +
                        "\n" +
                        "- 경화 중 균열 ");
            } else if (index == 10) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e10.mp4"));
                textView2.setText("방수의 종류와 특징(방수)");
                textView.setText("<콘크리트 균열> \n" +
                        "\n" +
                        "● 주요 균열 지점 \n" +
                        "\n" +
                        "- 주택의 슬래브(천정), 기초, 칸막이 부분에서 균열이 발생 \n" +
                        "\n" +
                        "● 발생 원인에 의한 분류 \n" +
                        "\n" +
                        "- 설계조건에 의한 균열 \n" +
                        "\n" +
                        "- 시공조건에 의한 균열 \n" +
                        "\n" +
                        "- 재료조건에 의한 균열 \n" +
                        "\n" +
                        "- 사용환경에 의한 균열 \n" +
                        "\n" +
                        "● 내력 영향에 의한 분류 \n" +
                        "\n" +
                        "- 구조적 균열 \n" +
                        "\n" +
                        "# 사용하중의 작용으로 발생하는 균열 \n" +
                        "\n" +
                        "# 구조안전에 영향을 미치는 균열 \n" +
                        "\n" +
                        "# 반드시 보수 보강이 필요 \n" +
                        "\n" +
                        "- 비구조적 균열 \n" +
                        "\n" +
                        "# 구조적 안전에는 문제가 없지만 건물의 수명에 영향을 미치기 때문에 보수보강이 필요한 균열 \n" +
                        "\n" +
                        "● 발생시기별 분류 \n" +
                        "\n" +
                        "- 콘크리트 구조체 : 양생 전 / 후 \n" +
                        "\n" +
                        "- 조적조 건물 \n" +
                        "\n" +
                        "# 조적을 연결하는 몰타르에서 발생 \n" +
                        "\n" +
                        "# 경화 중 / 경화 후 발생으로 나뉨 \n" +
                        "\n" +
                        "# 대부분의 경우 경화 후 발생 \n" +
                        "\n" +
                        "# 건조수축에 의한 균열이 가장 많음 \n" +
                        "\n" +
                        "● 사용재료에 의한 균열 \n" +
                        "\n" +
                        "- 시멘트 \n" +
                        "\n" +
                        "# 이상응결, 수화열, 이상팽창 등이 원인 \n" +
                        "\n" +
                        "# 일반주택의 경우는 이상 팽창이 주요 원인 \n" +
                        "\n" +
                        "# 벽체보다는 슬래브(지붕)에 방사형 그물모양의 균열 \n" +
                        "\n" +
                        "# 반드시 보수 보강 후 방수 시공을 해야 함 \n" +
                        "\n" +
                        "● 시공환경에 의한 균열 \n" +
                        "\n" +
                        "- 급속한 타설 : 거푸집 변형, 침하 및 블리딩에 의한 균열 \n" +
                        "\n" +
                        "- 다짐 불충분 : 골재분리 발생, 설계시 강도와 내력에 영향 \n" +
                        "\n" +
                        "- 급격한 건조 : 건조의 시차 때문에 표면에 균열이 발생 \n" +
                        "\n" +
                        "- 거푸집 변형 : 보가 처지는 현상이 발생하여 안정성에 영향 \n" +
                        "\n" +
                        "- 동바리 부실설치 : 거푸집 변형에 영향을 크게 미침. \n" +
                        "\n" +
                        "● 환경요인에 의한 균열 \n" +
                        "\n" +
                        "- 외부 온습도 변화 : 건조수축 균열과 유사한 형태로 발생 \n" +
                        "\n" +
                        "- 동결융해 : 온도가 낮을 때 타설을 했을 경우 \n" +
                        "\n" +
                        "- 화재 \n" +
                        "\n" +
                        "# 표면전체에 거북등 모양의 가는 균열 발생 \n" +
                        "\n" +
                        "# 화재가 일어나는 경우 강도, 강성이 50% 감소 \n" +
                        "\n" +
                        "● 구조적요인에 의한 균열 \n" +
                        "\n" +
                        "- 하중에 의한 균열 : 가장 위험하고 중요한 균열 \n" +
                        "\n" +
                        "- 설계하중 초과 : 활하중에 의해 균열 발생 \n" +
                        "\n" +
                        "- 설계 오류의 경우는 많지 않다. \n" +
                        "\n" +
                        "- 사용목적에 따라 사용하중이 다르기 때문에 사용목적과 다르게 사용하는 경우 전문가와 상의 필요 \n" +
                        "\n" +
                        "● 발생시기에 의한 균열 \n" +
                        "\n" +
                        "- 경화 중 균열 ");
            } else if (index == 11) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e11.mp4"));
                textView2.setText("방수의 시공방법(방수)");
                textView.setText("<노출도막방수 시공방법> \n" +
                        "\n" +
                        "● 바탕작업 \n" +
                        "\n" +
                        "- 바탕면을 충분히 건조한 후(함수율 8% 이하) 표면  노화부분, 먼지, 모래 등을 깨끗이 정리하고 그라인더로 갈아낸다. \n" +
                        "\n" +
                        "- 균열이 있는 곳은 V커팅으로 보수, 보강하고 구배가 불량한 곳은 폴리머시멘트로 조정한다. \n" +
                        "\n" +
                        "● 하도작업 \n" +
                        "\n" +
                        "- 드레인에 결함이 있으면 철거하고 방수처리한 후 배수가 쉽도록 경사를 만든다. \n" +
                        "\n" +
                        "- 바탕정리가 끝난 후 프라이머를 기포가 생기지 않도록 고르게 바르고 충분히 건조시킨다. \n" +
                        "\n" +
                        "● 실링작업 \n" +
                        "\n" +
                        "- 파라펫, 옥탑, 환기통 등 바탕면과 직각으로 만나는 우레탄 실링제로 처리한다. \n" +
                        "\n" +
                        "- 요철, 크랙이 있는 곳에 신구 접착력이 뛰어나고 인장력이 있는 우레탄 실링제로 보강한다. \n" +
                        "\n" +
                        "● 중도작업 \n" +
                        "\n" +
                        "- 주제와 경화제를 1:2.5로 배합하고 전동교반기로 3~5분간 섞는다. \n" +
                        "\n" +
                        "- 점도를 조절하고 접착이 잘 되도록 필요할 때는 신나 또는 규사를 5% 이내로 섞어서 사용한다. \n" +
                        "\n" +
                        "- 롤러나 전용레기로 1.5mm씩 반드시 2회로 나누어 평균 3mm두께로 시공한다. \n" +
                        "\n" +
                        "- 1차 도포 후 탈기장치(에어벤트)를 설치한다. \n" +
                        "\n" +
                        "● 상도작업 \n" +
                        "\n" +
                        "- 중도작업이 완전히 경화된 후 미비한 곳을 보수하고 로울러 등을 사용하여 상도작업하고 자외선으로부터 보호한다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<노출도막방수 유지관리> \n" +
                        "\n" +
                        "- 시공하고 3년 경과한 후 상도작업을 하면 오랫동안 쓸 수 있습니다. \n" +
                        "\n" +
                        "- 지붕 위에 물빠짐을 방해하거나 비온 후 건조를 방해하는 물건들을 올려놓지 않습니다. \n" +
                        "\n" +
                        "- 평지붕은 방수성능뿐만 아니라 단열성능도 취약하므로 리모델링을 계획할 때 경사지붕으로 바꾸는 것을 고려합니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<시트방수 개요> \n" +
                        "\n" +
                        "- 롤로 말려있는 방수지를 현장에서 시공하는 방식 \n" +
                        "\n" +
                        "- 주택보다는 공장등의 규모가 큰 건축물에 주로 시공 \n" +
                        "\n" +
                        "- 도막방수나 시멘트 액체방수와 섞어서 시공하기도 함 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<시트방수 종류> \n" +
                        "\n" +
                        "1) 개량 아스팔트 시트 \n" +
                        "\n" +
                        "2) 합성고분자계 시트 \n" +
                        "\n" +
                        "3) 자착형 시트 ");
            } else if (index == 12) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e12.mp4"));
                textView2.setText("방수 사례와 해결(방수)");
                textView.setText("<하자방지 대칙> \n" +
                        "\n" +
                        "1) 작업전 : 바탕처리 철저 \n" +
                        "\n" +
                        "- 구배 - 비노출 1/100 이상, 노출 1/50 \n" +
                        "\n" +
                        "- 요철, 균열, 들뜸, 레이턴스, 취약부, 돌기부, 철선 등 이물질 제거 \n" +
                        "\n" +
                        "- 지나치게 매끄러운 표면 접착력 확보위한 고압수세척기 등 조치 \n" +
                        "\n" +
                        "- 먼지, 유지류, 오염, 녹 또는 박리제 등이 없을 것 \n" +
                        "\n" +
                        "- 치켜올림, 모서리부위 처리, 관통파이프, 드레인 주위 처리 \n" +
                        "\n" +
                        "2) 작업중 : 기상상태 확인, 취약부 보강, 균열부위 절연처리 \n" +
                        "\n" +
                        "3) 작업후 : 육안검사(들뜸, 찍힘, 기포), 누수테스트, 보양 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<방수 이론 정리> \n" +
                        "\n" +
                        "1) 방수공법의 종류 \n" +
                        "\n" +
                        "- 도막방수 / 시트방수/ 시멘트 액체방수 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "2) 도막방수 \n" +
                        "\n" +
                        "① 바탕작업, 하도작업, 실링작업, 중도작업, 상도작업의 순서 \n" +
                        "\n" +
                        "② 바탕작업이 매우 중요, 방수작업의 90% \n" +
                        "\n" +
                        "③ 하도작업의 프라이머는 도막방수액과 바탕이 잘 접합되게함 \n" +
                        "\n" +
                        "④ 실링작업은 균열이나 틈을 메워주는 작업 \n" +
                        "\n" +
                        "⑤ 중도작업은 전용롤러나 레기로 방수액을 2회 이상 바른다 \n" +
                        "\n" +
                        "⑥ 상도작업은 중도작업의 미비한 부분을 마무리 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "3) 시트방수 \n" +
                        "\n" +
                        "① 바탕작업, 프라이머 도포, 시트방수 부착, 의 순서 \n" +
                        "\n" +
                        "② 바탕작업이 매우 중요, 방수작업의 90% \n" +
                        "\n" +
                        "③ 프라이머는 시트지가 잘 접합되도록 하는 작업 \n" +
                        "\n" +
                        "④ 시트방수 부착은 이음부위가 10cm 이상이 중요 \n" +
                        "\n" +
                        "⑤ 시공 후 방수층 검사 필수 \n" +
                        "\n" +
                        "⑥ 필요시 보호마감 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "4) 시멘트 액체방수 \n" +
                        "\n" +
                        "① 적절한 습기를 가지고 있는 곳에 할 수 있는 공법 \n" +
                        "\n" +
                        "② 바탕처리를 하면서 물을 뿌려주는 것이 필요 \n" +
                        "\n" +
                        "③ 프라이머는 도막방수액과 바탕이 잘 접합되도록 하는 작업 \n" +
                        "\n" +
                        "④ 겹침폭은 10cm 이상 \n" +
                        "\n" +
                        "⑤ 양생 및 점검에 주의 \n" +
                        "\n" +
                        " ");
            } else if (index == 13) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e13.mp4"));
                textView2.setText("단열은 꼭 해야 하는가?(단열)");
                textView.setText("<단열> \n" +
                        "\n" +
                        "- 기후 변화의 주요 원인은 우리가 숨쉴 때 나오는 이산화탄소 \n" +
                        "\n" +
                        "- 온실가스 주요 배출 원인 \n" +
                        "\n" +
                        "# 가스보일러 \n" +
                        "\n" +
                        "# 에어콘 실외기 \n" +
                        "\n" +
                        "- 모든 나라와 도시는 탄소배출을 줄일 의무가 있습니다. \n" +
                        "\n" +
                        "- 우리가 사는 지구는 다음 세대가 또 살아갈 장소입니다. ");
            } else if (index == 14) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e14.mp4"));
                textView2.setText("열의 이동경로 전도 대류 복사(단열)");
                textView.setText("<어떻게 하면 열이 이동하는 것을 막을 수 있을까요?> \n" +
                        "\n" +
                        "●  열이 도망가는 3가지 방법 \n" +
                        "\n" +
                        "- 전도 \n" +
                        "\n" +
                        "- 대류 \n" +
                        "\n" +
                        "- 복사 \n" +
                        "\n" +
                        "● 열전도란? \n" +
                        "\n" +
                        "- 열이 고온부분에서 저온부분으로 중간물질을 통해 이동하는 것을 말한다 \n" +
                        "\n" +
                        "<위키백과> \n" +
                        "\n" +
                        "- 물질이 직접 이동하지 않고 물체 안에서 이웃한 분자들이 서로 연속적인 충돌에 의해 열이 전달되는 현상 \n" +
                        "\n" +
                        "- 주로 고체에서 열이 이동하는 방법 \n" +
                        "\n" +
                        "<ZUM 학습백과> \n" +
                        "\n" +
                        "- 열전도율이 좋으면 단열재의 성능은 나쁘고 열전도율이 나쁘면 단열재의 성능은 좋다 \n" +
                        "\n" +
                        "- 전도율이 좋은 알루미늄 단열재는 실외의 기온이 그대로 실내에 전달됩니다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<대류란?> \n" +
                        "\n" +
                        "- 유체 내에서 열이 전달되는 방법 \n" +
                        "\n" +
                        "<ZUM 학습백과> \n" +
                        "\n" +
                        "대류현상이 계속 진행되면 온도 차가 계속 유지됩니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<대류를 막는 방법> \n" +
                        "\n" +
                        "- 강제로 역대류를 발생시킨다 \n" +
                        "\n" +
                        "- 유체의 통로의 폭을 좁힌다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<복사> \n" +
                        "\n" +
                        "- 전도와 대류와 달리 중간에 전달하는 물질 없이도 열이 전달된다 ");
            } else if (index == 15) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e15.mp4"));
                textView2.setText("열전도율 열관류율 열저항(단열)");
                textView.setText("<열전도란> \n" +
                        "\n" +
                        "- 1kcal를 어떤 물질에 놓았을 때 얼마나 열을 잘 전달하느냐 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<열관류율> \n" +
                        "\n" +
                        "- 열전도율 / 두께 \n" +
                        "\n" +
                        "- 모든 재료의 두께가 같다면 열전도율과 열관류율은 같습니다 \n" +
                        "\n" +
                        "- 열전도율이 낮은 물질을 얇게 사용하면 열관류율은 높아집니다 \n" +
                        "\n" +
                        "- 열전도율이 높은 물질을 두껍게 사용하면 열관류율은 낮아집니다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<열저항> \n" +
                        "\n" +
                        "- 열관류율의 역수 \n" +
                        "\n" +
                        "- 각각 다른 자재의 열저항값을 내서 합산을 내주어야 합니다 \n" +
                        "\n" +
                        "- 복합재료의 열관류율 수치를 구할 때 각각 재료의 열관류율을 모두 합산하면 너무 커집니다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<열교현상> \n" +
                        "\n" +
                        "- 건축물 어느 한 부분의 단열이 약화되거나 끊김으로 인해 외기가 실내로 들어오는 것 \n" +
                        "\n" +
                        "- 열교현상은 단열의 마무리에 있어서 반드시 확인해야 할 단계입니다 \n" +
                        "\n" +
                        " ");
            } else if (index == 16) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e16.mp4"));
                textView2.setText("단열재 종류별 특징(단열)");
                textView.setText("<압출법 보호판> \n" +
                        "\n" +
                        "- 아이소핑크라고도 하며 열전도율이 낮고 밀도가 높다 \n" +
                        "\n" +
                        "- 흡수성이 낮아 단열성능이 높다 \n" +
                        "\n" +
                        "- 시간이 경과하면 단열성이 낮아진다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<비드법 보호판> \n" +
                        "\n" +
                        "- 스티로폼이라고도 하며 지상층 외벽에 많이 쓰인다 \n" +
                        "\n" +
                        "- 가격이 저렴하며 밀도가 높아 단열이 우수하다 \n" +
                        "\n" +
                        "- 생산 후 바로 사용 시 수축 변형이 있을 수 있다 \n" +
                        "\n" +
                        "- 변형 방지를 위해 생산 뒤 6주간 숙성 후 사용한다 \n" +
                        "\n" +
                        "- 흡수율이 높아 물에 젖기 쉬움 \n" +
                        "\n" +
                        "- 가연성이 높아 내부 사용 어려움 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<복합단열판> \n" +
                        "\n" +
                        "- 복합단열재로 습기에 강해 결로 방지를 할 수 있고 곰팡이가 피기 쉬운 곳에 사용 \n" +
                        "\n" +
                        "- 압출법보호판, 비드법보호판 등을 복합사용 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<창과 문 사이의 기밀성 높이기> \n" +
                        "\n" +
                        "- 아무리 단열을 높인다 해도 창문 틈으로 일어나는 대류현상을 막을 수는 없습니다 \n" +
                        "\n" +
                        " ");
            } else if (index == 17) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e17.mp4"));
                textView2.setText("목재의 종류와 특성(목공)");
                textView.setText("<PB합판> \n" +
                        "\n" +
                        "- 주 사용처 : 가구 및 케이스 등 저가형 제품 \n" +
                        "\n" +
                        "<집성목의 분류> \n" +
                        "\n" +
                        "- 솔리드방식 \n" +
                        "\n" +
                        "- 핑거조인트방식 \n" +
                        "\n" +
                        " ");
            } else if (index == 18) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e18.mp4"));
                textView2.setText("자재구입과 안전수칙(목공)");
                textView.setText("- 방부목은 '데크'에 많이 사용 \n" +
                        "\n" +
                        "- 합판, MDF 등은 목재소에 쉽게 구할 수 있는데 원목의 경우 종류에 따라 구하는데 어려움이 있을 수 있습니다 \n" +
                        "\n" +
                        "- 1차 판매자에게 구입할 경우, 목재를 저렴하게 구할 수는 있으나 운송에 어려움이 있습니다 \n" +
                        "\n" +
                        "- 2차 판매자의 경우 재단을 해서 판매합니다 \n" +
                        "\n" +
                        "- 온라인 상에 목공D.I.Y, 집성목 등으로 검색하면 쉽게 찾을 수 있습니다 \n" +
                        "\n" +
                        "- 목재로 가구를 만든다고 하였을 때 결을 잘 생각해서 방향을 결정합니다 \n" +
                        "\n" +
                        "- 여성의 경우, 긴 머리카락이 공구에 감기지 않도록 조심합니다 \n" +
                        "\n" +
                        "- 컨디션이 나쁜 경우, 작업을 하지 않습니다 \n" +
                        "\n" +
                        " ");
            } else if (index == 19) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e19.mp4"));
                textView2.setText("목재의 가공(목공)");
                textView.setText("- 업체에 문의할 때는 mm단위로 이야기하는 것이 좋습니다 \n" +
                        "\n" +
                        "- 목재에 구멍을 낼 때에는 드릴을 이용합니다 \n" +
                        "\n" +
                        "- 마감 칠을 하기전에 사포질까지 꼭 끝내야 합니다 \n" +
                        "\n" +
                        "- 목재 밖으로 나오는 스테인은 한번 닦아내줘야 합니다 \n" +
                        "\n" +
                        "- 바니쉬는 투명한 마감재로 목재 위에 얇은 막을 형성해줍니다 \n" +
                        "\n" +
                        "# 수분을 막아주고 스크래치를 일정 부분 보호합니다 \n" +
                        "\n" +
                        "- 유성 바니쉬는 야외에서 사용하기 좋고 내구성이 좋습니다 \n" +
                        "\n" +
                        "- 수성 바니쉬는 접근이 쉽고 붓으로 쉽게 작업할 수 있습니다 \n" +
                        "\n" +
                        "- 수성 바니쉬 작업 후에는 살짝 올라온 잔가시들을 사포로 정리합니다 \n" +
                        "\n" +
                        "- 나뭇결을 돋보이게 하고 고급스러운 느낌을 줍니다 \n" +
                        "\n" +
                        " ");
            } else if (index == 20) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e20.mp4"));
                textView2.setText("페인트 종류(페인트)");
                textView.setText("- 유성 페인트의 장점은 저렴한 가격과 접착력 커버력 등이 우수하다는 장점이 있지만 유기용제인 '신나'로 희석하기 때문에 냄새 뿐만 아니라 유기화학물질이 함유되어 일반인이, 특히 실내에 작업하기에는 수월하지 않습니다 \n" +
                        "\n" +
                        "- 요즘은 건강까지 생각하는 친환경 인테리어가 대세입니다 \n" +
                        "\n" +
                        "- 100% 천연원료를 사용한 천연 페인트 및 유해물질 배출을 최대한 차단한 친환경 페인트 제품도 존재합니다 \n" +
                        "\n" +
                        "- 우리나라는 친환경페인트를 VOC(휘발성 유기화합물) 함유량이 리터랑 35g 이하면 친환경이라고 인증하고 있습니다 \n" +
                        "\n" +
                        "- 도장면에 적합한 페인트를 사용하는 것이 하자없는 올바른 페인트 작업입니다 \n" +
                        "\n" +
                        "- 프라이머는 커버력/접착력/발색력을 높여주는 역할을 하고 페인트를 떨어지지 않게 잡아주는 일종의 본드, 하도로 이해할 수 있습니다 \n" +
                        "\n" +
                        "- 다목적/철제갈바용/타일용 등으로 다양하게 있으니 목적에 맞게 선택 작업 후 작업을 진행하면 되겠습니다 \n" +
                        "\n" +
                        "- 수성페인트 작업 전 프라이머 작업을 진행하지 않으면 쉽게 벗겨지고 까지므로 꼭 페인팅 시공 전 작업을 진행하여야 합니다 \n" +
                        "\n" +
                        "- 단, 벽지 페인트 작업 시 종이 벽지는 페인트를 흡수하므로 프라이머를 생략해도 되지만 실크 벽지는 PVC재질에 코팅되어 있으므로 프라이머 사용을 권장합니다 \n" +
                        "\n" +
                        "- 붓이나 롤러, 스프레이를 이용해서 1~2회 바르고 충분히 건조하면 되겠습니다 \n" +
                        "\n" +
                        "- 날씨와 습도 등에 따라 페인트 주변 온도가 높으면 건조가 빨라집니다 \n" +
                        "\n" +
                        "- 프라이머 건조 후, 붓이나 롤러, 스프레이를 이용해서 시공하면 되겠습니다 \n" +
                        "\n" +
                        " ");
            } else if (index == 21) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e21.mp4"));
                textView2.setText("페인트 공구(페인트)");
                textView.setText("- 페인트 작업은, 붓과 롤러를 사용한 수제작업과 기계를 이용한 스프레이 작업이 있습니다 \n" +
                        "\n" +
                        "- 페인트 도구는 크게 작업도구, 밑작업도구, 기타도구로 나뉘는데요 \n" +
                        "\n" +
                        "- 수성 페인트를 사용할 때에는 수성 붓을 사용하시면 됩니다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<붓> \n" +
                        "\n" +
                        "- 평붓은 페인트 시공시 편리하게 사용할 수 있는 붓이며 앵글붓은 모서리나 섬세한 작업시에 사용하기 좋은 붓입니다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<롤러> \n" +
                        "\n" +
                        "- 롤러에서 가장 중요한 것은 털의 길이입니다 \n" +
                        "\n" +
                        "- 도장면 상태가 좋은 가구나 문 등은 단모를 사용합니다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<커버링테이프> \n" +
                        "\n" +
                        "- 넓은 면적에 칠이 묻지 않도록 해줍니다 \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<스크래퍼> \n" +
                        "\n" +
                        "- 도장면에 사포로 제거가 어려운 오염물이나 거친 면을 긁어내는데 사용합니다 \n" +
                        "\n" +
                        "- 작업이 끝난 롤러의 칠을 떼어낼 때 사용합니다 \n" +
                        "\n" +
                        " ");
            } else if (index == 22) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e22.mp4"));
                textView2.setText("실린더 문손잡이 교체(DIY)");
                textView.setText("1. 실린더 해체 \n" +
                        "\n" +
                        "- 뒷쪽을 잡고 손잡이를 해체해주세요 \n" +
                        "\n" +
                        "2. 실린더 설치 \n" +
                        "\n" +
                        "- 위쪽부터 살살~ 고정 후 아래쪽을 단단하게! \n" +
                        "\n" +
                        "- 구멍을 맞춘 후 피스를 고정 \n" +
                        "\n" +
                        "- 손잡이의 구멍 위치를 확인 후 맞춰줍니다 ");
            } else if (index == 23) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e23.mp4"));
                textView2.setText("레버 문손잡이 교체(DIY)");
                textView.setText("1. 먼저 모든 피스를 분해합니다. \n" +
                        "\n" +
                        "2. 레버손잡이 교체 \n" +
                        "\n" +
                        "- 레버의 잠금장치 방향을 유의해주세요. \n" +
                        "\n" +
                        " ");
            } else if (index == 24) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e24.mp4"));
                textView2.setText("싱크대 경첩(DIY)");
                textView.setText("- 건들지 말아야 할 것 \n" +
                        "\n" +
                        "# 몸체에 고정된 나사 \n" +
                        "\n" +
                        "# 문에 고정된 나사 \n" +
                        "\n" +
                        "- 돌출된 나사와 몸체 제일 안쪽의 나사를 조절해 '문의 균형'을 맞출 수 있습니다. \n" +
                        "\n" +
                        "- 시계 반대방향으로 드릴을 작동하면 나사가 바깥으로 나옵니다. \n" +
                        "\n" +
                        "- 좌우측 문을 열었다 닫았다 확인하며 조금씩 조정합니다. \n" +
                        "\n" +
                        "- 스토퍼와 경첩이 맞물리는 부분을 이용해 간편하게 결합할 수 있습니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 25) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e25.mp4"));
                textView2.setText("싱크대 배수관(DIY)");
                textView.setText("- 싱크대 옆 구멍은 물이 일정부분 차올랐을때 넘치는 물을 방지하는 구멍입니다. \n" +
                        "\n" +
                        "- 피스는 싱크대 옆 배수구멍 뒷 편에 위치합니다. \n" +
                        "\n" +
                        "- 싱크대 배수관을 구매시, 호스와 배관 등이 함께 구성됩니다. \n" +
                        "\n" +
                        "- 배관이 꼬이지 않도록 설치합니다. \n" +
                        "\n" +
                        "- 냄새 차단 배수 트랩도 따로 구매가 가능합니다. \n" +
                        "\n" +
                        "- 싱크대와 트랩이 밀착하지 않으면 누수의 위험이 있습니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 26) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e26.mp4"));
                textView2.setText("세면대 배관(DIY)");
                textView.setText("- 고무가 제대로 결합되지 않으면 물이 샐 수 있습니다. \n" +
                        "\n" +
                        "- 주름관 형태는 플라스틱형 제품이므로 내구성이 비교적 약할 수 있습니다. \n" +
                        "\n" +
                        "- 배관에서는 고무 마킹이 매우 중요하므로 읿어버리면 안돼요! \n" +
                        "\n" +
                        "- 고무 마킹은 항상 배관에 꼭 맞도록 결합합니다. \n" +
                        "\n" +
                        "- 배관의 위치와 잘 맞출 수 있도록 미리 결합된 트랩의 방향을 설정합니다. \n" +
                        "\n" +
                        "- 물이 S자 안에 반 정도 차있으면서 냄새가 역류하지 않도록 합니다. \n" +
                        "\n" +
                        "- 주름관 형태의 트랩은 꼬아서 설치할 경우 물의 무게 때문에 주저 앉을 수 있습니다. \n" +
                        "\n" +
                        "- 최근 주름관 트랩은 내부에 냄새가 역류되는 현상을 막는 제품도 있습니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 27) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e27.mp4"));
                textView2.setText("세면대 수전(DIY)");
                textView.setText("- 작업시에 물이 나오지 않도록 밸브를 잠그고 진행합니다. \n" +
                        "\n" +
                        "- 가정 내 수도밸브를 아예 잠그셔도 무방합니다. \n" +
                        "\n" +
                        "- 호스를 뺄 때는 꼭 하나씩 순서대로 진행합니다. \n" +
                        "\n" +
                        "- 휴지 등을 붙여 누수 여부를 확인할 수 있습니다. ");
            } else if (index == 28) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e28.mp4"));
                textView2.setText("세면대 교체(DIY)");
                textView.setText("- 세면대 높이는 허리를 숙였을 때 알맞은 높이에 맞춰주세요 \n" +
                        "\n" +
                        "- 세면대의 앵커가 들어가는 구멍높이를 체크해주세요 \n" +
                        "\n" +
                        "- 수평대를 이용해 수평을 확인한 뒤 구멍을 타공해주세요 \n" +
                        "\n" +
                        "- 벽에 설치할 때는 양쪽 앵커에 세면대를 건 후 밑에서 작업합니다 ");
            } else if (index == 29) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e29.mp4"));
                textView2.setText("모니터 받침대(DIY)");
                textView.setText("- 원하는 규격의 목재는 온라인에서도 구매할 수 있습니다 \n" +
                        "\n" +
                        "- 톱은 내려갈 때보다 톱을 당길 때 힘을 줍니다 \n" +
                        "\n" +
                        "- 톱밥을 정리해가며 톱질을 진행합니다 \n" +
                        "\n" +
                        "- 톱질은 끝으로 갈 수록 천천히 하도록 합니다 \n" +
                        "\n" +
                        "- 거친 면은 사포로 마무리 해줍니다 \n" +
                        "\n" +
                        " ");
            } else if (index == 30) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e30.mp4"));
                textView2.setText("벽선반(DIY)");
                textView.setText("- 벽 선반을 석고보드 위에 설치했을 때는 무거운 물건은 NO! \n" +
                        "\n" +
                        "- 석고보드에 설치한 선반에는 가벼운 소품으로 장식해보세요~! \n" +
                        "\n" +
                        " ");
            } else if (index == 31) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e31.mp4"));
                textView2.setText("화장실 변기(DIY)");
                textView.setText("- 변기를 들 수 있어야 설치 가능합니다 \n" +
                        "\n" +
                        "- 물높이 조절계를 적당한 높이에 위치 시켜주세요 \n" +
                        "\n" +
                        "- 손잡이 끈을 여유있게 잡아 주세요 \n" +
                        "\n" +
                        "- 수전을 열고 접합 부분에 물이 새는 지 확인해주세요 \n" +
                        "\n" +
                        "- 볼탑에 물이 차고 잘 내려가는지 확인합니다 \n" +
                        "\n" +
                        "- 앉았을 때 흔들리지 않는지 확인해주세요 \n" +
                        "\n" +
                        " ");
            } else if (index == 32) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e32.mp4"));
                textView2.setText("화장실 샤워 수전(DIY)");
                textView.setText("- 수전 몸체만 바꿀 시 밸브만 잠그고 작업하면 됩니다 \n" +
                        "\n" +
                        "- 수도관 교체 시에는 수도계량기를 잠가주세요 \n" +
                        "\n" +
                        "- 아파트는 보통 수도계량기가 복도에 위치해 있습니다 \n" +
                        "\n" +
                        "- 단독주택의 경우 수도계량기함을 찾아 잠가줍니다 \n" +
                        "\n" +
                        "- 밸브를 자주 조작하면 고무마킹이 닳아 없어질 수 있습니다 \n" +
                        "\n" +
                        "- 밸브가 너무 많이 열려 물이 샐 수 있으니 주의하세요 \n" +
                        "\n" +
                        "- 조절대 결합 후 수도계량기를 열어 물이 새지 않는지 확인해주세요 \n" +
                        "\n" +
                        "- 앞쪽 나사를 돌려 물이 새는지 확인하고 마지막으로 수압을 결정하세요 \n" +
                        "\n" +
                        " ");
            } else if (index == 33) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e33.mp4"));
                textView2.setText("화장실 타일(DIY)");
                textView.setText("- 줄눈보수용 실리콘을 타일 사이사이에 채워줍니다 \n" +
                        "\n" +
                        "- 줄눈칼을 이용해 줄눈을 제거해줍니다 \n" +
                        "\n" +
                        "- 줄눈 실리콘은 보수용입니다 \n" +
                        "\n" +
                        " ");
            } else if (index == 34) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e34.mp4"));
                textView2.setText("작은 타일 & 큰 타일(타일)");
                textView.setText("<타일 자나무 그리기> \n" +
                        "\n" +
                        "1. 자나무 위에, 시공할 작은 타일을 3mm 간격으로 연달아 놓고 사인펜으로 금을 긋는다. \n" +
                        "\n" +
                        "2. 자신에게 제일 왼쪽, 첫칸부터 번호를 매긴다. \n" +
                        "\n" +
                        "3. 간격이 일정하게 3mm인지 확인한다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<작은 타일 시공> \n" +
                        "\n" +
                        "1. 앞서 그려놓은 자나무를 벽에 대고 빗금을 친다. \n" +
                        "\n" +
                        "2. 예시된 벽의 넓이를 고려하여 중간에 빗금을 한번 더 그어준다. \n" +
                        "\n" +
                        "3. 왼쪽 끝과 중간 지점에 그려놓은 빗금을 따라 수평을 유의하며 줄을 긋는다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<타일 붙이는 본드 작업> \n" +
                        "\n" +
                        "1. 본드가 한곳에만 많이 발라지지 않도록 고르게 벽에 바른다. \n" +
                        "\n" +
                        "2. 빗질을 하듯 곧게 아랫 방향으로 펴바른다. \n" +
                        "\n" +
                        "3. 타일을 모서리부터 조금씩 간격을 두고 채워나간다. \n" +
                        "\n" +
                        "4. 아랫줄은 반으로 자른 타일부터 시작하여 개성에 따라 모양을 낸다. \n" +
                        "\n" +
                        "5. 다음 줄도 마찬가지로, 벽면에 그어진 먹줄을 따라 작은 타일을 연달아 붙인다. \n" +
                        "\n" +
                        "6. 본드를 모든 벽면에 한번에 바르지 않고 위부터 아랫방향으로 조금씩 진행한다. \n" +
                        "\n" +
                        "7. 흐트러진 타일은 본드가 굳기 전, 조금씩 움직여 제자리에 맞춰준다. \n" +
                        "\n" +
                        "8. 타일과 타일 사이는 3mm로 띄워준다. \n" +
                        "\n" +
                        " ");
            } else if (index == 35) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e35.mp4"));
                textView2.setText("줄눈(타일)");
                textView.setText("<줄눈넣기> \n" +
                        "\n" +
                        "1. 백색 줄눈형 시멘트를 작업통에 붇습니다. \n" +
                        "\n" +
                        "2. 밀가루 반죽하듯 일정량의 물과 함께 반죽해줍니다. \n" +
                        "\n" +
                        "3. 반죽한 시멘트를 작업 팔레트에 사용량 만큼 덜어줍니다. \n" +
                        "\n" +
                        "4. 줄눈을 따라 스펀지 흙손으로 페인트를 발라 넣어줍니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "- 시공 후 바로 닦지 않으면 굳음현상이 생길 수 있습니다. \n" +
                        "\n" +
                        "- 타일로 굳은 곳을 벗기면 기스를 방지할 수 있습니다. \n" +
                        "\n" +
                        "- 스폰지를 자주, 물기 없이 짜주고 닦아내야 합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 36) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e36.mp4"));
                textView2.setText("바닥타일(타일)");
                textView.setText("<바닥타일> \n" +
                        "\n" +
                        "1. 배수구 위치를 먼저 바닥에 잡아줍니다. \n" +
                        "\n" +
                        "2. 타일 본드를 바닥에 군데군데 덩어리로 떨어뜨립니다. \n" +
                        "\n" +
                        "3. 본드를 넓게 펴바릅니다. \n" +
                        "\n" +
                        "4. 바닥 끝은 길이에 맞게 타일을 절단해 붙입니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 37) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e37.mp4"));
                textView2.setText("목재 실습:집성목으로 상자 만들기(목공)");
                textView.setText("- 직쏘나 사포를 이용해 조금 맞지 않는 목재는 손질해서 사용합니다. \n" +
                        "\n" +
                        "- 나사못을 너무 강하게 체결하면 나무가 쪼개질 수도 있습니다. \n" +
                        "\n" +
                        "- 드릴로 작업할 때는 면과 면이 뜨지 않도록 작업합니다. \n" +
                        "\n" +
                        "- 혼자 작업할 시에는 나무 두께를 유의하며 구멍을 뚫습니다. \n" +
                        "\n" +
                        "- 거친면은 사포로 정리합니다. \n" +
                        "\n" +
                        "- 사포질을 할 때에는 나무의 결을 따라 정리합니다. \n" +
                        "\n" +
                        "- 수용성 마감도장을 칠할 시에는 물을 적신 느낌과 흡사합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 38) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e38.mp4"));
                textView2.setText("싱크대(페인트-밑작업)");
                textView.setText("<싱크대 옆면 밑작업> \n" +
                        "\n" +
                        "- 물티슈로 주변을 깨끗이 닦아냅니다. \n" +
                        "\n" +
                        "- 페인트 작업에서는 이물질이 없어야 깨끗하게 작업을 완료할 수 있습니다. \n" +
                        "\n" +
                        "- 바닥에 페인트가 묻지 않도록 커버링으로 꼼꼼하게 막아줍니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<퍼티 작업> \n" +
                        "\n" +
                        "- 퍼티로 구멍을 매꿉니다. \n" +
                        "\n" +
                        "- 구멍을 매꾸고 남은 퍼티는 다시 제거해줍니다. \n" +
                        "\n" +
                        "- 퍼티는 2회 반복합니다. \n" +
                        "\n" +
                        "- 퍼티가 건조된 후 면 전체를 사포로 정리합니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<상부장 밑작업> \n" +
                        "\n" +
                        "- 손잡이 부분을 먼저 제거합니다. \n" +
                        "\n" +
                        "- 페인트칠을 하기 어려운 매끈한 시트지면을 사포로 거칠게 만들어줍니다. \n" +
                        "\n" +
                        "- 페인트칠이 묻지 말아야 할 곳은 마스킹테이프를 붙여줍니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 39) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e39.mp4"));
                textView2.setText("타일(페인트-밑작업)");
                textView.setText("- 타일에 붙어있는 스티커, 걸이 등을 모두 제거합니다. \n" +
                        "\n" +
                        "- 글루건으로 붙은 경우 스크래퍼 & 헤라 등을 이용합니다. \n" +
                        "\n" +
                        "- 오래된 스티커 자국은 헤어드라이기 등으로 열을 가하면 한결 수월합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 40) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e40.mp4"));
                textView2.setText("방문(페인트-밑작업)");
                textView.setText("- 먼저 기존의 문틀을 사포로 거칠게 만들어줍니다. \n" +
                        "\n" +
                        "- 이물질을 모두 제거합니다. \n" +
                        "\n" +
                        "- 방문을 아예 분리 후 칠 작업을 준비합니다. \n" +
                        "\n" +
                        "- 경첩에 붙어있는 검은식 기름때와 먼지를 물티슈로 닦아냅니다. \n" +
                        "\n" +
                        "- 방문과 문틀을 사포로 정리합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 41) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e41.mp4"));
                textView2.setText("샷시(페인트-밑작업)");
                textView.setText("- 창문을 위로 살짝 들어올린 후 몸쪽으로 당기면 분리할 수 있습니다. \n" +
                        "\n" +
                        "- 창틀에 있는 먼지를 깨끗하게 털어냅니다. \n" +
                        "\n" +
                        "- 칠이 묻지 말아야할 방범창 등은 마스킹테이프를 이용해 마감합니다. \n" +
                        "\n" +
                        "- 페인트가 칠해진 모든 면은 사포로 거칠게 만들어줍니다. \n" +
                        "\n" +
                        "- 샤시를 제거한 후 넓은 공간에서 작업하시면 수월합니다. \n" +
                        "\n" +
                        "- 페인트칠이 묻지 말아야 할 유리에는 마스킹테이프를 붙입니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 42) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e42.mp4"));
                textView2.setText("현관문(페인트-밑작업)");
                textView.setText("- 현관문의 오래된 부착물들은 제거합니다. \n" +
                        "\n" +
                        "- 제거가 어려운 것들은 마스킹테이프로 꼼꼼하게 마감합니다. \n" +
                        "\n" +
                        "- 마스킹테이프가 현관문 면까지 붙지 않도록 경계면을 잘 설정합니다. \n" +
                        "\n" +
                        "- 스티커 & 이물질 등은 헤라 & 스크래퍼를 이용해서 깨끗하게 제거합니다. \n" +
                        "\n" +
                        "- 너무 오래된 스티커 자국은 최대한 제거 후 사포로 면을 매끈해지게 만들어줍니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 43) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e43.mp4"));
                textView2.setText("싱크대(페인트-프라이머)");
                textView.setText("- 프라이머 작업을 위해 싱크대를 분리해 넓은 공간에서 작업합니다. \n" +
                        "\n" +
                        "- 면을 칠할 때는 위부터 칠하지 않고 중간 지점부터 칠합니다. \n" +
                        "\n" +
                        "- 롤러는 한 쪽으로 치우치거나 기울지 않도록 평평하게 칠합니다. \n" +
                        "\n" +
                        "- 좁은 면은 4인치 롤러를 사용합니다. \n" +
                        "\n" +
                        "- 칠이 다른면으로 넘어간 경우 롤러에 칠이 최대한 없는 상태로 펴바릅니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 44) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e44.mp4"));
                textView2.setText("타일(페인트-프라이머)");
                textView.setText("- 모서리, 경계선 등부터 붓으로 먼저 프라이머를 칠합니다. \n" +
                        "\n" +
                        "- 상부장과 접하는 빈 틈은 붓을 이용하여 칠합니다. \n" +
                        "\n" +
                        "- 타일 경계면도 붓을 이용해서 매꾸어 줍니다. \n" +
                        "\n" +
                        "- 콘센트 주변도 롤러 작업이 힘들기 때문에 붓으로 작업합니다. \n" +
                        "\n" +
                        "- 실리콘 제거가 힘들시에는 프라이머로 실리콘 부분도 함께 칠합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 45) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e45.mp4"));
                textView2.setText("방문(페인트-프라이머)");
                textView.setText("- 면이 넓은 방문의 경우 6인치 롤러를 사용합니다. \n" +
                        "\n" +
                        "- 구역을 나누어 가운데 홈부터 프라이머 작업을 시작합니다. \n" +
                        "\n" +
                        "- 일정량 페인트를 묻혀놓고 본격적인 롤러 작업을 합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 46) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e46.mp4"));
                textView2.setText("샷시(페인트-프라이머)");
                textView.setText("- 롤러가 지나갈 수 없는 손잡이 홈을 붓으로 칠합니다. \n" +
                        "\n" +
                        "- 붓으로 마스킹테이프와의 경계면에 프라이머를 칠합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 47) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e47.mp4"));
                textView2.setText("현관문(페인트-프라이머)");
                textView.setText("- 롤러가 닿지 않는 곳부터 붓작업을 합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 48) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e48.mp4"));
                textView2.setText("싱크대(페인트-칠하기)");
                textView.setText("- 싱크대는 가구의 일종이므로 가구전용 페인트를 준비합니다. \n" +
                        "\n" +
                        "- 예시로 보여지는 상부장은 평평한 디자인이므로 붓을 사용할 필요가 없습니다. \n" +
                        "\n" +
                        "- 가구의 경우 페인트가 뭉칠 경우 더욱 티가 날 수 있습니다. \n" +
                        "\n" +
                        "- 롤러를 칠할때는 제일 위부터 칠하는 것이 아니라 중간 지점부터 칠합니다. \n" +
                        "\n" +
                        "- 건조한 후에 이물질이 붙었다면 사포로 정리 후 2~3차례 같은 작업을 반복합니다. \n" +
                        "\n" +
                        "- 틈새의 경우 페인트가 흘러내릴것을 주의하면서 칠합니다.  \n" +
                        "\n" +
                        " ");
            } else if (index == 49) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e49.mp4"));
                textView2.setText("타일(페인트-칠하기)");
                textView.setText("- 롤러가 접하지 못하는 부위부터 붓 작업을 시작합니다. \n" +
                        "\n" +
                        "- 상부장 안쪽은 붓을 이용해서 페인트를 발라줍니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 50) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e50.mp4"));
                textView2.setText("방문(페인트-칠하기)");
                textView.setText("- 눈에 띄지 않는 프라이머 작업에 비해 페인트 칠 작업은 색 변화를 확인할 수 있습니다. \n" +
                        "\n" +
                        "- 롤러 작업시에 흘러내리는 페인트가 있다면 꼭 펴발라줘야 흔적이 없습니다. \n" +
                        "\n" +
                        "- 빈 곳이 있는지 확인해가며 작업을 진행합니다. \n" +
                        "\n" +
                        "- 1회 건조 후 원하는 색이 발색되도록 한번 더 같은 칠 작업을 완료합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 51) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e51.mp4"));
                textView2.setText("샷시(페인트-칠하기)");
                textView.setText("- 뭉침현상이 발생하지 않도록 잘 펴발라주며 진행합니다. \n" +
                        "\n" +
                        "- 롤러를 사용하기 전에 분무기로 롤러를 살짝 적셔주어야 작업이 수월합니다. \n" +
                        "\n" +
                        "- 샷시에는 홈이 많으므로 붓 작업이 조금 더 필요합니다. \n" +
                        "\n" +
                        "- 눈으로 칠이 빈틈없이 채워졌는지 확인하며 작업을 진행합니다. \n" +
                        "\n" +
                        "- 칠이 뭉친 곳이 있다면 잘 펴발라주며 진행합니다. \n" +
                        "\n" +
                        "- 2회 칠작업을 해야 원하는 색을 만족스럽게 볼 수 있습니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 52) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e52.mp4"));
                textView2.setText("현관문(페인트-칠하기)");
                textView.setText("- 잠금장치, 문고리 등 부터 붓 작업을 시작합니다. \n" +
                        "\n" +
                        "- 칠이 뭉치지 않도록 중간부터 롤러 작업을 시작합니다. \n" +
                        "\n" +
                        "- 건조 후 반복 칠 작업까지 완료해야 합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 53) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e53.mp4"));
                textView2.setText("천장(페인트-칠하기)");
                textView.setText("- 실리콘으로 경계면을 작업합니다. \n" +
                        "\n" +
                        "- 벽지가 많이 떠 있는 경우 아예 벽지를 제거해야 할 수도 있습니다. \n" +
                        "\n" +
                        "- 가정에서는 유성실리콘 보다는 수성실리콘을 사용하는 것이 수월합니다. \n" +
                        "\n" +
                        "- 몰딩에 페인트를 안 묻게하기 위해 마스킹테이프를 붙입니다. \n" +
                        "\n" +
                        "- 롤러가 익숙하지 않은 분들은 붓 두개 넓이 정도를 칠한 후 롤러 작업을 진행합니다. \n" +
                        "\n" +
                        "- 벽지 페인트의 경우 벽지에 있는 무늬에 따라 작업의 완성도가 다를 수 있습니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 54) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e54.mp4"));
                textView2.setText("벽지_한 색(1color)_하늘색(페인트-칠하기)");
                textView.setText("- 페인트 초보자는 ㅡ자로 작업하셔도 무방합니다. \n" +
                        "\n" +
                        "- 벽의 반을 칠한 후 나머지 밑부분을 칠합니다. \n" +
                        "\n" +
                        "- 윗부분 아랫부분을 칠한 후 균일하게 제일 윗쪽과 아랫쪽까지 롤러로 펴발라줍니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 55) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e55.mp4"));
                textView2.setText("벽지_두 색(2color)_분홍색+흰색(페인트-칠하기)");
                textView.setText("- 페인트가 묻으면 안되는 곳에 마스킹테이프를 붙입니다. \n" +
                        "\n" +
                        "- 마스킹테이프 경계 위에 기존 칠(흰 칠)을 한 번 더 작업합니다. \n" +
                        "\n" +
                        "- 2회 롤러 작업 이후에 마스킹테이프를 제거하면 흡수 없이 깔끔하게 완성물이 나올 수 있습니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 56) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e56.mp4"));
                textView2.setText("수공구 소개 및 사용법(공구-절단공구)");
                textView.setText("<수공구 소개>  \n" +
                        "\n" +
                        "- 망치 \n" +
                        "\n" +
                        "- 플라이어  \n" +
                        "\n" +
                        "- 펜치 \n" +
                        "\n" +
                        "- 바이스플라이어  \n" +
                        "\n" +
                        "- 압착플라이어 \n" +
                        "\n" +
                        "- 롱로즈플라이어 \n" +
                        "\n" +
                        "- 분리형 톱 \n" +
                        "\n" +
                        "- 드라이버 \n" +
                        "\n" +
                        "- 먹줄 ");
            } else if (index == 57) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e57.mp4"));
                textView2.setText("절단공구 소개 및 사용법-원형톱,직쏘우(공구-절단공구)");
                textView.setText("<직쏘>  \n" +
                        "\n" +
                        "- 철과 목재 모두 절단 \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        " <금속용톱날>  \n" +
                        "\n" +
                        "- 톱날표면에 용도가 적혀있습니다. \n" +
                        "\n" +
                        "- 부재의 두께에맞는 톱날은 선택합니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "<목재용톱날> \n" +
                        "\n" +
                        "- 제대로 결합됐는지 톱날을 흔들어 확인해주세요 \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "<원형톱> \n" +
                        "\n" +
                        "- 원형톱은 넓은 부자재를 자를때 주로 사용합니다. \n" +
                        "\n" +
                        "- 톱날의 방향과 부재가 맞물리면 킥백이 발생합니다. \n" +
                        "\n" +
                        "- 킥백의 발생하지 않도록 주의하세요 \n" +
                        "\n" +
                        "- 컷팅할 부재를 단단한 것으로 고정합니다 \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "- 가이드라인을 따라 갑니다 \n" +
                        "\n" +
                        "- 부재와떨어진 상태로 원형톱을 가동합니다. \n" +
                        "\n" +
                        "- 원형톱 바닥과 부재가 밀착된 상태로 작업합니다 \n" +
                        "\n" +
                        "- 원형톱과 몸의 적당히 떨어진 상태로 작업합니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "- 직쏘우의 바닥과 부재가 밀착된 상태로 작업합니다. \n" +
                        "\n" +
                        "- 직쏘우는 곡선부위 절단에 주로 사용합니다. \n" +
                        "\n" +
                        "- 톱날이 회전 할 수 있도록 여유 공간을 줍니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "- 금속용 톱날 결합 \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "- 철재를 바이스로 단단히 고정합니다 \n" +
                        "\n" +
                        "- 그라인더 보다는 직쏘우가 곡면절단에 용이합니다. \n" +
                        "\n" +
                        "- 자르고자 하는 부재를 꼭 단단하게 고정해주세요 ");
            } else if (index == 58) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e58.mp4"));
                textView2.setText("각도절단기 소개 및 실습(공구-절단공구)");
                textView.setText("<각도절단기> \n" +
                        "\n" +
                        "- 톱날의 사이즈에 따라 나누어집니다. \n" +
                        "\n" +
                        "- 10인치 각도절단기 \n" +
                        "\n" +
                        "- 12인치 각도절단기 \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "<톱날작동스위치> \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "<안전커버스위치> \n" +
                        "\n" +
                        "- 안전커버 스위치를 눌러야 움직일수 있씁니다. \n" +
                        "\n" +
                        "- 받침대 각도를 조절해 원하는 각도를 맞출수 있씁니다. \n" +
                        "\n" +
                        "- 절단기 머리를 좌우로 움직여 원하는 각도를 맞출수 있씁니다. \n" +
                        "\n" +
                        "- 받침대 벽에 자재를 끝까지 붙이고 작업합니다. \n" +
                        "\n" +
                        "- 절단기 머리를 들며 안전커버스위치를 놓습니다 \n" +
                        "\n" +
                        "- 안전커버만 제거한 상태로 톱날을 맞춰봅니다. \n" +
                        "\n" +
                        "- 톱날의 왼쪽에 가상선을 맞춥니다. \n" +
                        "\n" +
                        "- 톱을 먼저 작동시킨후 내려줍니다 \n" +
                        "\n" +
                        "- 반대편손을 회전원 바깥에 놓습니다. \n" +
                        "\n" +
                        "- 25도 각도절단 \n" +
                        "\n" +
                        "- 20도 각도절단 \n" +
                        "\n" +
                        " ");
            } else if (index == 59) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e59.mp4"));
                textView2.setText("테이블쏘우 소개 및 실습(공구-절단공구)");
                textView.setText("<테이블쏘우> \n" +
                        "\n" +
                        "- 테이블자 \n" +
                        "\n" +
                        "- 테이블 옆면과 톱날 안쪽의 길이를 측정합니다. \n" +
                        "\n" +
                        "- 100MM \n" +
                        "\n" +
                        "- 넓은 부재자르기는 테이블쏘우가 효율적 \n" +
                        "\n" +
                        "- 안전교육후에초보자들도 쉽게사용합수있습니다. ");
            } else if (index == 60) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e60.mp4"));
                textView2.setText("컷쏘우 소개 및 사용법(공구-절단공구)");
                textView.setText("<컷쏘우> \n" +
                        "\n" +
                        "- 충전식 배터리 타입의 제품도있습니다. \n" +
                        "\n" +
                        "- 세밀한 작업과 컷쏘우는 맞지 않습니다. \n" +
                        "\n" +
                        "- 컷쏘우는 재작업이나 철거작업에 주로 사용합니다. \n" +
                        "\n" +
                        "- 복합용 톱날 \n" +
                        "\n" +
                        "- 철재 용톱날 \n" +
                        "\n" +
                        "- 잠금 스위치를 열고 톱날을 끼워주세요 \n" +
                        "\n" +
                        "- 톱날을 앞과 뒤 좌와 우로 결합할 수 있습니다. \n" +
                        "\n" +
                        "- 다양한 작업 상황에 맞는 도구 사용이 가능합니다. \n" +
                        "\n" +
                        "- 톱날을 교체할 땐 반드시 전월플러그를 분리해주세요 \n" +
                        "\n" +
                        "- 부재와 컷쏘우를 밀착시킨 상태에서 작업합니다 \n" +
                        "\n" +
                        "- 톱날이 부재와 떨어진 상태는 정확한 작업이 어렵습니다 \n" +
                        "\n" +
                        "- 먼저 작업선을 긋습니다. \n" +
                        "\n" +
                        "- 톱날을 위아래로 번갈아 잘라냅니다.  \n" +
                        "\n" +
                        "- 부재와 컷쏘우가 떨어진 상태로 사용하면 위험합니다 \n" +
                        "\n" +
                        "- 컷쏘우와 부재를 항상 붙여서 사용하는 것을 잊지마세요 ");
            } else if (index == 61) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e61.mp4"));
                textView2.setText("그라인더 소개 및 사용법(공구-그라인더)");
                textView.setText("<그라인더 소개와 사용법> \n" +
                        "\n" +
                        "- 안전커버 제거 \n" +
                        "\n" +
                        "- 작업 시 안전커버가 걸릴 수 있습니다. \n" +
                        "\n" +
                        "- 안전커버 거 사용은 위험합니다 \n" +
                        "\n" +
                        "- 사고가 자주 일어나는 그라인더 \n" +
                        "\n" +
                        "- 안전 사고의 위험이 높습니다 \n" +
                        "\n" +
                        "- 유용한 만큼 위험한 그라인더 안전하게 사용하세요 ");
            } else if (index == 62) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e62.mp4"));
                textView2.setText("그라인더 결합품 소개(공구-그라인더)");
                textView.setText("<그라인더 결합품 소개> \n" +
                        "\n" +
                        "- 절단석 금속을 주로 자를떄 사용한다 \n" +
                        "\n" +
                        "- 연마석 절단부위를 깨끗하게 할 떄 주로 사용합니다. \n" +
                        "\n" +
                        "- 콘크리트를 자르거나 매끄럽게 할 때 사용합니다 \n" +
                        "\n" +
                        "- 콘크리트 절단석 \n" +
                        "\n" +
                        "- 홀컵 금속표면을 매끄럽게 해줄 때로 사용합니다 \n" +
                        "\n" +
                        "- 작업시 마스크를 착용하세요 \n" +
                        "\n" +
                        "- 목재연마석 금속 표면을 매끄럽게 해줄 떄도 사용한다 \n" +
                        "\n" +
                        "- 샌딩기 목재용 사포가 표면을 매끄럽게 마감해줍니다. \n" +
                        "\n" +
                        "- 원목을 가공할 때 주로 사용합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 63) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e63.mp4"));
                textView2.setText("그라인더 결합(공구-그라인더)");
                textView.setText("- 결합공구 결합공구가 있는지 꼭 확인하세요 \n" +
                        "\n" +
                        "- 그라인더 축 파워스위치 \n" +
                        "\n" +
                        "- 파워스위치 위치는 제품별로 다를 수 있습니다 \n" +
                        "\n" +
                        "- 손잡이 홀 손잡이가 함께 있는지 꼭 확인하세요 \n" +
                        "\n" +
                        "- 축잠금버튼 그라인더 축이 멈추는 부분이 있습니다 \n" +
                        "\n" +
                        "- 결합공구를 사용해 날을 분리해줍니다 \n" +
                        "\n" +
                        "- 분리 중에는 잠금버튼을 눌러줍니다 \n" +
                        "\n" +
                        "- 축에 결합된 부속품이 두 개 입니다. \n" +
                        "\n" +
                        "- 안쪽 부속품까지 날과 같이 빠질 위험이 있습니다. \n" +
                        "\n" +
                        "- 분리된 날고 부품이 결합돼 있는지 확인해주세요 \n" +
                        "\n" +
                        "- 고정핀 평면날에는 평평한 방향을 사용하세요 \n" +
                        "\n" +
                        "- 축 방향으로 튀어나온 반대쪽을 사용하세요 \n" +
                        "\n" +
                        "- 반대방향으로 결합할 경우 날이 분리 될 수 있습니다 \n" +
                        "\n" +
                        "- 축과 빈틈없이 연결된 날을 확인해주세요 \n" +
                        "\n" +
                        "- 마른날 타일을 자를떄 주로 사용합니다 \n" +
                        "\n" +
                        " ");
            } else if (index == 64) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e64.mp4"));
                textView2.setText("그라인더 실습(공구-그라인더)");
                textView.setText("<그라인더 사용실습>  \n" +
                        "\n" +
                        "- 항상 두손으로 잡는 것 잊지 마세요 \n" +
                        "\n" +
                        "- 연마작업  축과 자재의 충돌에 주의하세요 \n" +
                        "\n" +
                        "- 절단 작업  그라인더 날이 멈춘 후 제자리에 놓습니다 \n" +
                        "\n" +
                        "- 직선 절단시 사용합니다 \n" +
                        "\n" +
                        "- 콘센트와 플러그를 꼭 잡고 전기를 차단 하세여 \n" +
                        "\n" +
                        "- 전선의 접합 부분에서 주로 단선이 발생합니다 \n" +
                        "\n" +
                        "- 한손은 공구를 제어할수 있도록 꼭 잡아주세요 \n" +
                        "\n" +
                        "- 목재연마  \n" +
                        "\n" +
                        "- 사포연마 \n" +
                        "\n" +
                        "- 사고가 많이 나는 4인치 그라이더 사용되는 곳이 많은 4인치 그라인더 올바른 사용법을 잊지마세요 ");
            } else if (index == 65) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e65.mp4"));
                textView2.setText("에어공구 규격 별 종류와 소개(공구-에어공구)");
                textView.setText("<DT64타카> \n" +
                        "\n" +
                        "- 핀의 길이 64mm \n" +
                        "\n" +
                        "- 탄창을 열고 타카핀을 장착합니다. \n" +
                        "\n" +
                        "- 64mm보다 작은 핀은 사용 가능합니다. \n" +
                        "\n" +
                        "- 벽작업이나 구조재 작업 등 큰 힘이 필요할 때 사용합니다. \n" +
                        "\n" +
                        "- 합판이나 석고보드를 고정할 때 주로 사용합니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<422타카> \n" +
                        "\n" +
                        "- 폭 4mm 길이 22mm \n" +
                        "\n" +
                        "- 탄창에 핀을 넣기 전에 이물질을 꼭 제거해주세요. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<1022타카> \n" +
                        "\n" +
                        "- 폭 10mm 길이 22mm \n" +
                        "\n" +
                        "- 단열재 고정, 문 몰딩, 창틀 작업 등에 사용합니다. \n" +
                        "\n" +
                        "- 422타카보다 견고하게 고정시킬 수 있습니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<630타카> \n" +
                        "\n" +
                        "- 실내 몰딩작업과 가구 마무리 작업에 주로 사용합니다. \n" +
                        "\n" +
                        "- 굵기 0.6mm / 길이 18mm / 길이 25mm, 30mm \n" +
                        "\n" +
                        "- 삼각형 꼭지점이 나가는 쪽이 촉 부분을 나타냅니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<F30타카> \n" +
                        "\n" +
                        "- 길이 30mm \n" +
                        "\n" +
                        "- 루바작업, 문선몰딩작업, 목재작업에 주로 사용합니다. \n" +
                        "\n" +
                        "- 안전장치와 방아쇠 레버 두 개가 있습니다. \n" +
                        "\n" +
                        "- 안전장치를 당기고 방아쇠를 당겨야 작동합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 66) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e66.mp4"));
                textView2.setText("대형에어공구 소개(공구-에어공구)");
                textView.setText("<타카총> \n" +
                        "\n" +
                        "- 지붕작업과 아스팔트 슁글 작업에 주로 사용합니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<인슐레이션타카> \n" +
                        "\n" +
                        "- 건물 내외부의 단열재를 고정해주는 역할로 사용합니다. \n" +
                        "\n" +
                        "- 에어타카와 화스너를 이용해 단열재를 고정합니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<화스너> \n" +
                        "\n" +
                        "- 화스너의 길이만큼 단열재의 두께에 맞게 고정합니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<네일러건> \n" +
                        "\n" +
                        "- 목조구조재를 고정하는 역할로 사용합니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<스틱네일러못> ");
            } else if (index == 67) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e67.mp4"));
                textView2.setText("석고보드를 이용한 에어공구 사용(공구-에어공구)");
                textView.setText("- 벽이나 천장의 석고보드는 두 겹 이상으로 작업합니다. \n" +
                        "\n" +
                        "- 석고보드를 겹치게 세워둬야 튼튼하게 자리잡습니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 68) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e68.mp4"));
                textView2.setText("전동공구 및 결합 비트 소개(공구-체결공구)");
                textView.setText("<겸용드릴> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<타일용비트> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<콘크리트비트> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<목재용비트> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "- 메뉴휠에 해머와 드릴 기능이 있습니다. \n" +
                        "\n" +
                        "- 가정에서 쓰기에 충분한 전동공구입니다. \n" +
                        "\n" +
                        "- 정방향 회전으로 나사를 조입니다. \n" +
                        "\n" +
                        "- 역방향 회전으로 나사를 풀어줍니다. \n" +
                        "\n" +
                        "- 굵기와 길이에 따라 다양한 종류가 있습니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        " ");
            } else if (index == 69) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e69.mp4"));
                textView2.setText("전동 공구 실습(공구-체결공구)");
                textView.setText("- 역방향으로 회전시켜 입구를 열어줍니다. \n" +
                        "\n" +
                        "- 입구를 잡고 정방향으로 회전시키면서 잠가줍니다. \n" +
                        "\n" +
                        "- 부자재와 전동공구가 수직이 되도록 놓습니다. \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<임펙트드릴> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<드라이버 비트> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<목재용 나비기리비트> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "- 짧은 비트가 힘전달과 균형 잡기에 좋습니다. \n" +
                        "\n" +
                        "- 긴비트는 힘전달과 균형을 잡기가 어렵습니다. \n" +
                        "\n" +
                        "- 구멍을 낼 때는 나비기리비트가 적합합니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 70) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e70.mp4"));
                textView2.setText("전동드릴 석고보드 앵커결합(공구-체결공구)");
                textView.setText(" \n" +
                        "<75mm피스> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<토글> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<석고보드용 외날피스> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "- 지지구조가 있는 경우 안전하게 고정됩니다. \n" +
                        "\n" +
                        "- 지지구조 없이 석고보드에만 결합 시 불안정합니다. \n" +
                        "\n" +
                        "- 토글이 나사의 지지 역할을 해줍니다. \n" +
                        "\n" +
                        "- 외날피스가 나사의 지지 역할을 해줍니다. \n" +
                        "\n" +
                        " ");
            } else if (index == 71) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e71.mp4"));
                textView2.setText("햄머드릴 콘크리트 앵커 설치(공구-체결공구)");
                textView.setText("<드릴기능> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<햄머드릴기능> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "<9mm앵커> \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "  \n" +
                        "\n" +
                        "- 콘크리트 벽에 천공을 합니다. \n" +
                        "\n" +
                        "- 콘크리트 구멍을 청소해줍니다. \n" +
                        "\n" +
                        "- 앵커의 볼트를 구멍에 끼웁니다. \n" +
                        "\n" +
                        "- 전동휠로 회전수를 조절 할 수 있습니다. \n" +
                        "\n" +
                        "- 칼블록과 나사를 같이 넣습니다. ");
            }
        }


        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        /*
                         * add media controller
                         */
                        controller = new FullScreenMediaController(MovieActivity.this);
                        videoView.setMediaController(controller);
                        /*
                         * and set its position on screen
                         */
                        controller.setAnchorView(videoView);
                    }
                });
            }
        });

        //controller = new FullScreenMediaController(this);


        //controller.setAnchorView(videoView);

        //videoView.setMediaController(controller);
        videoView.requestFocus();
        videoView.seekTo(0);
        videoView.start();

        /*String[] list_menu = { "유익한 영상이네요!", "좋아요!", "굿~!" };

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list_menu);

        listView.setAdapter(adapter);*/
    }




    public class FullScreenMediaController extends MediaController {

        private ImageButton fullScreen;

        public FullScreenMediaController(Context context) {
            super(context);
        }

        @Override
        public void setAnchorView(View view) {

            super.setAnchorView(view);

            //image button for full screen to be added to media controller
            fullScreen = new ImageButton(super.getContext());

            FrameLayout.LayoutParams params =
                    new FrameLayout.LayoutParams(50, 50);
            /*FrameLayout.LayoutParams params =
                    new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT);*/
            params.gravity = Gravity.RIGHT;
            params.rightMargin = 50;
            params.topMargin = 55;
            addView(fullScreen, params);


            fullScreen.setImageResource(R.drawable.fullscreen);

            //add listener to image button to handle full screen and exit full screen events
            fullScreen.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (pandan == 0) {
                        nav_view.setVisibility(View.GONE);
                        scrollView.setVisibility(View.GONE);
                        linearLayout.setVisibility(View.GONE);

                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                        pandan++;
                    }
                    else {
                        nav_view.setVisibility(View.VISIBLE);
                        scrollView.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.VISIBLE);
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                        pandan--;
                    }
                }
            });
        }
    }
}
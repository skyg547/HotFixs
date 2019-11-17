package com.hotfix.toolguide;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.hotfix.Cumu.ReviewList;
import com.hotfix.Start.StartActivity;
import com.hotfix.Menual.ManualMainActivity;
import com.bufsrepair.R;
import com.hotfix.toolmaps.ToolMaps;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ToolExplain extends AppCompatActivity {

    ImageView imageView;
    TextView textViewTitle;
    TextView textViewSubscript;
    TextView textViewExplain;

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
                intent = new Intent(getApplicationContext(), ToolMaps.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.navigation_toolguide:
                intent = new Intent(getApplicationContext(), com.hotfix.toolguide.ToolList.class);
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
        setContentView(R.layout.tool_explain);
        ActionBar abar = getSupportActionBar();
        abar.hide();

        imageView = (ImageView) findViewById(R.id.imageView2);
        textViewTitle = (TextView) findViewById(R.id.textView2);
        textViewSubscript = (TextView) findViewById(R.id.textView3);
        textViewExplain = (TextView) findViewById(R.id.textView4);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/badal.ttf");
        textViewExplain.setTypeface(typeface);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_toolguide);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Intent intent = getIntent();

        String name = intent.getExtras().getString("name");
        int index = intent.getExtras().getInt("index");

        if (name.equals("tool")) {
            if (index == 0) {
                imageView.setImageResource(R.drawable.tool_hameer);
                textViewTitle.setText("망치");
                textViewSubscript.setText("물건을 부수거나 못을 박을 때 사용하는 도구");
                textViewExplain.setText(
                        "- 망치로 때리는 면과 망치가 닿는 면이 평행하도록 수직으로 타격한다. \n" +
                        "\n- 너무 강하거나 너무 약한 망치질은 하지 않는다.\n" +
                        "\n- 다른 공구를 타격하는 경우 타격을 받는 공구 표면 보다 직경이 약 3/8“ 큰 망치를 사용한다. \n" +
                        "\n- 항상 작업에 적합한 크기와 무게의 망치를 사용한다.\n" +
                        "\n- 망치로 다른 망치나 손도끼를 타격하지 않는다.\n" +
                        "\n- 손잡이가 느슨하거나 손상된 공구를 사용하여 타격하지 않는다.\n" +
                        "\n- 패인곳이 있거나 금이가고, 토막이 나거나 급격하거나 과도하게 닳은 타격 공구는 폐기한다.\n" +
                        "\n- 망치를 다시 갈아내거나, 용접하거나 열처리를 하지 않는다\n" +
                        "\n- 보안경이나 안면보호구를 착용한다.\n" +
                        "\n- 사용할 용도에 따라 망치를 선택한다. (잘못된 사용은 내리치는 표면을 깨지게 할 수 있으며, 심각한 부상을 초래할 수도 있다.)\n" +
                        "\n- 맞는 공구의 표면보다 약 2.54㎝(1인치) 더 큰 직경의 내리치는 표면을 한 망치를 선택한다.\n" +
                        "\n- 망치의 내리치는 표면이 맞는 표면에 평행하도록 망치를 수직으로 내리친다. 빗나가는 내리침을 항상 피하도록 한다.\n" +
                        "\n- 망치의 측면으로 내리치지 않는다.\n" +
                        "\n- 망치를 치기 전에 위와 아래를 살펴본다.\n" +
                        "\n- 내리칠 때는 물체를 주시한다.\n" +
                        "\n- 손목을 똑바로 하고 손잡이를 둘러싼 채로 망치를 쥔다.\n" +
                        "\n- 못을 박을 때는 못 끝쪽을 잡고 처음과 끝을 천천히 가격한다.\n" +
                        "\n- 손잡이가 헐겁거나 파손된 망치를 사용하지 않는다.\n" +
                        "\n- 금이가고, 부러지고, 쪼개지고, 모서리가 날카롭거나 망치머리에 헐겁게 끼워진 조잡한 손잡이는 사용하지 않는다.\n" +
                        "\n- 패인 곳, 이빠진 자리, 버섯모양으로 퍼진 형태, 또는 지나치게 마모된 망치머리는 사용하지 않는다.\n" +
                        "\n- 망치머리를 수리하고, 갈고, 용접하거나 열을 가하여 다시 모양을 다듬지 않는다.\n" +
                        "\n- 망치를 내리칠 때는 다른 망치를 사용하지 않는다.\n" +
                        "\n- 망치는 사용전에 쐐기가 잘 박혀 있는지, 자루는 튼튼한지 등을 점검하고 망치의 손잡이 끝부분을 맨손으로 잡고 작업한다.\n"+"\n"+"출처:스탠리 홈페이지");

            } else if (index == 1) {
                imageView.setImageResource(R.drawable.tool_driver);
                textViewTitle.setText("드라이버");
                textViewSubscript.setText("나사를 조이거나 풀 때 사용하는 도구");
                textViewExplain.setText(
                        "- 손에서 공구가 미끄러지지 않게 생크를 플랜지로 꼭 조이고, 생크와 직각인 손잡이를 선택한다.\n" +
                        "\n- 드라이버 손잡이를 청결하게 유지한다. (기름이 묻은 손잡이는 사고를 유발할 수 있다.)\n" +
                        "\n- 전기작업을 할 때는 절연손잡이로 된 드라이버를 사용한다.\n" +
                        "\n- 수공구는 처음과 끝에 과격한 힘을 주지말고 서서히 힘을 준다.\n" +
                        "\n- 작업물을 확실히 고정시킨 후 작업한다.\n" +
                        "\n- 안전된 자세를 확보한 후 작업한다.\n" +
                        "\n- 손이 잘 닿지 않고 불편한 곳에서 나사를 돌리기 시작할 때는 나사가 붙는 드라이버를 사용한다.\n" +
                        "\n- 일반적인 드라이버가 사용될 수 없는 좁은 지역에서는 오프셋 스크류 드라이버를 사용한다.\n" +
                        "\n- 손목을 더 곧게 할 수 있고, 더 큰 지레의 작용을 할 수 있는 권총형 손잡이일 것\n" +
                        "\n- 공구를 앞으로 밀 때 나사부가 회전하는 구조일 것\n" +
                        "\n- 돌리기 힘든 나사를 효율적으로 돌릴 수 있는 래칫 장치일 것\n" +
                        "\n- 드라이버의 끝은 완전한 직사각형 모양으로 되어 있어야 한다.\n" +
                        "\n- 둥글게 된 끝은 다듬고 가장자리가 일직선이 되도록 한다.\n" +
                        "\n- 드라이버의 형상을 그려 놓은 걸이나 구분된 칸에다 드라이버를 보관하여 사용할 때 알맞는 드라이버를 바로 선택할 수 있도록 한다.\n" +
                        "\n"+"출처 : http://blog.daum.net/_blog/BlogTypeView.do?blogid=0M65M&articleno=6236921&categoryId=684036&regdt=20190329143120");

            } else if (index == 2) {
                imageView.setImageResource(R.drawable.tool_chalklines);
                textViewTitle.setText("먹줄");
                textViewSubscript.setText("선을 그어주는 도구");
                textViewExplain.setText(
                        "- 기준점을 고정시키는 뾰족한 핀을 포인트에 꽂고 기준점을 잡습니다.\n" +
                        "\n- 반대편에서 먹통을 당겨 줄을팽팽하게 한후 작업면과 직각을 이루면서 먹줄을 튕겨 줍니다\n" +
                        "\n- 먹통이 마르면 라인의 그려지지 않으니 먹줄의 라인을 그릴수 있도록 잉크를 항상 채워줍니다.");
            } else if (index == 3) {
                imageView.setImageResource(R.drawable.tool_pench);
                textViewTitle.setText("펜치");
                textViewSubscript.setText("악력을 이용하여 물체를 잡거나 자르거나 하는 도구");
                textViewExplain.setText(
                        "- 보안경이나 안면보호구를 차용한다.\n" +
                        "\n- 수직 각도로 자른다. 옆에서 옆으로 흔들거나 자르는 모서리 반대쪽 앞뒤로 철사를 구부리지 않는다.\n" +
                        "\n- 손바닥이나 손가락이 물리는 것을 방지하기 위해 손잡이 사이에 충분한 공간이 있는 공구를 선택한다.\n" +
                        "\n- 손잡이 사이 간격이 6～9㎝(21/2 ～ 31/2)인 플라이어를 선택한다.\n" +
                        "\n- 플라이어는 밀지 않고 당긴다.\n" +
                        "\n- 플라이어가 특별한 목적으로 제조된 것이 아니라면 경화된 철사를 자르지 않는다.\n" +
                        "\n- 단단한 철사를 가벼운 펜치로 구부리지 않는다.(바늘코 플라이어의 끝을 큰 철사를 구부리는데 사용하면 손상될 수 있다. 더 튼튼한 공구를 사용한다.)\n" +
                        "\n- 플라이어를 망치로 사용해서는 안된다.\n" +
                        "\n- 더 큰 지레작용을 얻기 위해 손잡이의 길이를 연장시키지 않는다. 더 큰 플라이어나 볼트절단기를 사용한다.\n" +
                        "\n- 절연손잡이를 필요로 하는 작업에 완충용 스프링손잡이를 사용하지 않는다. (이것은 기본적으로 편안함을 위해서이며, 전기충격에 대한 보호는 하지 못한다.)\n" +
                        "\n- 너트와 볼트에 플라이어를 사용하지 않는다. 렌치를 사용한다\n" +"\n"+
                        "출처 : http://blog.daum.net/_blog/BlogTypeView.do?blogid=0M65M&articleno=6236921&categoryId=684036&regdt=20190329143120\n");
            } else if (index == 4) {
                imageView.setImageResource(R.drawable.tool_viseplier);
                textViewTitle.setText("바이스 플라이어");
                textViewSubscript.setText("물체에 크기에 맞게 볼트를 사용해 크기를 조절해 고정하는 도구");
                textViewExplain.setText(
                        "- 잡고있을 물체에 맞게 조절나사를 돌린다\n" +
                        "\n- 바이스플라이어의 입을 잡고있을 물체보다 약간 크게 입을 벌린다.\n" +
                        "\n- 입을 모재에 끼우고 손잡이를 조인다.\n" +
                        "\n- 느슨한 느낌이면 입을 열고 조절나사를 오른쪽으로 돌려 입을 오므린다\n" +
                        "\n- 입을 적게할수록 손잡이를 조이기 힘들다.\n" +
                        "\n- h 방향으로 눌러주면 풀린다.\n" +
                        "\n- 바이스플라이어에 파이프를 끼우고 손잡이를 길게하여 회전을 하면 쉽게풀린다.\n"+
                                "\n"+"http://www.77g.com/shopping/iframe_showBBS.asp?sno=189");
            } else if (index == 5) {
                imageView.setImageResource(R.drawable.tool_upchakplier);
                textViewTitle.setText("압착 플라이어");
                textViewSubscript.setText("전선 피복을 벗기는 용도로 사용하는 도구");
                textViewExplain.setText(
                        "- 작업을 시작하기 전에 작업 영역을 빠르게 조사하여 넘어져 넘어 질 수있는 장애물이 없는지 확인하는 것이 중요하다. \n" +
                        "\n- 손에 도구가 있으면 추락으로 인한 임박한 위험이 크게 증가합니다. \n" +
                        "\n- 시작하기 전에 작업 공간을 비우고 주변에있는 사람들도 자신이 작업하고 있음을 알도록하여 방해받지 말고 방해받지 않도록하십시오.\n" +
                        "\n- 밝은 곳에서 작업하여 사고로 인한 부상을 최소화 할 수 있어야합니다. \n" +
                        "\n- 교정 렌즈가 필요한 경우 작업 할 때 렌즈를 착용하십시오. \n" +
                        "\n- 머지 않아 도구로 작업해야한다면 무기력 한 약을 섭취하지 마십시오. \n" +
                        "\n- 알코올 소비를 피하여 안정성과 우수한 조정을 보장하십시오.\n" +
                        "\n- 어린이는 날카 롭거나 무거운 도구와기구가있는 작업장에서 멀리 떨어져 있어야합니다. \n" +
                        "\n- 아이들은 스스로 위험에 처할뿐만 아니라주의를 산만하게하여 사고의 가능성을 높일 수 있습니다.\n" +
                        "\n- 파편 입자로부터 눈을 보호하려면 압착 플라이어로 작업 할 때 항상 양질의 안전 안경을 착용하십시오. \n" +
                        "\n- 손에 흠집, 긁힘 및 굳은 살이 생기지 않도록 장갑을 착용하십시오.\n" +
                        "\n- 나사나 볼트를 돌리는 데 압착 플라이어를 사용하지 마십시오. \n" +
                        "\n- 렌치나 드라이버 대신 사용하지 마십시오. \n" +
                        "\n- 크림 핑 엔드 또는 핸들을 사용하여 단단한 표면에 부딪치지 마십시오. \n" +
                        "\n- 공구가 손상되고 부상을 입을 수 있습니다. 어떤 상황에서도 손상된 공구를 사용하지 마십시오. \n" +
                        "\n- 핸들에 금이 간 경우 다시 사용하기 전에 수리하거나 공구를 교체하십시오.\n" +
                        "\n- 압착 플라이어 세트를 사용할 때마다 해당 작업에 적합한 크기인지 확인하십시오. \n" +
                        "\n- 크고 딱딱한 물체 나 전선에 작은 펜치를 사용하면 공구가 영구적으로 손상 될 수 있습니다. \n" +
                        "\n- 더 큰 물체에 도구를 사용하거나 더 잘 제어하려면 도구를 어떤 식 으로든 변경하지 마십시오. 대신 사용하는 도구의 크기를 변경하십시오.\n" +
                        "\n- 비, 눈 및 과도한 열로부터 압착 플라이어를 보호하십시오. 이는 공구의 녹 및 변형과 같은 문제를 방지합니다. \n" +
                        "\n- 제공된 지침에 따라 압착 플라이어를 유지하고 윤활유와 사용 편의성을 높이기 위해 한 번에 기름칠을하십시오.\n" +
                        "\n"+"출처 https://www.doityourself.com/stry/7-safety-precautions-when-using-crimping-pliers");
            } else if (index == 6) {
                imageView.setImageResource(R.drawable.tool_longplirer);
                textViewTitle.setText("롱로즈 플라이어");
                textViewSubscript.setText("좁을 장소에서 잡을 때 사용하는 도구");
                textViewExplain.setText(
                        "- 가는 선을 절단하거나 굽힐 때 사용하는 공구로서 펜치에 비해 물림 부분이 길고 뾰족하게 생겨 주로 가벼운 전자기기 수리용으로 사용한다. \n" +
                        "\n- 작은 고리를 만들거나 좁은 부분의 부품을 집거나 구불릴 때 사용하기 편하다\n" +
                        "\n- 물림부, 날부  결합부, 손잡이의 구조로 되어 있으며 탄소 공구강이나 구조용 탄소강이 재료로 사용된다. 라디오 펜치라고도 불린다.\n" +
                        "\n- 절연제품은 전기가 통하지 않아 감전 사고를 겪을 위험이 없다. \n" +
                        "\n"+"출처 : http://www.cretec.kr/webzine/sub/search_view.jsp?wz=120&bid=9&col=&sw=&pg=1&num=184");
            } else if (index == 7) {
                imageView.setImageResource(R.drawable.tool_niper);
                textViewTitle.setText("니퍼");
                textViewSubscript.setText("전선을 자를거나 피복을 벗길 때 사용하는 도구");
                textViewExplain.setText(
                        "- 피복전선의 심선을 일부 드러내기 위해서 심선에 닿지 않도록 피복부를 잘라내거나 환강,철사,꼰실, 등 선재를 절단할 때 사용한다, \n" +
                        "\n- 지레의 원리를 응용해서 악력이 배로 늘어나 날에 가해지도록 되어있다.\n" +
                        "\n- 손잡이 방향에 직각으로 날이서있는 보통니퍼와 강력니퍼가 있다. \n" +
                        "\n- 니퍼는 좋은 제품을 사용하지 않으면 날이 금방 무뎌진다. \n" +
                                "\n"+"출처 : http://www.cretec.kr/webzine/sub/search_view.jsp?wz=120&bid=9&col=&sw=&pg=1&num=184");
            }
        } else if (name.equals("electtool")) {
            if (index == 0) {
                imageView.setImageResource(R.drawable.tool_drill);
                textViewTitle.setText("전동 드릴");
                textViewSubscript.setText("나사를 조이거나 풀 때 사용하는 도구");
                textViewExplain.setText(
                        "- 방아쇠버튼을 누르면 드릴이 회전을 한다.\n" +
                        "\n- 나사를 조이기도 하고 풀기때문에 양방향 회전이 가능하다 .\n" +
                        "\n- 사용하고자하는 목적에 맞게 시계방향, 반시계방향을 선택후 드릴 비트에 나사를 만후 작업면과 수직이 되게 눌러주면서 방아쇠 버튼을 누른다\n" +
                        "\n- 드릴의 척에 드릴 비트를 꼽아주고 사용을 한다. 이때 드릴 척을 열기위해 척키라는 키가 필요하다.\n" +
                        "\n- 드릴 작업시에는 머리카락을 늘어뜨리거나 헐렁한 옷을 입어 옷소매가 늘어진 채로 작업하지 않도록 해야 한다. \n" +
                        "\n- 회전하는 전동공구인 드릴에 옷이나 머리카락이 말려 들어가는 위험에 빠질 수 있기 때문이다. 또 장갑을 끼는 것도 위험한테, 장갑의 올이 드릴에 감겨 돌아갈 수 있다.\n" +
                        "\n- 시동 전에 드릴비트가 올바르게 고정되어 있는지 확인한다. 비트가 헐겁게 장착돼 있을 경우 작업도중 분리 될 수 있다.\n" +
                        "\n- 드릴을 끼운 후에는 척 렌치(chunk wrench : chuck wrench(chunck key)로 드릴비트를 척에 세팅할 때 조여주는 도구)를 빼도록 한다.\n" +
                        "\n- 드릴 회전 중에는 작업물 잔해를 입으로 불거나 손으로 털지 않도록 한다.\n" +
                        "\n- 특히, 잔해가 날리기 쉬운 작업일 때에는 방진안경을 쓰도록 한다. 드릴로 천공 및 타격을 하다보면 그 작업 대상인 콘크리트나 금속, 나무 등의 잔해가 작업자 쪽으로 튀게 될 위험이 있는데 눈에 들어가지 않도록 각별한 주위가 필요하다. 안전모는 기본이라 할 수 있고 작업용 귀마개로 귀를 보호하도록 하는 것도 꼭 필요한 부분이다.\n" +
                        "\n- 드릴로 구멍을 뚫을 때, 끝까지 뚫린 것을 확인하기 위하여 밑바닥을 손으로 만져 보지 않도록 한다. 드릴이 회전하고 있는 상태에서 손에 회전 날이 닿으면 큰 상처를 입게 된다.\n" +
                        "\n- 전기 드릴을 사용할 때에는 반드시 접지 시킨다. 전동기구 사용시의 가장 빈번한 사고는 바로 감전이라는 부분인데 여러 상황에 대해 철저히 대비하는 것이 일상화 되어야 한다.\n" +
                                "\n"+"출처: http://www.toolcaps.com/customer/download_view.asp?order=list&code=17&seq=8&faq_id=1&page=1");
            } else if (index == 1) {
                imageView.setImageResource(R.drawable.tool_drill2);
                textViewTitle.setText("햄머 드릴");
                textViewSubscript.setText("구멍을 뚥거나 뿌실 때 사용하는 도구");
                textViewExplain.setText(
                        "- 안전한 옷을 입고 보안경을 쓰자. 헐렁한 옷이나 치렁치렁한 액세서리는 금물이다. 아주 간단한 작업이 아니라면, 보안경이나 고글을 착용하는 것도 권한다. 드릴링 파편에 맞아 눈을 다칠 수 있다.\n" +
                        "\n- 드릴을 자주 쓴다면 귀마개도 하자. 한두번은 괜찮지만 드릴을 자주 사용하는 일을 한다면 반드시 청력보호장치를 착용한다. 일반적인 전동드릴의 소음도는 약 90dB이며,  임팩트드릴이나 해머드릴의 경우 100dB이 넘기도 한다. 이같은 소음에 장기간 노출되면 청각에 손상을 줄 수 있다. 비교적 조용한 편인 무선 제품이라면 귀마개를 쓰지 않아도 된다.\n" +
                        "\n- 먼지가 많이 난다면 방진마스크를 쓰자. 드릴링에서 먼지가 많이 난다면 방진마스크를 착용하는 것이 좋다. 단, 방진마스크는 단기간 사용하기 적합하다. 장시간 정기적으로 드릴 작업을 한다거나, 드릴링 재료가 호흡기에 위험이 될 우려가 있면 보다 강화된 호흡기보호구를 착용해야 한다.\n" +
                        "\n- 재료에 맞는 드릴 비트를 선택하자. 재료에 적합하지 않은 비트를 사용하면 비트나 재료가 손상될 수 있다. 대부분 나무의 경우 범용 비트를 사용할 수 있지만 벽돌, 금속, 도자기, 유리 등 재료에 따라 사용해야 하는 비트가 달라진다.\n" +
                        "\n 금속 : HSS, 티타늄 코팅, 코발트 합금, 스텝 비트, HSS 홀 쏘\n" +
                        " 목재 : 플랫 비트, Lip and spur, 오거 비트, 홀 쏘, 스텝 비트, HSS 비트\n" +
                        " 플라스틱 : Lip and spur, 홀 쏘, HSS, 스텝 비트\n" +
                        " 석조 : 벽돌 비트, 다이어몬드 코어 비트\n" +
                        " 유리/타일 : 스페어헤드, 다이아몬드 코팅 비트\n" +
                        "\n 출처 : 덴가든(dengarden)\n\n" +
                        "- 비트를 척에 단단히 고정하자. 드릴 비트를 교체할 때는 드릴 전원이 꺼져있는지 확인한 뒤, 척(비트를 고정하는 부품)을 돌려서 푼다. 그런 다음 새로운 비트를 척에 넣고 조이면 된다. 제품에 따라 드릴 척 키를 사용해야 할 수도 있다\n" +
                        "\n- 클램프를 사용하면 두 손이 자유롭다. 드릴링할 곳의 면적이 좁고, 소재가 무른 편이라면 클램프를 이용해 재료를 단단하게 고정하는 것이 좋다. 클램프를 사용하면 양손으로 드릴을 제어할 수 있어 편리하다.\n" +
                        "\n- 코드를 조심히 다루자. 유선 전동드릴은 코드를 주의해서 관리해야 한다. 플러그를 꽂은 채 드릴을 방치해두면 지나가던 사람이 코드에 다리가 걸려 넘어질 수 있다. 사용하지 않을 때는 플러그를 빼 구석에 두거나, 작업장에 전원 코드를 매달 수 있는 자리를 마련하는 것이 좋다. 드릴을 들 때는 코드로 들어올리지 말고 반드시 본체를 잡아 들어올려야 한다.\n" +
                        "\n"+"출처 : http://i-db.co.kr/2017/10/%EC%A0%84%EB%8F%99%EB%93%9C%EB%A6%B4%EC%9D%84-%EC%93%B0%EA%B8%B0-%EC%A0%84-%EC%A3%BC%EC%9D%98%ED%95%B4%EC%95%BC-%ED%95%A0-7%EA%B0%80%EC%A7%80/");
            }
        } else if (name.equals("airtool")) {
            if (index == 0) {
                imageView.setImageResource(R.drawable.tool_dt64tackers);
                textViewTitle.setText("Dt64타카");
                textViewSubscript.setText("벽작업이나 구조재 작업을 할 때 사용하는 도구");
                textViewExplain.setText(
                        "- 목공용 타카2배크기, 무게는 약 2.6kg이다.\n" +
                        "\n- 사용하기 전 1회 타카 전용오일 1~2방울 정도 에어를 연결하는 부위에 넣어준다.\n" +
                        "\n- 오일은 고장 예방과 수명을 연장한다.\n" +
                        "\n- 탄창을 열 때에는 버튼 부분을 눌러서 잡아 당기시면 탄창이 열린다.\n" +
                        "\n- 배기구는 얼굴의 보이는 반대반향으로 공기가 배출되도록 해준다.\n" +
                        "\n- 핀을 장착할 때는 반드시 핀을 제일 왼편으로 밀착시켜 장착한다.\n" +
                        "\n- 자재에 최대한 밀착시켜 안정장치가 눌리도록 하신후에 방아쇠를 당긴다.\n" +
                        "\n- 항상 직각으로 세워서 발사 하는것이 안전하다.\n" +
                        "\n"+"출처 : blog.naver.com/postview.nhn?blogld=reanimation&logno=110155034141");
            } else if (index == 1) {
                imageView.setImageResource(R.drawable.tool_tacker422s);
                textViewTitle.setText("422타카");
                textViewSubscript.setText("석고보드나 벽자재를 고정할 때 사용하는 도구");
                textViewExplain.setText(
                        "- 에어 콤프레셔를 준비한다.\n" +
                        "\n- 사용하기 전 1회 타카 전용오일 1~2방울 정도 에어를 연결하는 부위에 넣어준다.\n" +
                        "\n- 오일은 고장 예방과 수명을 연장한다.\n" +
                        "\n- 탄창을 열 때에는 버튼 부분을 눌러서 잡아 당기시면 탄창이 열린다.\n" +
                        "\n- 배기구는 얼굴의 보이는 반대반향으로 공기가 배출되도록 해준다.\n" +
                        "\n- 목재에도 사용가능하며 콘트리트에도 사용 가능하다.\n" +
                        "\n- 핀을 장착할 때는 반드시 핀을 제일 왼편으로 밀착시켜 장착한다.\n" +
                        "\n- 자재에 최대한 밀착시켜 안정장치가 눌리도록 하신후에 방아쇠를 당긴다.\n" +
                        "\n- 항상 직각으로 세워서 발사 하는것이 안전하다.\n" +
                        "\n"+"출처 : blog.naver.com/postview.nhn?blogld=reanimation&logno=110155034141");
            }else if (index == 2) {
                imageView.setImageResource(R.drawable.tool_tacker1022s);
                textViewTitle.setText("1022타카");
                textViewSubscript.setText("단열재 고정 문몰딩 창틀 작업에 사용하는 도구");
                textViewExplain.setText(
                        "- 에어 콤프레셔를 준비한다.\n" +
                        "\n- 사용하기 전 1회 타카 전용오일 1~2방울 정도 에어를 연결하는 부위에 넣어준다.\n" +
                        "\n- 오일은 고장 예방과 수명을 연장한다.\n" +
                        "\n- 탄창을 열 때에는 버튼 부분을 눌러서 잡아 당기시면 탄창이 열린다.\n" +
                        "\n- 배기구는 얼굴의 보이는 반대반향으로 공기가 배출되도록 해준다.\n" +
                        "\n- 자재에 최대한 밀착시켜 안정장치가 눌리도록 하신후에 방아쇠를 당긴다.\n" +
                        "\n- 항상 직각으로 세워서 발사 하는것이 안전하다.\n" +
                        "\n- 압축공기 외 산소, 아세틸렌 가스 등을 사용시 폭파하여 사망할 수 있다.\n" +
                        "\n"+"출처 https://blog.naver.com/mong_de/220297867697, blog.naver.com/postview.nhn?blogld=reanimation&logno=110155034141");
            }else if (index == 3) {
                imageView.setImageResource(R.drawable.tool_tacke630s);
                textViewTitle.setText("630타카");
                textViewSubscript.setText("실내 몰딩작업과 마무리 작업을 사용하는 도구");
                textViewExplain.setText(
                        "- 에어 콤프레셔를 준비한다.\n" +
                        "\n- 타카핀이 매우 가늘다.\n" +
                        "\n- 타카핀 박힌 자국의 거의 안보인다.\n" +
                        "\n- 마무리 작업용으로 사용한다.\n" +
                        "\n- 사용하기 전 1회 타카 전용오일 1~2방울 정도 에어를 연결하는 부위에 넣어준다\n" +
                        "\n- 오일은 고장 예방과 수명을 연장한다.\n" +
                        "\n- 안정장치 제거하지 말고 제낀 후 사용한다\n" +
                        "\n- 탄창을 열 때에는 버튼 부분을 눌러서 잡아 당기시면 탄창이 열린다\n" +
                        "\n- 배기구는 얼굴의 보이는 반대반향으로 공기가 배출되도록 해준다.\n" +
                        "\n- 핀을 장착할때 더 들어갈수 없게 밀착시킨다.\n" +
                        "\n- 뾰족한 부분이 타카 입구에 들어가게 넣는다.\n" +
                        "\n- 타카 입구를 자재와 최대한 밀착시킨 다음에 방아쇠를 누른다.\n" +
                        "\n- 자재에 최대한 밀착시켜 안정장치가 눌리도록 하신후에 방아쇠를 당긴다.\n" +
                        "\n- 항상 직각으로 세워서 발사 하는것이 안전하다.\n" +
                        "\n"+"출처 : blog.naver.com/postview.nhn?blogld=reanimation&logno=110155034141\n");
            }else if (index == 4) {
                imageView.setImageResource(R.drawable.tool_f30tackers);
                textViewTitle.setText("F30타카");
                textViewSubscript.setText("루바작업 문선몰딩 목재작업에 주로 사용하는 도구");
                textViewExplain.setText(
                        "- 에어 콤프레셔를 준비한다\n" +
                        "\n- 사용하기 전 1회 타카 전용오일 1~2방울 정도 에어를 연결하는 부위에 넣어준다\n" +
                        "\n- 오일은 고장 예방과 수명을 연장한다\n" +
                        "\n- 탄창을 열 때에는 버튼 부분을 눌러서 잡아 당기시면 탄창이 열린다.\n" +
                        "\n- 배기구는 얼굴의 보이는 반대반향으로 공기가 배출되도록 해준다.\n" +
                        "\n- 핀을 장착할 때는 반드시 핀을 제일 왼편으로 밀착시켜 장착한다.\n" +
                        "\n- 자재에 최대한 밀착시켜 안정장치가 눌리도록 한 후에 방아쇠를 당긴다.\n" +
                        "\n- 항상 직각으로 세워서 발사 하는것이 안전하다.\n" +
                        "\n"+"출처 : blog.naver.com/postview.nhn?blogld=reanimation&logno=110155034141");
            }else if (index == 5) {
                imageView.setImageResource(R.drawable.tool_tackerguns);
                textViewTitle.setText("타카 총");
                textViewSubscript.setText("지붕작업과 아스팔트 싱글을 사용할떄 도구");
                textViewExplain.setText(
                        "- 스테이플을 앞쪽으로 밀지 않으면 푸셔를 다시 삽입 할 때 스테이플이 끼일 수 있습니다.\n" +
                        "\n- 일부 스테이플러를 사용하면로드를 밀 때 약간의 긴장감을 느낄 수 있습니다. 이것은 스테이플러에 닿는로드의 스프링에서 비롯됩니다. 로드가 제자리에 걸릴 때까지 계속 밀어 넣으십시오.\n" +
                        "\n- 총에 방아쇠 안전 장치가 없을 수 있습니다. 이 경우 스테이플을 넣을 때주의하십시오. 건이 분리되어있는 한 안전해야합니다.\n" +
                        "\n- 아직 스테이플러를 올리지 않은 경우 스테이플러를 옆으로 눕히거나 거꾸로 잡고 스테이플을 건에로드해야합니다.\n" +
                        "\n- 스테이플러에 브래드 손톱을 넣는 방법에 대한 표시가 없으면 스테이플러가 못을 발사하지 못할 수 있습니다. 스테이플러가 브래드 네일과 호환되는지 확인하려면 설명서를 확인하거나 온라인으로 검색하십시오.\n" +
                        "\n- 딸깍 소리가 들리지 않으면 잡지를 잡아 당겨 다시 밀어 넣으십시오.\n" +
                        "\n"+"출처 https://m.wikihow.com/Load-a-Staple-Gun\n");
            }else if (index == 6) {
                imageView.setImageResource(R.drawable.tool_intackers);
                textViewTitle.setText("인슐레이션타카");
                textViewSubscript.setText("건물 내외부의 단열재를 할 때 사용하는 도구");
                textViewExplain.setText(
                        "- 해머 테이커를 사용하기 전에 도구의 한계를 알고 있어야합니다. 일부 유형의 헤비 듀티 해머 tacker는 합판 또는 얇은 판금을 통해 스테이플을 구동 할 수 있지만, 이 문제에서는이 도구를 사용하지 않는 것이 좋습니다. 망치 조각을 사용하여 한 조각의 나무를 다른 조각에 부착해서는 안됩니다. 해머 택커는 부드러운 유형의 건축 자재를 통해 스테이플을 목재에 빠르게 삽입하도록 설계되었습니다. 해머 택커는 펠트 페이퍼, 단열재 또는 카펫 등의 재료를 설치하는 데 가장 적합합니다. 매우 단단한 재료를 부착하기 위해 망치 촉수를 사용하기로 선택한 경우 공구가 오래 지속되지 않거나 예상대로 작동하지 않는 경우 놀라지 마십시오.\n" +
                        "\n- 해머 택터를 사용하기 전에 스테이플이 눈에 다시 튀어 나오는 경우를 대비하여 항상 안전 고글을 착용하고 있는지 확인하십시오. 또한 스테이플 링 할 재료를 놓기 위해 자유 손을 사용하려는 경우 안전 장갑을 착용하는 것이 좋습니다. 규칙적인 망치로 손가락이나 엄지 손가락을 쳤다면 손등의 스테이플이 어떻게 느껴질 지 상상해보십시오.\n" +
                        "\n- 망치 촉수로 프로젝트를 시작하기 전에 작업에 적합한 크기 스테이플을 선택하십시오. 대부분의 해머 태커를 사용하면 8mm에서 10mm 사이의 스테이플을 삽입 할 수 있습니다. 스테이플 크기를 선택할 때는 항상 설치하려는 재료를 적절히 고정 할 수있는 가장 짧은 스테이플을 선택해야합니다. 예를 들어, 지붕 펠트 용지를 설치하려는 경우 긴 9/16 인치 스테이플을 사용할 필요가 없습니다. 대부분의 경우 3/16 인치 스테이플은 잘 작동하며 비용도 훨씬 적게 듭니다.\n" +
                        "\n- 사용하기에 가장 적합한 스테이플 크기를 결정한 후에는 매거진 스프링을 풀고 스테이플이 있는 해머 테이커 클립을 넣으십시오.\n" +
                        "\n- 다른 손으로 망치 촉수로 스테이플을 삽입 할 준비를 하는 동안 자유 손으로 스테이플하려는 재료를 배치하십시오.\n" +
                        "\n- 일반 해머를 사용하는 것과 마찬가지로 스테이플을 삽입 할 위치를 겨냥하고 올바른 지점에서 재료를 타격해야합니다. 재료 표면에 부딪 칠 때 망치 tacker의 머리를 똑바로 유지하십시오. 몇 번의 스윙 후, 당신은 그것의 걸림돌을 얻은 다음 스테이플을 재료에 성공적으로 몰아 넣을 수 있습니다.\n" +
                        "\n- 전선 주위에서 작업하는 경우 항상 전기적으로 절연 된 손잡이가있는 망치를 사용해야합니다. 이렇게하면 눈에 띄게 누워있을 수있는 노출 된 배선으로부터 안전하게 보호 할 수 있습니다.\n" +
                        "\n- 해머 테이커를 사용할 때는 항상 동료 작업자와 충분한 간격을 유지하십시오. 이를 통해 주변 사람들에게 의도하지 않은 부상을 예방할 수 있습니다.\n" +
                        "\n"+"출처 https://www.doityourself.com/stry/9-hammer-tacker-safety-tips-to-remember ");
            }else if (index == 7) {
                imageView.setImageResource(R.drawable.tool_nailguns);
                textViewTitle.setText("네일러 건");
                textViewSubscript.setText("목조구조재를 고정하는 역하로 사용하는 도구");
                textViewExplain.setText(
                        "- 손톱이 표면에 부딪히면 파편이 날아갈 수 있습니다. 자신을 보호하기 위해 안면 마스크와 안전 고글을 착용해야합니다. 보호 덮개로 귀를 보호하십시오. 두꺼운 장갑과 튼튼한 부츠를 착용하십시오. 깨끗하고 미끄러짐이 없고 조명이 밝은 곳에서 작업하십시오.\n" +
                        "\n- 네일 건은 간단한 도구이지만 조심스럽게 다루어야합니다. 손톱이 잘못 타여 매년 수백 명의 노동자들이 부상을 당합니다. 필요한 안전 표준에 맞는 도구 만 구입하십시오. 공구를 사용하기 전에 사용 설명서를 자세히 읽고 공구의 안전 기능 및 기본 부분을 숙지하십시오. 어떤 식 으로든 공구를 개조하지 마십시오.\n" +
                        "\n- 건축 자재에 못 총을 발사하면 못이 때때로 그 재질을 뚫고 다른 쪽 사람을 때릴 수 있습니다. 안전하다는 것을 확인하지 않고 은폐 된 표면에 못총을 발사하지 마십시오. 시작하려고 할 때 동료에게 알립니다.\n" +
                        "\n- 네일 건을 몸에 대지 마십시오. 실수로 트리거하면 손톱이 날아가 심각한 부상을 입을 수 있습니다. 사다리를 올라갈 때는 못총을 분리하여 몸에서 멀리 떨어 뜨려 놓으십시오. 네일 건을 운반 할 때 방아쇠를 만지지 마십시오. 공구를 운반하기 전에 전원이 꺼져 있고 플러그가 뽑혀 있고 안전 장치가 제자리에 있는지 확인하십시오.\n" +
                        "\n- 네일 건으로 작업 할 때는 대화와 다른 방해 요소를 피하십시오. 공구가 작동 중일 때는 절대로 돌리지 마십시오. 불의 손이 닿지 않는 곳에 손을 자유롭게 두십시오.\n" +
                        "\n- 청소 또는 일상적인 유지 관리를 수행하려면 먼저 네일 건을 끄고 분리하십시오. 빛이 많은 깨끗하고 깔끔한 곳으로 가져 가십시오. 녹이없는 깨끗한 손톱 만 사용하십시오.\n" +
                        "\n- 가연성 물질 근처에서 전동 공구를 사용하는 것은 매우 위험합니다. 이 도구는 화재를 일으킬 수있는 스파크를 발산 할 수 있습니다.\n" +
                        "\n- 일부 못질 표면은 전선이나 가스관을 숨길 수 있습니다. 모든 표면에서 네일 건을 발사하기 전에 안전하게 건을 발사해야합니다.\n" +
                        "\n- 네일 건을 발사 할 때 줄을 움직이면 가장자리에서 시작하여 안쪽으로 이동하십시오. 이런 식으로 낙상을 피할 수 있습니다.\n" +
                        "\n- 네일 건을 발사 할 때 뒤로 걸어 가지 마십시오. 뒤쪽에서 시작하여 대신 앞으로 이동하십시오.\n" +
                        "\n- 못 총을 사용하도록 훈련받지 않은 사람들로부터 멀리 떨어 뜨려 놓으십시오. 다른 도구와 함께 건조한 곳에 안전하게 보관하십시오.\n" +
                        "\n"+"출처:https://www.doityourself.com/stry/10-safety-tips-when-using-a-nail-gun");
            }
        } else if (name.equals("cuttool")) {
            if (index == 0) {
                imageView.setImageResource(R.drawable.tool_saw);
                textViewTitle.setText("분리형 톱");
                textViewSubscript.setText("나무를 자를 때 사용하는 도구");
                textViewExplain.setText(
                        "- 보안경이나 안면보호구를 착용한다.\n" +
                        "\n- 사용되는 목재에 적절한 형태와 크기의 손톱을 선택한다.\n" +
                        "\n- 수평판에 대해 손목이 자연스런 위치에 놓일 수 있게 하는 톱 손잡이를 선택한다.\n" +
                        "\n- 적어도 12㎝길이에 6㎝의 넓이, 그리고 15˚로 기울어진 손잡이 구멍이 있는 손톱을 선택한다.\n" +
                        "\n- 잘리는 나무에 못, 마디 또는 손톱을 손상시키거나 휘어지게 하는 이물질이 없는지 확인한다.\n" +
                        "\n- 엄지를 세운 채 칼날의 반대쪽으로 압력을 주고 있는 손을 나무의 잘리는 선 표시 옆에 놓고 나무를 베기 시작한다. 날이 튀는 것을 방지하기 위해 신중하고 천천히 베기 시작한다. 날이 물릴 때까지 위로 당긴다. 부분 적으로 베기 시작한 후 톱을 적절한 각도로 고정시킨다.\n" +
                        "\n- 톱을 절삭할 때만 압력을 가한다.\n" +
                        "\n- 잘리는 나무가 흔들리지 않도록 확실히 잡는다.\n" +
                        "\n- 필요하면 긴 나무를 받쳐줄 보조작업자, 보조의자나 바이스를 사용한다.\n" +
                        "\n- 이빨과 날을 적절하게 고정시킨 채로 유지한다.\n" +
                        "\n- 사용하지 않을 때는 톱날을 보호한다.\n" +
                        "\n- 톱날을 청결하게 유지한다.\n" +
                        "\n"+"출처 : http://blog.daum.net/_blog/BlogTypeView.do?blogid=0M65M&articleno=6236921&categoryId=684036&regdt=20190329143120");
            } else if (index == 1) {
                imageView.setImageResource(R.drawable.tool_circlesaw);
                textViewTitle.setText("원형 톱");
                textViewSubscript.setText("넓은 부자재를 자를 때 사용하는 도구");
                textViewExplain.setText(
                        "- 작업하기 전 원형 톱날과 원형톱의 상태를 확인해야 한다.\n" +
                        "\n- 전원을 차단한 상태에서 원형 톱날을 교체해야 한다.\n" +
                        "\n- 작업할 때는 반드시 보안경, 귀마개, 마스크 착용해야 한다. \n" +
                        "\n- 동작시키기 전 톱날의 깊이를 조정해야 한다.\n" +
                        "\n- 잘려 나가는 부분이 짧을 때는 자연스럽게 떨어지게 둬야 한다.\n" +
                        "\n- 원형톱으로 길게 켤 때는 잘 받쳐야 한다.\n" +
                        "\n- 길게 켤 때는 반드시 직선 가이드를 사용해야 한다.\n" +
                        "\n- 전기선이나 집진 호스가 걸리지 않도록 주의해야 한다.\n" +
                        "\n- 톱날의 회전이 멈춘 다음, 원형톱을 내려 놓아야 한다.\n" +
                        "\n"+"출처 : http://btsweet.blogspot.com/2015/06/circular-saw-safety.htm");
            } else if (index == 2) {
                imageView.setImageResource(R.drawable.tool_grrinder);
                textViewTitle.setText("그라인더");
                textViewSubscript.setText("여러 가지 자재를 자르거나 절단 부위를 가공 할 때 사용하는 도구");
                textViewExplain.setText(
                        "- 지정 용도 이외에는 사용을 금한다.\n" +
                        "\n- 비가 올 때, 습한 장소 등에서는 작업을 금한다.\n" +
                        "\n- 전원에 누전차단기가 설치되어 있는 인화성 물질이 있는 장소에서는 사용을 금한다.\n" +
                        "\n- 화재의 위험이 있는 인화성 물질이 있는 장소에서는 사용을 금한다.\n" +
                        "\n- 모터의 통풍구는 언제나 열어둔다.\n" +
                        "\n- 작업 중에는 반드시 보안경 및 방진마스크를 착용한다.\n" +
                        "\n- 사용 후에는 콘센트에서 플러그를 제거한다.\n" +
                        "\n- 코드를 쥐고 제품 이동시는 절연 파손의 위험이 있으므로 조심스럽게 취급한다.\n" +
                        "\n- 방호덮개는 반드시 부착시킨 채로 사용한다.\n" +
                        "\n- 연마석은 해당 사용면만 사용하고 측면과 상면을 사용하지 않는다.\n" +
                        "\n- 무리한 힘을 가하면 회전수가 저하하고 과부하와 모터 소손 위험이 있다.\n" +
                        "\n- 연삭 숫돌을 회전시킨 채로 방치하지 않는다.\n" +
                        "\n"+"출처 http://blog.naver.com/PostView.nhn?blogId=jekalwon&logNo=220097409170&parentCategoryNo=&categoryNo=178&viewDate=&isShowPopularPosts=false&from=postView\n");
            } else if (index == 3) {
                imageView.setImageResource(R.drawable.tool_jiksaw);
                textViewTitle.setText("직쏘우");
                textViewSubscript.setText("철이나 목재를 자를 때 사용하는 도구");
                textViewExplain.setText(
                        "- 직쏘를 선택할 때는 소비 전력과 최대 절단 능력을 확인하는 것이 좋다. 일반적으로 전동 공구 작업을 할 때는 소재가 두껍거나 다루기 힘들 경우 소비 전력이 많이 소요된다. 직쏘는 4~500W부터 작업용 18V까지 다양한 편이다.\n" +
                        "\n- 작업 종류에 따라 절단할 수 있는 두께가 차이가 있으므로 각각의 소재 별로 최대 절단 능력을 확인하는 것이 좋다.\n" +
                        "\n- 직쏘는 톱날을 이용하는 작업이니만큼 안전에 특히 유의해야한다. 작업을 할 때는 안전 장비를 갖추고 하는 것이 좋다.\n" +
                        "\n- 작업 시 발생하는 먼지 및 남은 톱밥을 방지하기 위해 고글 및 마스크를 착용한다.\n" +
                        "\n- 목재, 금속 등을 작업대 위에 올려둔 다음 반드시 고정할 수 있는 장치를 구비해두자.\n" +
                        "\n- 추출 봉투가 있다면, 직쏘에 연결시켜 먼지 등을 수집할 수 있도록 한다.\n" +
                                "\n"+"출처 http://idb.imarket.co.kr/content/detail?contNo=100000010684");
            } else if (index == 4) {
                imageView.setImageResource(R.drawable.tool_tablesaw);
                textViewTitle.setText("테이블쏘우");
                textViewSubscript.setText("넓은 자재를 자를 때 사용하는 도구");
                textViewExplain.setText(
                        "- 주로 켜기용으로 사용된다.( 지그를 이용하여 자르기용으로도 사용한다.)\n" +
                        "\n- 두꺼운 부재를 켤 때는 한번에 켜려 하지 말고,  여러번에 걸쳐 나눠 켠다. 그래도 자르지 못하면 밴드쏘우로 자른 후 수압대패로 면을 맞추고 자동대패로 두께를 조정한다. 여기에서 톱날의 두께와 밴드쏘우로 자르고 난후 수압대패에서 깎이는 두께를 감안하여 치수를 마름질해야 한다.\n" +
                        "\n- 나무를 켤때는 부재를 끝까지 밀어내야 한다. 그렇지 않으면 날에 부재가 끼여 뒤로 날아 가는 퀵백현상이 나타나 뒤에 있는 사람이나 본인이 다칠 수 있다.\n" +
                        "\n- 조깃대에 닿는 면적이 작은 부재는 지그를 이용하거나 슬라이딩 테이블 쏘우로 자르기를 권한다.\n" +
                        "\n- 부재의 길이가 30cm이하의 부재는 안전을 위해 사용하지 말아야 한다.\n" +
                        "\n- 날의 높이를 높여 두번째 켤때는 본인에게 톱밥이 많이 배출되므로,  보안경과 마스크를 착용하는 것이 좋다.\n" +
                        "\n"+"출처 https://blog.naver.com/jsw5383/90194992637\n");
            } else if (index == 5) {
                imageView.setImageResource(R.drawable.tool_cutsaws);
                textViewTitle.setText("컷쏘우");
                textViewSubscript.setText("작업량이 많을 때 재작업이나 철거작업을 자를 때를 도구");
                textViewExplain.setText(
                        "- 컷쏘날은 시멘트, 나무, 철, 플라스틱 등 정확히 절단하려고 하는 물체의 종류를 파악하는 게 가장 중요하다.\n" +
                        "\n- 컷쏘날은 '길이' 또한 중요한데, 절단하려는 물체가 두꺼우면 당연히 날 길이가 길어지겠지만, 그렇지 않은 경우인데 긴 날을 사용하게 되면, 컷쏘날이 직선왕복운동을 할 때 휘어지는 경향이 있다.\n" +
                        "\n"+"출처 http://i-db.co.kr/2016/12/%EC%BB%B7%EC%8F%98%EC%97%90-%EB%8C%80%ED%95%9C-%EB%AA%A8%EB%93%A0-%EA%B2%83/");
            } else if (index == 6) {
                imageView.setImageResource(R.drawable.tool_misaw);
                textViewTitle.setText("각도절단기(마이스터 쏘우)");
                textViewSubscript.setText("두꺼운 자재를 자를 때 사용하는 도구");
                textViewExplain.setText(
                        "- 작업에 적절한 절단기를 선택한다. 절단기는 자재의 특정 모양과 크기에 따라 설계되어 있다.\n" +
                        "\n- 절단 조 주위를 마대자루, 천이나 넝마로 감싸서 튀는 금속으로 인한 부상을 방지한다. (잘릴 때 금속이 튀고 금속이 단단할수록 더 멀리 튀게 된다.)\n" +
                        "\n- 튀는 금속조각으로 인한 부상을 피할 수 있도록 주위에 있는 사람들에게 예방조치를 취할 것을 경고한다.\n" +
                        "\n- 절단공구를 완벽한 정비상태로 유지한다.\n" +
                        "\n- 자주 사용되는 절단날과 작동부위를 매일 조정하고 기름을 친다.\n" +
                        "\n- 제조자의 지시서에 따라 조를 날카롭게 한다.\n" +
                        "\n- 적절하고 안전하게 사용할 수 있도록 훈련될 때까지 절단공구를 사용하지 않는다.\n" +
                        "\n- 절연손잡이를 필요로 하는 작업에 완충용 스프링 손잡이를 사용하지 않는다. (이것은 기본적으로 편안함을 위해서이며, 충격에 대한 보호가 되지 않는다.)\n" +
                        "\n- 금이 가고 부러지거나 헐거운 절단기를 사용하지 않는다.\n" +
                        "\n- 공구의 권장용량을 초과하지 않는다.\n" +
                        "\n- 비스듬하게 자르지 않는다.\n" +
                        "\n- 철사를 자를 때 절단기를 옆에서 옆으로 흔들지 않는다.\n" +
                        "\n- 절단시 공구를 들어올리거나 비틀지 않는다.\n" +
                        "\n- 잘리는 물질이 조의 절단 모서리와 직각을 유지하도록 한다.\n" +
                        "\n- 더 큰 절단력을 얻기 위해 절단공구를 망치로 두드리지 않는다.\n" +
                        "\n- 절단기를 과중한 열에 노출시키지 않는다.\n" +
                        "\n"+"출처:http://blog.daum.net/_blog/BlogTypeView.do?blogid=0M65M&articleno=6236921&categoryId=684031&regdt=20190329143120");
            }
        }

    }
}
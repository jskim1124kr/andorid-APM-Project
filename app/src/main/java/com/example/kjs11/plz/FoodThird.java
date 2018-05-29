package com.example.kjs11.plz;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by kjs11 on 2017-05-08.
 */



public class FoodThird extends Activity {
    ImageView image1,image2,image3,image4,image5,image6,image7,image8;
    TextView text,text2,text3,text4,text5,text6,text7,text8;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.food_detail3);

        Init();

        text.setText("< 원두 커피 > " +"\n"+"\n"+"시럽이나 설탕을 타지 않은 원두 커피 한잔은"+"\n"+"운동에 좋은 음식이 될 수 있다."+"\n"+
                "\n"+ "커피 속 카페인 성분이 근손실을 예방하는 역할을 하고, 운동하고 나서 글루코겐을 생성하는 데에 도움을 주기 때문에"+"\n"+
        "근육에 두루좋은 효능이 있다.");

        text2.setText("< 다크 초콜릿 > " +"\n"+"\n"+"설탕 함량이 높지 않은 다크 초콜릿 속에는 " +"\n" +"마그네슘 성분이 많이 함유되어 있어 대사 활동을 촉진 시킨다"+"\n" +
        "그렇기 때문에 에너지를 생성하는 역할을 하며,"+"\n" +"이 마그네슘 성분은 숙면을 취하는 데에도 도움을 준다고 알려져 있다.");

        text3.setText(" < 꿀 > "  +"\n"+"\n"+"꿀도 근력 운동에 좋은 식재료로 옛날부터 많이 챙겨 먹는 대표 음식이다."+ "\n"+ "특히 고대 그리스에서는 올림픽 달리기 선수들이" +"\n" +
        "힘을 내기 위해서 즐겨 먹었다고 한다." + "\n" + "각종 미네랄부터 비타민 등이 풍부하기 때문에 신진대사를 원활하게 만들고 근육의 피로도 풀어준다.");


        text4.setText(" < 귀리 > "  +"\n"+"\n"+"귀리로 식사의 탄수화물을 구성하는 것도"+ "\n"+ "운동능력향상을 위한 좋은 방법이다." +"\n" +
                "귀리는 식이섬유나 단백질이 정제곡물에 비해 많은 양이 들어있고" + "\n" + "비타민, 철분, 칼륨 등 다양한 영양소가 건강에 도움이 된다고 한다."+"\n" +
        "복합 탄수화물 식품이라 에너지를 공급하기 때문에 "+"\n" +"운동 좋은 식품이다.");


        text5.setText(" < 생강 > "  +"\n"+"\n"+"따뜻한 생강차 한 잔도 운동하는데 도움을 줄 수 있다."+ "\n"+ "따뜻한 성질의 식품이라 몸을 따뜻하게 만들어" +"\n" +
                "면역력을 키우고 신진대사를 돕는 것으로 유명한 식품이다." + "\n" + "운동 전후에 섭취한다면 운동으로 인한 근육통 완화에 좋아" +"\n" +"격한 운동을 즐기는 사람들에게 좋다.");

        text6.setText(" < 당근 > "  +"\n"+"\n"+"당근은 항산화 작용 때문에 근력 운동에 좋은 식재료다."+ "\n"+ "너무 격한, 자신의 능력치 이상의 운동을 하다보면" +"\n" +
                "활성산소가 배출되게 되는데, 당근 속 베타카로틴 성분이 세포 노화를 막는 항산화 작용을 하며" + "\n" + "운동 능력을 높이는데 도움을 준다.");

        text7.setText(" < 견과류 > "  +"\n"+"\n"+"운동능력향상을 위해선 견과류를 간식으로 하루 적당량 섭취하는 게 좋다."+ "\n"+ "운동에 좋은 음식이 갖춰야 할 마그네슘과 단백질부터" +"\n" +
                "몸에 좋은 불포화지방산도 두루 갖추고 있는 여러 견과류는" + "\n" + "당을 에너지로 바꿔주고 안 좋은 지방 수치는 낮춰주는 작용을 한다고 한다.");

        text8.setText(" < 단백질 보충제 > "  +"\n"+"\n"+"운동 후 20분 이내는 영양소를 받아들이기에 최적의 상태로," + "\n" +"이 때 단백질 보충제를 섭취한다면 더 좋은 흡수력으로" + "\n" +"필요한 단백질을 충분히 보충 할 수 있고," + "\n" +
                "유청 단백질보충제의 장점인 여러 필수 , 비필수 아미노산이나 멀티비타민 같은 성분도 함께 공급 받을 수 있다.");



    }
    void Init(){

        text = (TextView)findViewById(R.id.detail3_message1);
        image1 = (ImageView)findViewById(R.id.detail3_1);
        image1.setImageResource(R.drawable.fdetail3_1);


        text2 = (TextView)findViewById(R.id.detail3_message2);
        image2 = (ImageView)findViewById(R.id.detail3_2);
        image2.setImageResource(R.drawable.fdetail3_2);

        text3 = (TextView)findViewById(R.id.detail3_message3);
        image3 = (ImageView)findViewById(R.id.detail3_3);
        image3.setImageResource(R.drawable.fdetail3_3);

        text4 = (TextView)findViewById(R.id.detail3_message4);
        image4 = (ImageView)findViewById(R.id.detail3_4);
        image4.setImageResource(R.drawable.fdetail3_4);

        text5 = (TextView)findViewById(R.id.detail3_message5);
        image5 = (ImageView)findViewById(R.id.detail3_5);
        image5.setImageResource(R.drawable.fdetail3_5);

        text6 = (TextView)findViewById(R.id.detail3_message6);
        image6 = (ImageView)findViewById(R.id.detail3_6);
        image6.setImageResource(R.drawable.fdetail3_6);


        text7 = (TextView)findViewById(R.id.detail3_message7);
        image7 = (ImageView)findViewById(R.id.detail3_7);
        image7.setImageResource(R.drawable.fdetail3_7);

        text8 = (TextView)findViewById(R.id.detail3_message8);
        image8 = (ImageView)findViewById(R.id.detail3_8);
        image8.setImageResource(R.drawable.fdetail3_8);

    }


    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}

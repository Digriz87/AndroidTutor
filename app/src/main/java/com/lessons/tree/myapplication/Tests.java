package com.lessons.tree.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.paperdb.Paper;

/**
 * Created by Digriz on 03.03.2016.
 */
public class Tests extends AppCompatActivity {


    @Bind(R.id.title_main)    ImageView titleMain;
    @Bind(R.id.text_main_top) TextView textMainTop;
    @Bind(R.id.shadow_title_main) ImageView shadowTitleMain;
    @Bind (R.id.question1) TextView questionOne;
    @Bind (R.id.question2) TextView questionTwo;
    @Bind(R.id.button_one)    Button buttonOne;
    @Bind(R.id.button_two)    Button buttonTwo;
    @Bind(R.id.button_three)    Button buttonThree;
    @Bind(R.id.button_four)    Button buttonFour;
    @Bind(R.id.button_five)    Button buttonFive;
    @Bind(R.id.button_six)    Button buttonSix;
       @Bind(R.id.scroll_view)    ScrollView scrollView;
    @Bind(R.id.backspace) ImageView backspace;


    int numberTutorial; //Сюда передаем номер нашего урока по Тагу
    int count=0;//Счетчик правильных ответов


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        switch (getIntent().getIntExtra("level",0)){
            case 0: setContentView(R.layout.tests);
                break;
            case 1: setContentView(R.layout.tests_two);
                break;
            case 2: setContentView(R.layout.tests_three);
                break;
            case 3: setContentView(R.layout.tests_four);
                break;
            case 4: setContentView(R.layout.tests_five);
                break;
            case 5: setContentView(R.layout.tests_six);
                                break;
            case 6: setContentView(R.layout.tests_seven);
                break;
            case 7: setContentView(R.layout.tests_eight);
                break;
            case 8: setContentView(R.layout.tests_nine);
                                break;
            case 9: setContentView(R.layout.tests_ten);
                break;
        }
        ButterKnife.bind(this);



        numberTutorial = getIntent().getIntExtra("level", 0);

        //Подключаем наши шрифты
        Typeface fontOswaldBold = Typeface.createFromAsset(this.getAssets(), "fonts/Oswald-Bold.ttf");
        Typeface fontRobotLight = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Light.ttf");

        //Get our`s height and wight of display
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels;
        int wight = metrics.widthPixels;

        //Получаем наш размер в 10 пикселях любого экрана
        int tenPixelsHeight = height / 128;
        int tenPixelsWight = wight / 77;

        //Параметры кнопки Назад
        FrameLayout.LayoutParams buttonBackspaceParams = new FrameLayout.LayoutParams(tenPixelsWight*8,tenPixelsHeight*8);
        buttonBackspaceParams.setMargins(0,tenPixelsHeight,0,0);
        backspace.setLayoutParams(buttonBackspaceParams);

        //Параметры верхней плашки
        FrameLayout.LayoutParams titleMainParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, tenPixelsHeight * 11);
        titleMainParams.setMargins(0, 0, 0, 0);
        titleMainParams.gravity = Gravity.TOP;
        titleMain.setLayoutParams(titleMainParams);

        //Параметры текста Номер Урока в Экшен Баре
        FrameLayout.LayoutParams textMainTutor = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        textMainTutor.setMargins(0, tenPixelsHeight * 2, tenPixelsHeight*25, 0);
        textMainTutor.gravity = Gravity.CENTER_HORIZONTAL;
        textMainTop.setLayoutParams(textMainTutor);
        textMainTop.setTypeface(fontRobotLight);
        textMainTop.setTextSize(TypedValue.COMPLEX_UNIT_PX, tenPixelsWight * 4);

        //Параметры тени плашки
        FrameLayout.LayoutParams shadowMainTopParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, tenPixelsHeight / 2);
        shadowMainTopParams.setMargins(0, tenPixelsHeight * 11, 0, 0);
        shadowTitleMain.setLayoutParams(shadowMainTopParams);

        //Параметры Вопроса 1
        LinearLayout.LayoutParams questionOneParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        questionOneParams.setMargins(0,tenPixelsHeight/5,0,0);
        questionOneParams.gravity = Gravity.CENTER_HORIZONTAL;
        questionOne.setLayoutParams(questionOneParams);
        questionOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, tenPixelsWight * 4);

        //Параметры Вопроса 2
        LinearLayout.LayoutParams questionTwoParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        questionTwoParams.setMargins(0,tenPixelsHeight/5,0,0);
        questionTwoParams.gravity = Gravity.CENTER_HORIZONTAL;
        questionTwo.setLayoutParams(questionTwoParams);
        questionTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, tenPixelsWight * 4);

        //Параметры ScrollView
        FrameLayout.LayoutParams scrollViewParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        scrollViewParams.setMargins(0, tenPixelsHeight * 11, 0, 0);
        scrollView.setLayoutParams(scrollViewParams);

        //Параметры Кнопки 1
        LinearLayout.LayoutParams buttonOneParams = new LinearLayout.LayoutParams(tenPixelsWight*50, tenPixelsHeight*12);
        buttonOneParams.setMargins(0,tenPixelsHeight*5,0,0);
        buttonOneParams.gravity = Gravity.CENTER_HORIZONTAL;
        buttonOne.setLayoutParams(buttonOneParams);

        //Параметры Кнопки 2
        LinearLayout.LayoutParams buttonTwoParams = new LinearLayout.LayoutParams(tenPixelsWight*50, tenPixelsHeight*12);
        buttonTwoParams.setMargins(0,tenPixelsHeight*5,0,0);
        buttonTwoParams.gravity = Gravity.CENTER_HORIZONTAL;
        buttonTwo.setLayoutParams(buttonTwoParams);

        //Параметры Кнопки 3
        LinearLayout.LayoutParams buttonThreeParams = new LinearLayout.LayoutParams(tenPixelsWight*50, tenPixelsHeight*12);
        buttonThreeParams.setMargins(0,tenPixelsHeight*5,0,0);
        buttonThreeParams.gravity = Gravity.CENTER_HORIZONTAL;
        buttonThree.setLayoutParams(buttonThreeParams);

        //Параметры Кнопки 4
        LinearLayout.LayoutParams buttonFourParams = new LinearLayout.LayoutParams(tenPixelsWight*50, tenPixelsHeight*12);
        buttonFourParams.setMargins(0,tenPixelsHeight*5,0,0);
        buttonFourParams.gravity = Gravity.CENTER_HORIZONTAL;
        buttonFour.setLayoutParams(buttonFourParams);

        //Параметры Кнопки 5
        LinearLayout.LayoutParams buttonFiveParams = new LinearLayout.LayoutParams(tenPixelsWight*50, tenPixelsHeight*12);
        buttonFiveParams.setMargins(0,tenPixelsHeight*5,0,0);
        buttonFiveParams.gravity = Gravity.CENTER_HORIZONTAL;
        buttonFive.setLayoutParams(buttonFiveParams);

        //Параметры Кнопки 6
        LinearLayout.LayoutParams buttonSixParams = new LinearLayout.LayoutParams(tenPixelsWight*50, tenPixelsHeight*12);
        buttonSixParams.setMargins(0,tenPixelsHeight*5,0,0);
        buttonSixParams.gravity = Gravity.CENTER_HORIZONTAL;
        buttonSix.setLayoutParams(buttonSixParams);
    }

    // Кнопка назад
    public void backClick (View v){

        finish();
    }

    // Обработчик клика на кнопку  ответа
    public void checkAnswer (View v){
            if (Boolean.valueOf(v.getTag().toString())){
                v.setBackgroundResource(R.drawable.style_button_tests_three);
                v.setClickable(false);
                count = count+1;
                if (count ==2){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Поздравляем, ответы верные и вы прошли тест, выберите новый урок", Toast.LENGTH_LONG);
                    toast.show();
                    Paper.book().write("progress", getIntent().getIntExtra("level", 0)+1);

                    Intent newIntent = new Intent(this, MainActivity.class);
                    startActivity(newIntent);

                }
      }else {
                v.setBackgroundResource(R.drawable.style_button_tests_two);

            }

    }

}
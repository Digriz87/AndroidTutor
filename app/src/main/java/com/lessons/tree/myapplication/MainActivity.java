package com.lessons.tree.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toolbar;
import com.lessons.tree.myapplication.Optimization.Optim;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.paperdb.Paper;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.main_scroll_view)    ScrollView mainScrollView;
    @Bind(R.id.main_linear_layout)    LinearLayout mainLinearLayout;
    @Bind(R.id.title_main) ImageView titleMain;
    @Bind(R.id.text_main_top) TextView textMainTop;
    @Bind(R.id.shadow_title_main) ImageView shadowTitleMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ButterKnife.bind(this);
        Paper.init(this);






        //Get our`s height and wight of display
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels ;
        int wight = metrics.widthPixels ;

        //Получаем наш размер в 10 пикселях любого экрана
        int tenPixelsHeight = height/128;
        int tenPixelsWight = wight/77;

        //Подключаем наши шрифты
        Typeface fontRobotBold = Typeface.createFromAsset(this.getAssets(), "fonts/Oswald-Bold.ttf");
        Typeface fontRobotLight = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Light.ttf");
        Typeface fontOswaldBold = Typeface.createFromAsset(this.getAssets(), "fonts/Oswald-Bold.ttf");

        Optim optim = new Optim();
        optim.optimization(tenPixelsHeight,tenPixelsWight,titleMain,textMainTop,shadowTitleMain,mainScrollView,fontRobotLight);


        //Наши ресурсы для юзанья :)
        int masImage [] = {R.drawable.pic1,R.drawable.pic1,R.drawable.pic1,R.drawable.pic1,R.drawable.pic1,R.drawable.pic1,R.drawable.pic1,R.drawable.pic1,R.drawable.pic1,R.drawable.pic1};
        String mainNameTutorial [] = {"Урок Первый","Урок Второй","Урок Третий","Урок Четвертый","Урок Пятый","Урок Шестой","Урок Седьмой","Урок Восьмой","Урок Девятый","Урок Десятый"};
        String fullDescriptionTutorial [] = {"Установка и настройка Android Studio","Первое андроид-приложение",
                "Элементы экрана в android","Файл макета android-приложения", "LinearLayout и RelativeLayout", "Параметры элементов экрана","Как управлять View-элементами экрана из java",
                "Три cпособа обработки нажатия кнопки","Один обработчик (OnClickListener)", "Работа с ресурсами в андроид"};
        String descriptionBottom [] = {"- Установка среды разработки.\n - Установка JDK.\n - Настройка Android SDK\n",
                " - Вы создадите свое первое приложение",
                " -Мы узнаем содержимое любого Activity\n - Узнаем что такое View","- В этом уроке рассмотрим layout-файл в виде XML",
        "ViewGroup: LinearLayout и RelativeLayout.\n -Изучим их свойства и научимся их использовать",
                "- В этом уроке мы узнаем, как изменять ширину, высоту, отступ, вес\n и расположение элементов экрана в android приложениях.", "-Как вывести свой текст в TextView, изменить текст кнопки (Button)\n " +
                "-Программно установить флаг на чекбоксе (CheckBox)","- Как заставить кнопку реагировать на нажатие\n и как обрабатывать нажатие кнопки на экране android устройства",
                "- Вы узнаете, как заставить TextView реагировать на нажатие\n и как обрабатывать нажатие TextView на экране android устройства.",
                "- В этом уроке узнаем, какие ресурсы (файлы музыки, изображений или xml файлы) "

        };



         //Записываем наш Левел в ПейперБук чтобы потом открывались следующие уроки
        int currentLvl = Paper.book().read("progress",0);


        for (int i =0; i<masImage.length;i++){
            FrameLayout mainFrame = new FrameLayout(this);  //Параметры ФреймЛайаута
            Button mainButtonStart = new Button(this);  //Параметры Кнопки главной Старт
            TextView cartTextMainBottomFirst = new TextView(this); //Параметры текста под Номером уроки нижний
            TextView cartTextNumberTutorialFirst = new TextView(this);  //Параметры текста Номера Урока
            ImageView cartLayerDarkFirst = new ImageView(this); //Параметры Layer`a темного цвета сверху
            TextView cartTextBottomFirst =  new TextView(this); //Параметры текста в самом низу
            ImageView cartIconAndroidFirst = new ImageView(this); //Параметры иконки внизу
            ImageView mainPictureFirst  = new ImageView(this); //Параметры для главной картинки карточки
            ImageView cartLayerFirst  = new ImageView(this);   //Параметры самой карточки основы
            ImageView iconOpen = new ImageView(this);   // Параметры иконки замочка


            //Параметры ФреймЛайаута
            LinearLayout.LayoutParams frameLayoutFirstCartParams = new LinearLayout.LayoutParams(tenPixelsWight*70,tenPixelsHeight*50);
            frameLayoutFirstCartParams.setMargins(0,tenPixelsHeight*7,0,0);
            frameLayoutFirstCartParams.gravity = Gravity.CENTER_HORIZONTAL;
            mainFrame.setLayoutParams(frameLayoutFirstCartParams);
            mainLinearLayout.addView(mainFrame);

            //Параметры самой карточки основы
            FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(tenPixelsWight*70,tenPixelsHeight*50);
            frameParams.setMargins(0,0,0,0);
            frameParams.gravity = Gravity.CENTER_HORIZONTAL;
            cartLayerFirst.setLayoutParams(frameParams);
            cartLayerFirst.setBackgroundResource(R.drawable.corners_smooth);
            mainFrame.addView(cartLayerFirst);


            //Параметры Кнопки главной Старт
            FrameLayout.LayoutParams mainButtonParams = new FrameLayout.LayoutParams(tenPixelsWight*25,tenPixelsHeight*10);
            mainButtonParams.setMargins(0, tenPixelsHeight * 20, 0, 0);
            mainButtonParams.gravity = Gravity.CENTER_HORIZONTAL;
            mainButtonStart.setLayoutParams(mainButtonParams);
            mainButtonStart.setBackgroundResource(R.drawable.button_style);
            mainButtonStart.setTextColor(Color.parseColor("#FFFFFF"));
            mainButtonStart.setText("СТАРТ");
            mainButtonStart.setTextSize(TypedValue.COMPLEX_UNIT_PX, tenPixelsWight * 3);
            mainButtonStart.setTypeface(fontRobotBold);

            if (currentLvl >=i){
                mainButtonStart.setOnClickListener(this);
            }
            mainButtonStart.setTag(i);
            mainFrame.addView(mainButtonStart);


            //Параметры иконки внизу
            FrameLayout.LayoutParams iconAndroidParams = new FrameLayout.LayoutParams(tenPixelsHeight*12,tenPixelsHeight*12);
            iconAndroidParams.setMargins(tenPixelsWight * 2, tenPixelsHeight * 37, 0, 0);
            cartIconAndroidFirst.setLayoutParams(iconAndroidParams);
            cartIconAndroidFirst.setBackgroundResource(R.drawable.android_icon);
            mainFrame.addView(cartIconAndroidFirst);

            //Параметры для главной картинки карточки
            FrameLayout.LayoutParams mainPicParams = new FrameLayout.LayoutParams(tenPixelsWight*70,tenPixelsHeight* 36);
            mainPicParams.setMargins(0,0,0,0);
            mainPicParams.gravity = Gravity.CENTER_HORIZONTAL;
            mainPictureFirst.setLayoutParams(mainPicParams);
            mainPictureFirst.setBackgroundResource(masImage[i]);
            mainFrame.addView(mainPictureFirst);

            //Параметры Layer`a темного цвета сверху
            FrameLayout.LayoutParams layerDarkParams = new FrameLayout.LayoutParams(tenPixelsWight*70, tenPixelsHeight*36);
            layerDarkParams.setMargins(0,0,0,0);
            layerDarkParams.gravity = Gravity.CENTER_HORIZONTAL;
            cartLayerDarkFirst.setLayoutParams(layerDarkParams);
            cartLayerDarkFirst.setBackgroundColor(Color.parseColor("#80010101"));
            mainFrame.addView(cartLayerDarkFirst);


            //Параметры текста в самом низу
            FrameLayout.LayoutParams textBottomParams = new FrameLayout.LayoutParams(tenPixelsWight*56,FrameLayout.LayoutParams.WRAP_CONTENT);
            textBottomParams.setMargins(tenPixelsWight*15,tenPixelsHeight*37,0,0);
            cartTextBottomFirst.setLayoutParams(textBottomParams);
            cartTextBottomFirst.setText(descriptionBottom[i]);
            cartTextBottomFirst.setTextSize(TypedValue.COMPLEX_UNIT_PX, tenPixelsWight * 3);
            cartTextBottomFirst.setTypeface(fontRobotLight);
            mainFrame.addView(cartTextBottomFirst);

            //Параметры текста Номера Урока
            FrameLayout.LayoutParams textNumberParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
            textNumberParams.setMargins(0,tenPixelsHeight*8,0,0);
            textNumberParams.gravity = Gravity.CENTER_HORIZONTAL;
            cartTextNumberTutorialFirst.setLayoutParams(textNumberParams);
            cartTextNumberTutorialFirst.setTypeface(fontRobotBold);
            cartTextNumberTutorialFirst.setText(mainNameTutorial[i]);
            cartTextNumberTutorialFirst.setTextSize(TypedValue.COMPLEX_UNIT_PX, tenPixelsWight * 5);
            cartTextNumberTutorialFirst.setTextColor(Color.parseColor("#FFFFFF"));
            mainFrame.addView(cartTextNumberTutorialFirst);

            //Параметры текста под Номером уроки нижний
            FrameLayout.LayoutParams  textBottomNumberParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
            textBottomNumberParams.setMargins(0,tenPixelsHeight*15,0,0);
            textBottomNumberParams.gravity = Gravity.CENTER_HORIZONTAL;
            cartTextMainBottomFirst.setLayoutParams(textBottomNumberParams);
            cartTextMainBottomFirst.setTypeface(fontRobotLight);
            cartTextMainBottomFirst.setText(fullDescriptionTutorial[i]);
            cartTextMainBottomFirst.setTextSize(TypedValue.COMPLEX_UNIT_PX, tenPixelsWight * 3);
            cartTextMainBottomFirst.setTextColor(Color.parseColor("#FFFFFF"));
            mainFrame.addView(cartTextMainBottomFirst);

            //Параметры иконки замочка
            FrameLayout.LayoutParams iconOpenParams = new FrameLayout.LayoutParams(tenPixelsWight*8,tenPixelsHeight*8);
            iconOpenParams.setMargins(tenPixelsWight * 61, tenPixelsHeight * 2, tenPixelsWight * 1, 0);
            iconOpen.setLayoutParams(iconOpenParams);
            if (currentLvl >=i){
                iconOpen.setBackgroundResource(R.drawable.ic_lock_open_white_24dp);
           }else{
                iconOpen.setBackgroundResource(R.drawable.ic_lock_outline_white_24dp);
            }

            mainFrame.addView(iconOpen);

        }

            }

  //Передаем наш номер урока по кнопке Старт в новое Активити

    @Override
    public void onClick(View v) {
        Intent newIntent = new Intent(this, NextActivity.class);
        newIntent.putExtra("level", Integer.valueOf(v.getTag().toString()));
        startActivity(newIntent);


    }

}

package com.lessons.tree.myapplication.Optimization;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toolbar;

/**
 * Created by Digriz on 17.02.2016.
 */
public class Optim {

    public void optimization (int tenPixelsHeight, int tenPixelsWight,ImageView titleMain,TextView textMainTop,ImageView shadowTitleMain,ScrollView mainScrollView,Typeface fontRobotLight) {


//Параметры верхней плашки
        FrameLayout.LayoutParams titleMainParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,tenPixelsHeight*11);
        titleMainParams.setMargins(0,0,0,0);
        titleMainParams.gravity = Gravity.TOP;
        titleMain.setLayoutParams(titleMainParams);

        //Параметры текста TUTOR+
        FrameLayout.LayoutParams textMainTutor = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
        textMainTutor.setMargins(0,tenPixelsHeight*1,tenPixelsWight*15,0);
        textMainTutor.gravity = Gravity.CENTER_HORIZONTAL;
        textMainTop.setLayoutParams(textMainTutor);
        textMainTop.setTextSize(TypedValue.COMPLEX_UNIT_PX, tenPixelsWight * 5);
        textMainTop.setTypeface(fontRobotLight);

//Параметры тени плашки
        FrameLayout.LayoutParams shadowMainTopParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,tenPixelsHeight/2);
        shadowMainTopParams.setMargins(0,tenPixelsHeight*11,0,0);
        shadowTitleMain.setLayoutParams(shadowMainTopParams);

//Параметры CкроллВью
        FrameLayout.LayoutParams scrollViewParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
        scrollViewParams.setMargins(0,tenPixelsHeight*12,0,0);
        mainScrollView.setLayoutParams(scrollViewParams);



    }
}

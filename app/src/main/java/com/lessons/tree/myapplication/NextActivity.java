        package com.lessons.tree.myapplication;

        import android.content.Intent;
        import android.graphics.Typeface;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Config;
        import android.util.DisplayMetrics;
        import android.util.TypedValue;
        import android.view.Gravity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.FrameLayout;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import butterknife.Bind;
        import butterknife.ButterKnife;

        import com.google.android.gms.ads.AdRequest;
        import com.google.android.gms.ads.AdView;
        import com.google.android.youtube.player.YouTubeBaseActivity;
        import com.google.android.youtube.player.YouTubeInitializationResult;
        import com.google.android.youtube.player.YouTubePlayer;
        import com.google.android.youtube.player.YouTubePlayer.Provider;
        import com.google.android.youtube.player.YouTubePlayerView;

        public class NextActivity extends YouTubeBaseActivity  implements YouTubePlayer.OnInitializedListener  {
            @Bind(R.id.title_main)    ImageView titleMain;
            @Bind(R.id.text_main_top) TextView textMainTop;
            @Bind(R.id.shadow_title_main) ImageView shadowTitleMain;
            @Bind(R.id.backspace) ImageView backspace;
            @Bind(R.id.share) ImageView share;
            @Bind(R.id.linear_layout_text_bottom)  LinearLayout linearTextBottom;
            @Bind(R.id.button_test)   Button buttonTest;


            private YouTubePlayerView youTubeView;
            private static final int RECOVERY_REQUEST = 1;


            //Массив из данных ссылок под Ютую Ролики и значения
            String masLinksYoutube [] = {"9ucX3UlCT6E", "SbWzaPtvzJA", "goESBP6iUuw","DLsKPE9NviA","gm0gCY2qA54","ZEJRfEtx-eQ","kg_JjciT4a8","pWbV8Vo8C0w","0cUGwWlbo_8","RqCKvZBek90"};
            //Переменная куда сохраняется наш номер ТАГА
            int numberTutorial;


            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.next_activity);
                ButterKnife.bind(this);



               //Подключаем наши шрифты
                Typeface fontOswaldBold = Typeface.createFromAsset(this.getAssets(), "fonts/Oswald-Bold.ttf");
                Typeface fontRobotLight = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Light.ttf");


                youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
                youTubeView.initialize("AIzaSyBGpRO6DaN2WTFeMCKLdM7m7xj22-sD_yo", this);
                 //Наш ИНТЕНТ:
                 numberTutorial = getIntent().getIntExtra("level", 0);

                //Get our`s height and wight of display
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                int height = metrics.heightPixels;
                int wight = metrics.widthPixels;

                //Получаем наш размер в 10 пикселях любого экрана
                int tenPixelsHeight = height / 128;
                int tenPixelsWight = wight / 77;

                //Параметры верхней плашки
                FrameLayout.LayoutParams titleMainParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, tenPixelsHeight * 11);
                titleMainParams.setMargins(0, 0, 0, 0);
                titleMainParams.gravity = Gravity.TOP;
                titleMain.setLayoutParams(titleMainParams);

                //Параметры текста Номер Урока в Экшен Баре
                FrameLayout.LayoutParams textMainTutor = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                textMainTutor.setMargins(0, tenPixelsHeight / 2, tenPixelsWight*15, 0);
                textMainTutor.gravity = Gravity.CENTER_HORIZONTAL;
                textMainTop.setLayoutParams(textMainTutor);
                textMainTop.setText("Урок Номер: " + String.valueOf(numberTutorial+1));
                textMainTop.setTypeface(fontRobotLight);
                textMainTop.setTextSize(TypedValue.COMPLEX_UNIT_PX,tenPixelsWight*5);

                //Параметры тени плашки
                FrameLayout.LayoutParams shadowMainTopParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, tenPixelsHeight / 2);
                shadowMainTopParams.setMargins(0, tenPixelsHeight * 11, 0, 0);
                shadowTitleMain.setLayoutParams(shadowMainTopParams);

                //Параметры кнопки Назад
                FrameLayout.LayoutParams buttonBackspaceParams = new FrameLayout.LayoutParams(tenPixelsWight*8,tenPixelsHeight*8);
                buttonBackspaceParams.setMargins(0,tenPixelsHeight,0,0);
                backspace.setLayoutParams(buttonBackspaceParams);

                //Параметры кнопки Расшарить
                FrameLayout.LayoutParams buttonShareParams = new FrameLayout.LayoutParams(tenPixelsWight*6,tenPixelsHeight*6);
                buttonShareParams.setMargins(0,tenPixelsHeight*2,0,0);
                buttonShareParams.gravity = Gravity.RIGHT;
                share.setLayoutParams(buttonShareParams);

                //Параметры кнопки внизу Пройди тест
                FrameLayout.LayoutParams buttonTestParams = new FrameLayout.LayoutParams(tenPixelsWight*70,tenPixelsHeight*9);
                buttonTestParams.setMargins(0,0,0,tenPixelsHeight*12);
                buttonTestParams.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                buttonTest.setLayoutParams(buttonTestParams);
                buttonTest.setTypeface(fontOswaldBold);

                // Параметры ЛинерЛайута
                FrameLayout.LayoutParams linearLayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,tenPixelsHeight*50);
                linearLayoutParams.setMargins(tenPixelsWight/5,tenPixelsHeight*60,tenPixelsWight/5,0);
                linearTextBottom.setLayoutParams(linearLayoutParams);


                //Более детальное описание урока
               String masTextBottom [] = {"Добро пожаловать! Как создают приложения для android? Какие инструменты нужны для разработки андроид-приложений?\n " +
                       "В этом уроке вы узнаете, как установить среду разработки мобильных приложений Android Studio\n " +
                       "и как настроить все необходимые для андроид-разработчика инструменты.","На прошлом уроке мы с вами подготовили все необходимые инструменты для разработки android приложений.\n " +
                       "Теперь давайте создадим первое приложение, познакомимся со структурой android проекта,\n" +
                       " и настроим android virtual device - виртуальное android устройство а для запуска и тестирования этого приложения.","Давайте посмотрим, как в Андроид приложениях формируется то, что мы видим на экране.\n" +
                       " Содержимое Activity формируется из различных компонентов, называемых View.\n Самые распространенные View - это кнопка, поле ввода, чекбокс и т.д.",
               "В этом уроке рассмотрим layout-файл в виде XML, и узнаем, как будет отображаться наше приложение при повороте экрана андроид-устройства.",
                       "В этом уроке рассмотрим основные ViewGroup: LinearLayout и RelativeLayout.\n Изучим их свойства и научимся их использовать при создании приложений для мобильных астройств на андроид.",
                       "В этом уроке мы узнаем, как изменять ширину, высоту, отступ, вес и расположение элементов " +
                               "Рассмотрим такие параметры, как layout_width - ширина; layout_height - высота; layout_weight – вес; layout_gravity - выравнивание; layout_margin - отступ.",
                       "Как вывести свой текст в TextView, изменить текст кнопки (Button) " +
                               "В java для этого есть соответствующие методы. Но чтобы java методы могли как-то работать с View- элементами экрана android-приложения, например, менять текст в поле TextView, они должны эти самые элементы экрана как-то находить. Для этого нужно присвоить ID (идентификатор) тому View, с которым вы хотите взаимодействовать. " +
                               "В этом уроке мы научимся обращаться из кода к View-элементам на экране и менять их свойства.",
                       "В этом уроке вы узнаете, как в андроид повесить слушатель (OnClickListener) на кнопку (Buttons). Как заставить кнопку реагировать на нажатие, и как обрабатывать нажатие кнопки на экране android устройства." +
                               "Также вы познакомитесь с тремя разными способами обработки нажатия кнопки.",
                       "В этом уроке вы узнаете, как оптимизировать реализацию слушателей для события нажатия кнопки в android - будем использовать один слушатель (Listener) для нескольких объектов. " +
                               "Также вы узнаете, как заставить TextView реагировать на нажатие, и как обрабатывать нажатие TextView на экране android устройства.",
                       " этом уроке узнаем, какие ресурсы (файлы музыки, изображений или xml файлы) может использовать android приложение, где хранятся файлы ресурсов в проекте и как их можно применять в разработке приложений под андроид. " +
                               "Узнаем например, как поменять цвет текста на кнопке(Button), или установить фоновую картинку в ImageView."


               };

            for (int i=0;i<masTextBottom.length;i++){
                TextView textBottom = new TextView(this);

                FrameLayout.LayoutParams textBottomParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,tenPixelsHeight*40);
                textBottomParams.setMargins(tenPixelsWight*2,tenPixelsHeight*45,tenPixelsWight*2,0);
                textBottom.setLayoutParams(textBottomParams);
                textBottom.setText(masTextBottom[numberTutorial]);
                textBottom.setTypeface(fontRobotLight);
                linearTextBottom.addView(textBottom);


            }

            }
            // Кнопка назад
            public void backClick (View v){

                finish();
            }

            // Кнопка расшарить
            public void shareClick (View v){
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Я только что начал пользоватся программой по изучению программирования под Андроид!");
                startActivity(Intent.createChooser(intent, "Share"));


        }
            //Кнопка пройти тест
            public void button_click_test (View v){
                Intent newIntent = new Intent(this, Tests.class);
                newIntent.putExtra("level", numberTutorial);
                startActivity(newIntent);
                }



            //Код плеера Ютуба
            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.cueVideo(masLinksYoutube[numberTutorial]); // Показываем наш ролик
                }
            }

            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason) {
                if (errorReason.isUserRecoverableError()) {
                    errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
                } else {
                    String error = String.format(getString(R.string.player_error), errorReason.toString());
                    Toast.makeText(this, error, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (requestCode == RECOVERY_REQUEST) {
                    // Retry initialization if user performed a recovery action
                    getYouTubePlayerProvider().initialize("AIzaSyBGpRO6DaN2WTFeMCKLdM7m7xj22-sD_yo", this);
                }
            }

            protected Provider getYouTubePlayerProvider() {
                return youTubeView;
            }


            }


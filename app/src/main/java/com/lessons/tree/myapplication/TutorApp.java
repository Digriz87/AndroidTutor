package com.lessons.tree.myapplication;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.yandex.metrica.YandexMetrica;

/**
 * Created by Digriz on 19.03.2016.
 */
public class TutorApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Инициализация AppMetrica SDK
        YandexMetrica.activate(getApplicationContext(), 	"8575804e-2913-4818-93ef-db2ab4381d81");
        // Отслеживание активности пользователей
        YandexMetrica.enableActivityAutoTracking(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}

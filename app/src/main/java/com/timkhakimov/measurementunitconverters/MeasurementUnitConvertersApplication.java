package com.timkhakimov.measurementunitconverters;

import android.app.Application;

import com.timkhakimov.measurementunitconverters.di.AppComponent;
import com.timkhakimov.measurementunitconverters.di.DaggerAppComponent;

/**
 * Created by Timur Khakimov on 22.03.2020
 */
public class MeasurementUnitConvertersApplication extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}

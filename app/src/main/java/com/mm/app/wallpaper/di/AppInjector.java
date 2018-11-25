package com.mm.app.wallpaper.di;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.mm.app.wallpaper.App;
import com.mm.app.wallpaper.support.application.AbsActivityLifecycleCallbacks;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

public class AppInjector {

    private static AbsActivityLifecycleCallbacks sLifecycleCallbacks = new AbsActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            handleInject(activity);
        }
    };

    private AppInjector() {
    }

    public static void init(App app) {

        DaggerAppComponent.builder().application(app).build().inject(app);

        app.registerActivityLifecycleCallbacks(sLifecycleCallbacks);
    }

    private static void handleInject(Activity activity) {
        if (activity instanceof HasSupportFragmentInjector) {
            AndroidInjection.inject(activity);
        }
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
                @Override
                public void onFragmentCreated(@NonNull FragmentManager fm, @NonNull Fragment f, Bundle savedInstanceState) {
                    if (f instanceof Injectable) {
                        AndroidSupportInjection.inject(f);
                    }
                }
            }, true);
        }
    }
}

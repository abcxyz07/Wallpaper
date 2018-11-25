package com.mm.app.wallpaper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mm.app.wallpaper.base.di.DIActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends DIActivity {

    private Unbinder mUnbinder;

    public abstract int getLayoutResID();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        mUnbinder = ButterKnife.bind(this);
        renderViews(savedInstanceState);
    }

    public abstract void renderViews(@Nullable Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}

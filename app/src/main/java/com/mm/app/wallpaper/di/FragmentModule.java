package com.mm.app.wallpaper.di;

import com.mm.app.wallpaper.fragment.FindFragment;
import com.mm.app.wallpaper.fragment.ImageFragment;
import com.mm.app.wallpaper.fragment.TypeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    public abstract ImageFragment contributeImageFragment();

    @ContributesAndroidInjector
    public abstract TypeFragment contributeTypeFragment();

    @ContributesAndroidInjector
    public abstract FindFragment contributeFindFragment();

}

package com.mm.app.wallpaper.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.mm.app.wallpaper.data.local.AppDb;
import com.mm.app.wallpaper.data.local.FindDao;
import com.mm.app.wallpaper.data.local.ImagesDao;
import com.mm.app.wallpaper.data.local.TypeDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    @Singleton
    @Provides
    AppDb provideAppDb(Application app) {
        return Room
                .databaseBuilder(app, AppDb.class, "wallpaper.db")
                .build();
    }

    @Singleton
    @Provides
    ImagesDao provideImagesDao(AppDb appDb) {
        return appDb.imagesDao();
    }

    @Singleton
    @Provides
    TypeDao provideTypeDao(AppDb appDb) {
        return appDb.typeDao();
    }

    @Singleton
    @Provides
    FindDao provideFindDao(AppDb appDb) {
        return appDb.findDao();
    }
}

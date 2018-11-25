package com.mm.app.wallpaper.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.mm.app.wallpaper.data.model.Image;

@Database(entities = {Image.class},version = 1,exportSchema = false)
public abstract class AppDb extends RoomDatabase {

    public abstract ImagesDao imagesDao();

    public abstract TypeDao typeDao();

    public abstract FindDao findDao();
}

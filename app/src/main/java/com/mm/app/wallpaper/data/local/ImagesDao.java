package com.mm.app.wallpaper.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.mm.app.wallpaper.data.model.Image;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ImagesDao {

    @Query("SELECT * FROM image WHERE page = :page")
    Flowable<List<Image>> getImages(int page);

    @Insert
    void insertImages(Image... images);

    @Query("DELETE FROM image")
    void clearAll();
}

package com.mm.app.wallpaper.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.mm.app.wallpaper.data.model.Find;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface FindDao {

    @Query("SELECT * FROM find WHERE page = :page")
    Flowable<List<Find>> getFinds(int page);

    @Insert
    void insertFinds(Find... finds);

    @Query("DELETE FROM find")
    void clearAll();
}

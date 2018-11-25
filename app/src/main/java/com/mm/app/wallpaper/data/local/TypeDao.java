package com.mm.app.wallpaper.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.mm.app.wallpaper.data.model.Type;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface TypeDao {

    @Query("SELECT * FROM type")
    Flowable<List<Type>> getAllType();

    @Insert
    void insertTypes(Type... types);

    @Query("DELETE FROM type")
    void clearAll();
}

package com.mm.app.wallpaper.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "type")
public class Type {

    @ColumnInfo(name = "id")
    @PrimaryKey
    @NonNull
    private String id = "";

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "cover_url")
    private String coverUrl;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}

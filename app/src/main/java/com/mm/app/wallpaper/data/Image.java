package com.mm.app.wallpaper.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "image")
public class Image {

    @ColumnInfo(name = "id")
    @PrimaryKey
    @NonNull
    private String id = "";

    @ColumnInfo(name = "url")
    private String url;

    @ColumnInfo(name = "page")
    private int page;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

package com.mm.app.wallpaper.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mm.app.wallpaper.data.Type;

import me.drakeet.multitype.ItemViewBinder;


public class TypeVB extends ItemViewBinder<Type,TypeVB.VH> {

    @NonNull
    @Override
    protected VH onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return null;
    }

    @Override
    protected void onBindViewHolder(@NonNull VH holder, @NonNull Type item) {

    }

    static class VH extends RecyclerView.ViewHolder{

        VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}

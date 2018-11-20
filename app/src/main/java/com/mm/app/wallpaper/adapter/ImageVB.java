package com.mm.app.wallpaper.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mm.app.wallpaper.R;
import com.mm.app.wallpaper.data.Image;
import com.mm.app.wallpaper.support.glide.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;


public class ImageVB extends ItemViewBinder<Image, ImageVB.VH> {

    @NonNull
    @Override
    protected VH onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.image_list_item, parent, false);
        return new VH(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull VH holder, @NonNull Image item) {
        GlideApp
                .with(holder.itemImage)
                .load(item.getUrl())
//                .centerCrop()
                .into(holder.itemImage);
    }

    static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_image)
        ImageView itemImage;

        VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

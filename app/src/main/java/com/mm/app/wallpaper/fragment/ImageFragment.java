package com.mm.app.wallpaper.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mm.app.wallpaper.adapter.ImageVB;
import com.mm.app.wallpaper.base.ListFragment;
import com.mm.app.wallpaper.data.Image;
import com.mm.app.wallpaper.support.rv.GridDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;


public class ImageFragment extends ListFragment {

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(getHostActivity(),2);
    }

    @Override
    public void renderViews(View view) {
        super.renderViews(view);

        addItemDecoration(new GridDividerItemDecoration(getHostActivity(),2));
        setUseRefresh(true);
        setUseLoadMore(true);

        registerItemWithVH(Image.class,new ImageVB());

        List<Image> images = new ArrayList<>();
        Image image;
        for (int i = 0; i < 30; i++) {
            image = new Image();
            image.setId("1" + i);
            image.setUrl("http://wx2.sinaimg.cn/mw690/795c59cbgy1fe180aq1huj21kw0zkgln.jpg");
            image.setPage(1);
            images.add(image);
        }
        for (int i = 0; i < 30; i++) {
            image = new Image();
            image.setId("2" + i);
            image.setUrl("http://wx3.sinaimg.cn/mw690/795c59cbgy1fe1808b2stj21hc1hc4qs.jpg");
            image.setPage(2);
            images.add(image);
        }

        getMultiTypeAdapter().setItems(images);
        getMultiTypeAdapter().notifyDataSetChanged();
    }

    @Override
    public void onSwipeRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}

package com.mm.app.wallpaper.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment {

    private Activity mHost;

    private Unbinder mUnbinder;

    public Activity getHostActivity() {
        return mHost;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            mHost = (Activity) context;
        } else {
            throw new RuntimeException("attach host activity error.");
        }
    }

    /**
     * 获取 Fragment 视图 ID
     *
     * @return 视图 ID
     */
    public abstract int getFragmentViewId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentViewId(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        renderViews(view);
        return view;
    }

    /**
     * 初始化 Views
     *
     * @param view 根 View
     */
    public abstract void renderViews(View view);

    /**
     * 处理回退事件
     *
     * @return true 表示该 Fragment 可以回退，false 表示不能回退
     */
    public boolean canBackPress() {
        return false;
    }

    /**
     * 处理回退事件，拦截宿主 Activity 的回退事件，由 Fragment 处理
     */
    public void onBackPress() {

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mHost = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

}

package com.mm.app.wallpaper.support.rv;

import android.support.v4.widget.SwipeRefreshLayout;

public class SwipeRefreshDelegate {

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private OnSwipeRefreshListener providedListener;

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            if (providedListener != null) {
                providedListener.onSwipeRefresh();
            }
        }
    };

    public interface OnSwipeRefreshListener {

        void onSwipeRefresh();
    }

    public void attach(SwipeRefreshLayout swipeRefreshLayout, OnSwipeRefreshListener swipeRefreshListener) {
        mSwipeRefreshLayout = swipeRefreshLayout;
        providedListener = swipeRefreshListener;
        trySetupSwipeRefresh();
    }

    private void trySetupSwipeRefresh() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);
        }
    }

    public void setRefresh(boolean requestDataRefresh) {
        if (mSwipeRefreshLayout == null) {
            return;
        }
        if (!requestDataRefresh) {
            mSwipeRefreshLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mSwipeRefreshLayout != null) {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }
            }, 1000);
        } else {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    public void setColorSchemeColors(int... colors) {
        mSwipeRefreshLayout.setColorSchemeColors(colors);
    }

    public void setEnabled(boolean enable) {
        if (mSwipeRefreshLayout == null) {
            throw new IllegalAccessError("The SwipeRefreshLayout has not been initialized.");
        }
        mSwipeRefreshLayout.setEnabled(enable);
    }


    public boolean isShowingRefresh() {
        return mSwipeRefreshLayout.isRefreshing();
    }


    public void setProgressViewOffset(boolean scale, int start, int end) {
        mSwipeRefreshLayout.setProgressViewOffset(scale, start, end);
    }
}

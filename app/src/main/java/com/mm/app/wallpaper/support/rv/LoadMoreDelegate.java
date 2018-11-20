package com.mm.app.wallpaper.support.rv;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;

public class LoadMoreDelegate {

    private boolean mIsLoading = false;
    private LoadMoreListener mLoadMoreListener;
    private boolean mUse = false;

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            if (recyclerView.getLayoutManager() == null) {
                return;
            }

            if (SCROLL_STATE_IDLE == newState && !mIsLoading) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int lastCompletePosition = -1;
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    lastCompletePosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) layoutManager;
                    int[] lastPos = manager.findLastCompletelyVisibleItemPositions(new int[manager.getSpanCount()]);
                    int maxVal = Integer.MIN_VALUE;
                    for (int pos : lastPos) {
                        if (pos > maxVal) {
                            maxVal = pos;
                        }
                    }
                    lastCompletePosition = maxVal;
                }

                if (lastCompletePosition == layoutManager.getItemCount() - 1) {
                    if (mLoadMoreListener != null) {
                        mIsLoading = true;
                        if (mUse){
                            mLoadMoreListener.onLoadMore();
                        }
                    }
                }
            }
        }
    };

    public interface LoadMoreListener {

        void onLoadMore();
    }

    public void attach(RecyclerView recyclerView, LoadMoreListener loadMoreListener) {
        mLoadMoreListener = loadMoreListener;
        recyclerView.addOnScrollListener(mOnScrollListener);
    }

    public boolean isLoading() {
        return mIsLoading;
    }

    public void setLoadingFinished() {
        mIsLoading = false;
    }

    public void setEnable(boolean enable) {
        mUse = enable;
    }
}

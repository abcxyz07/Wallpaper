package com.mm.app.wallpaper.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alipictures.statemanager.StateLayout;
import com.alipictures.statemanager.state.CoreState;
import com.mm.app.wallpaper.R;
import com.mm.app.wallpaper.support.rv.LoadMoreDelegate;
import com.mm.app.wallpaper.support.rv.SwipeRefreshDelegate;
import com.mm.app.wallpaper.support.state.ExceptionState;
import com.mm.app.wallpaper.support.state.LoadingState;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.MultiTypeAdapter;

public abstract class ListFragment extends BaseFragment implements SwipeRefreshDelegate.OnSwipeRefreshListener, LoadMoreDelegate.LoadMoreListener {

    @BindView(R.id.state_layout)
    StateLayout mStateLayout;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mListView;

    private MultiTypeAdapter mMultiTypeAdapter = new MultiTypeAdapter();

    private SwipeRefreshDelegate mSwipeRefreshDelegate;
    private LoadMoreDelegate mLoadMoreDelegate;

    @Override
    public int getFragmentViewId() {
        return R.layout.fragment_list;
    }

    @Override
    public void renderViews(View view) {
        mSwipeRefreshLayout.setColorSchemeColors(
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent)
        );
        mSwipeRefreshDelegate = new SwipeRefreshDelegate();
        mSwipeRefreshDelegate.attach(mSwipeRefreshLayout, this);

        mListView.setLayoutManager(getLayoutManager());

        mListView.setHasFixedSize(true);
        mLoadMoreDelegate = new LoadMoreDelegate();
        mLoadMoreDelegate.attach(mListView, this);

        mListView.setAdapter(mMultiTypeAdapter);
    }

    public abstract RecyclerView.LayoutManager getLayoutManager();

    public void registerItemWithVH(Class<?> clz, ItemViewBinder binder) {
        mMultiTypeAdapter.register(clz, binder);
    }

    public MultiTypeAdapter getMultiTypeAdapter() {
        return mMultiTypeAdapter;
    }

    public void setUseRefresh(boolean use) {
        mSwipeRefreshDelegate.setEnabled(use);
    }

    public void setUseLoadMore(boolean use) {
        mLoadMoreDelegate.setEnable(use);
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration, int index) {
        mListView.addItemDecoration(itemDecoration, index);
    }

    @Override
    public void onSwipeRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    public void onRefreshEnd() {
        mSwipeRefreshDelegate.setRefresh(false);
    }

    public void onLoadMoreEnd() {
        mLoadMoreDelegate.setLoadingFinished();
    }

    public void showStateLoading() {
        mStateLayout.showState(LoadingState.STATE);
    }

    public void showStateException() {
        mStateLayout.showState(ExceptionState.STATE);
    }

    public void showStateBiz() {
        mStateLayout.showState(CoreState.STATE);
    }
}

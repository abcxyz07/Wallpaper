package com.mm.app.wallpaper.support.state;

import android.view.View;

import com.alipictures.statemanager.state.BaseState;
import com.mm.app.wallpaper.R;


public class LoadingState extends BaseState {

    public static final String STATE = "LoadingState";

    public static final String EVENT_CLICK = "LoadingState_CLICK";

    @Override
    protected int getLayoutId() {
        return R.layout.state_loading;
    }

    @Override
    protected void onViewCreated(View stateView) {
        stateView.findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stateEventListener != null) {
                    stateEventListener.onEventListener(EVENT_CLICK, view);
                }
            }
        });
    }

    @Override
    public String getState() {
        return STATE;
    }

}

package com.mm.app.wallpaper.support.state;

import android.view.View;

import com.alipictures.statemanager.state.BaseState;
import com.mm.app.wallpaper.R;


public class ExceptionState extends BaseState {

    public static final String STATE = "ExceptionState";

    @Override
    protected int getLayoutId() {
        return R.layout.state_exception;
    }

    @Override
    protected void onViewCreated(View stateView) {
        stateView.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stateEventListener != null) {
                    stateEventListener.onEventListener(STATE, view);
                }
            }
        });
    }

    @Override
    public String getState() {
        return STATE;
    }
}

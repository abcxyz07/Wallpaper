package com.mm.app.wallpaper;

import android.app.Application;

import com.alipictures.statemanager.loader.StateRepository;
import com.mm.app.wallpaper.support.state.ExceptionState;
import com.mm.app.wallpaper.support.state.LoadingState;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        regStateManager();
    }

    private void regStateManager(){
        StateRepository.registerState(LoadingState.STATE,LoadingState.class);
        StateRepository.registerState(ExceptionState.STATE,ExceptionState.class);
    }
}

package com.mm.app.wallpaper;

import com.alipictures.statemanager.loader.StateRepository;
import com.mm.app.wallpaper.base.BaseApplication;
import com.mm.app.wallpaper.di.AppInjector;
import com.mm.app.wallpaper.support.state.ExceptionState;
import com.mm.app.wallpaper.support.state.LoadingState;


public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        regStateManager();
        AppInjector.init(this);
    }

    private void regStateManager(){
        StateRepository.registerState(LoadingState.STATE,LoadingState.class);
        StateRepository.registerState(ExceptionState.STATE,ExceptionState.class);
    }
}

package app.motaz.com.jitensha;

import android.app.Application;

import app.motaz.com.jitensha.config.Constants;
import app.motaz.com.jitensha.dagger.components.AppComponent;
import app.motaz.com.jitensha.dagger.components.DaggerAppComponent;
import app.motaz.com.jitensha.dagger.modules.AppModule;
import app.motaz.com.jitensha.dagger.modules.NetModule;
import app.motaz.com.jitensha.dagger.modules.PresenterModule;

/**
 * Created by motaz on 6/4/17.
 */

public class JitenshaApp extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(Constants.BASE_URL + Constants.API))
                .presenterModule(new PresenterModule()).build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

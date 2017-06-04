package app.motaz.com.jitensha;

import android.app.Application;

import app.motaz.com.jitensha.config.Constants;
import app.motaz.com.jitensha.dagger.components.DaggerNetComponent;
import app.motaz.com.jitensha.dagger.components.NetComponent;
import app.motaz.com.jitensha.dagger.modules.AppModule;
import app.motaz.com.jitensha.dagger.modules.NetModule;

/**
 * Created by motaz on 6/4/17.
 */

public class JitenshaApp extends Application {
    public NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(Constants.baseUrl + Constants.api))
                .build();

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}

package app.motaz.com.jitensha.dagger.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by motaz on 6/4/17.
 */
@Module
public class AppModule {
    Application mApplication;

    @Inject
    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return mApplication;
    }
}

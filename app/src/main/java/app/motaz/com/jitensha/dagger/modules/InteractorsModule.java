package app.motaz.com.jitensha.dagger.modules;

import android.content.Context;

import app.motaz.com.jitensha.interactor.AuthInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * Created by motaz on 6/7/17.
 */

@Module
public class InteractorsModule {
    @Provides
    AuthInteractor providesInteractor(Context application) {
        return new AuthInteractor(application);
    }
}

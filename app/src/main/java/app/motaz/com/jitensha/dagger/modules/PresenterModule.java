package app.motaz.com.jitensha.dagger.modules;

import android.content.Context;

import app.motaz.com.jitensha.presenters.LoginPresenter;
import app.motaz.com.jitensha.presenters.interfaces.LoginPresenterInterface;
import dagger.Module;
import dagger.Provides;

/**
 * Created by motaz on 6/7/17.
 */

@Module
public class PresenterModule {

    @Provides
    LoginPresenterInterface providesLoginPresenter(Context context) {
        return new LoginPresenter(context);
    }
}

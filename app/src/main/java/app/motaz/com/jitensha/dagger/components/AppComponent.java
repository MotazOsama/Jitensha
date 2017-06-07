package app.motaz.com.jitensha.dagger.components;

import javax.inject.Singleton;

import app.motaz.com.jitensha.dagger.modules.AppModule;
import app.motaz.com.jitensha.dagger.modules.InteractorsModule;
import app.motaz.com.jitensha.dagger.modules.NetModule;
import app.motaz.com.jitensha.dagger.modules.PresenterModule;
import app.motaz.com.jitensha.dataaccesslayer.api.APIDataManager;
import app.motaz.com.jitensha.interactor.AuthInteractor;
import app.motaz.com.jitensha.presenters.LoginPresenter;
import app.motaz.com.jitensha.view.activities.LoginActivity;
import dagger.Component;

/**
 * Created by motaz on 6/7/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class, PresenterModule.class,
        InteractorsModule.class})
public interface AppComponent {

    void inject(LoginActivity loginActivity);

    void inject(LoginPresenter loginPresenter);

    void inject(AuthInteractor authInteractor);

    void inject(APIDataManager apiDataManager);
}

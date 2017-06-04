package app.motaz.com.jitensha.dagger.components;

import javax.inject.Singleton;

import app.motaz.com.jitensha.dagger.modules.AppModule;
import app.motaz.com.jitensha.dagger.modules.NetModule;
import app.motaz.com.jitensha.view.activities.LoginActivity;
import dagger.Component;

/**
 * Created by motaz on 6/4/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(LoginActivity loginActivity);
}

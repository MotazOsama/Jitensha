package app.motaz.com.jitensha.presenters;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import app.motaz.com.jitensha.JitenshaApp;
import app.motaz.com.jitensha.config.Constants;
import app.motaz.com.jitensha.interactor.AuthInteractor;
import app.motaz.com.jitensha.presenters.interfaces.LoginPresenterInterface;
import app.motaz.com.jitensha.view.interfaces.LoginViewInterface;

/**
 * Created by motaz on 6/6/17.
 */

public class LoginPresenter implements LoginPresenterInterface<LoginViewInterface> {

    private LoginViewInterface mView;
    private String TAG = LoginPresenter.class.getName();

    @Inject
    AuthInteractor authInteractor;

    public LoginPresenter(Context context) {
        ((JitenshaApp) context).getAppComponent().inject(this);
    }


    @Override
    public void usernameTextFieldChanged(String username) {

    }

    @Override
    public void passwordTextFieldChanged(String password) {

    }

    @Override
    public void loginBtnClicked() {
        Log.d(TAG, "loginBtnClicked: ");
        authInteractor.login(Constants.username, Constants.password);
    }

    @Override
    public void setView(LoginViewInterface view) {
        this.mView = view;

    }
}

package app.motaz.com.jitensha.presenters;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import app.motaz.com.jitensha.JitenshaApp;
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
    private String email;
    private String password;

    public LoginPresenter(Context context) {
        ((JitenshaApp) context).getAppComponent().inject(this);
    }


    @Override
    public void emailTextFieldChanged(String email) {
        this.email = email;
        validateForm();
    }

    @Override
    public void passwordTextFieldChanged(String password) {
        this.password = password;
        validateForm();
    }

    private void validateForm() {
        if (this.email != null && email.length() > 0
                && this.password != null && this.password.length() > 0)
            getView().enableLoginBtn(true);

    }

    @Override
    public void loginBtnClicked() {
        Log.d(TAG, "loginBtnClicked: ");
        authInteractor.login(email, password);
    }

    public LoginViewInterface getView() {
        return mView;
    }

    @Override
    public void setView(LoginViewInterface view) {
        this.mView = view;

    }
}

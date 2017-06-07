package app.motaz.com.jitensha.view.activities;

import android.os.Bundle;

import javax.inject.Inject;

import app.motaz.com.jitensha.JitenshaApp;
import app.motaz.com.jitensha.presenters.interfaces.LoginPresenterInterface;
import app.motaz.com.jitensha.view.interfaces.LoginViewInterface;

/**
 * Created by motaz on 6/5/17.
 */

public class LoginActivity extends BaseActivity implements LoginViewInterface {
    @Inject
    LoginPresenterInterface loginPresenter;

    private String TAG = LoginActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((JitenshaApp) getApplication()).getAppComponent().inject(this);
        loginPresenter.setView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter.loginBtnClicked();
    }

    @Override
    public void showSuccessMsg(String successMsg) {

    }

    @Override
    public void showFailureMsg(String errorMsg) {

    }
}

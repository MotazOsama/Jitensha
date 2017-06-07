package app.motaz.com.jitensha.presenters.interfaces;

import app.motaz.com.jitensha.view.interfaces.LoginViewInterface;

/**
 * Created by motaz on 6/6/17.
 */

public interface LoginPresenterInterface<V extends LoginViewInterface> {
    void usernameTextFieldChanged(String username);

    void passwordTextFieldChanged(String password);

    void loginBtnClicked();

    void setView(V view);
}

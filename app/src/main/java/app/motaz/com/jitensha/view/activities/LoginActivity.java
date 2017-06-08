package app.motaz.com.jitensha.view.activities;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import app.motaz.com.jitensha.JitenshaApp;
import app.motaz.com.jitensha.R;
import app.motaz.com.jitensha.presenters.interfaces.LoginPresenterInterface;
import app.motaz.com.jitensha.view.interfaces.LoginViewInterface;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by motaz on 6/5/17.
 */

public class LoginActivity extends BaseActivity implements LoginViewInterface, TextWatcher {
    @Inject
    LoginPresenterInterface loginPresenter;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    AppCompatButton btnLogin;

    private String TAG = LoginActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((JitenshaApp) getApplication()).getAppComponent().inject(this);
        loginPresenter.setView(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        etEmail.addTextChangedListener(this);
        etPassword.addTextChangedListener(this);
        btnLogin.setOnClickListener(this::loginBtnClicked);
    }

    private void loginBtnClicked(View view) {
        loginPresenter.loginBtnClicked();
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

    @Override
    public void enableLoginBtn(boolean btnStatus) {
        btnLogin.setEnabled(btnStatus);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        loginPresenter.emailTextFieldChanged(etEmail.getText().toString());
        loginPresenter.passwordTextFieldChanged(etPassword.getText().toString());
    }
}

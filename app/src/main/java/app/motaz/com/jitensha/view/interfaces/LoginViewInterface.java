package app.motaz.com.jitensha.view.interfaces;

/**
 * Created by motaz on 6/6/17.
 */

public interface LoginViewInterface {

    void showSuccessMsg(String successMsg);

    void showFailureMsg(String errorMsg);

    void enableLoginBtn(boolean btnStatus);
}

package app.motaz.com.jitensha.interactor;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import app.motaz.com.jitensha.JitenshaApp;
import app.motaz.com.jitensha.dataaccesslayer.api.APIDataManager;

/**
 * Created by motaz on 6/6/17.
 */

public class AuthInteractor {
    private Context mContext;
    private String TAG = AuthInteractor.class.getName();

    @Inject
    APIDataManager apiDataManager;

    public AuthInteractor(Context context) {
        this.mContext = context;
        ((JitenshaApp) context).getAppComponent().inject(this);
    }

    public void login(String userName, String password) {
        Log.d(TAG, "login: ");
        apiDataManager.login(userName, password);
    }

    public void saveAuthTokenInPreferences(String authToken) {

    }
}

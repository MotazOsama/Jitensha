package app.motaz.com.jitensha.dataaccesslayer.api;

import android.content.Context;

import com.google.android.agera.Result;
import com.google.android.agera.Supplier;

import javax.inject.Inject;

import app.motaz.com.jitensha.JitenshaApp;
import app.motaz.com.jitensha.dataaccesslayer.interfaces.API;
import app.motaz.com.jitensha.models.AuthRequest;
import app.motaz.com.jitensha.models.AuthResponse;
import retrofit2.Retrofit;

/**
 * Created by motaz on 6/7/17.
 */

public class APIDataManager {

    private static final String TAG = APIDataManager.class.getName();
    @Inject
    Retrofit retrofit;

    public APIDataManager(Context context) {
        ((JitenshaApp) context).getAppComponent().inject(this);
    }

    public Supplier<Result<AuthResponse>> login(String username, String password) {
        API api = retrofit.create(API.class);
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail(username);
        authRequest.setPassword(password);
        return api.login(authRequest);
    }

}

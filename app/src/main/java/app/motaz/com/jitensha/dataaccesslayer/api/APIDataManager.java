package app.motaz.com.jitensha.dataaccesslayer.api;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import app.motaz.com.jitensha.JitenshaApp;
import app.motaz.com.jitensha.dataaccesslayer.api.interfaces.API;
import app.motaz.com.jitensha.models.AuthRequest;
import app.motaz.com.jitensha.models.AuthResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

    public void login(String username, String password) {
        API api = retrofit.create(API.class);
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail(username);
        authRequest.setPassword(password);
        Call<AuthResponse> call = api.login(authRequest);
        call.enqueue(new Callback<AuthResponse>() {

            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                Log.d(TAG, "onResponse: " + response.body().getAccessToken());
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Log.d(TAG, "onError: " + "error in login request.");

            }
        });

    }


}

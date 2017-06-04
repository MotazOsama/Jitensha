package app.motaz.com.jitensha.view.activities;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import app.motaz.com.jitensha.JitenshaApp;
import app.motaz.com.jitensha.dataaccesslayer.api.API;
import app.motaz.com.jitensha.models.AuthRequest;
import app.motaz.com.jitensha.models.AuthResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by motaz on 6/5/17.
 */

public class LoginActivity extends BaseActivity {
    @Inject
    Retrofit retrofit;
    private String TAG = LoginActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((JitenshaApp) getApplication()).getNetComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        API api = retrofit.create(API.class);
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail("crossover@ibtikar.net.sa");
        authRequest.setPassword("crossover");
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

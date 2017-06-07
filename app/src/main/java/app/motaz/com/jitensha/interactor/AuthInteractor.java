package app.motaz.com.jitensha.interactor;

import android.content.Context;
import android.util.Log;

import com.google.android.agera.Repository;
import com.google.android.agera.Result;
import com.google.android.agera.Supplier;

import javax.inject.Inject;

import app.motaz.com.jitensha.JitenshaApp;
import app.motaz.com.jitensha.dataaccesslayer.RepositriesFactory.RepositoriesFactory;
import app.motaz.com.jitensha.dataaccesslayer.api.APIDataManager;
import app.motaz.com.jitensha.models.AuthResponse;

/**
 * Created by motaz on 6/6/17.
 */

public class AuthInteractor {
    private Context mContext;
    private String TAG = AuthInteractor.class.getName();
    private Repository<Result<AuthResponse>> repository;
    @Inject
    APIDataManager apiDataManager;

    public AuthInteractor(Context context) {
        this.mContext = context;
        ((JitenshaApp) context).getAppComponent().inject(this);
    }

    public void login(String userName, String password) {
        Log.d(TAG, "login: ");
        Supplier<Result<AuthResponse>> supplier = apiDataManager.login(userName, password);
        repository = new RepositoriesFactory<AuthResponse>().createRepository(supplier);
        repository.addUpdatable(() -> {
            if (repository.get().isPresent() && repository.get().succeeded()) {
                AuthResponse authResponse = repository.get().get();
                Log.d(TAG, "login: " + authResponse.getAccessToken());
            }
        });
    }

    public void saveAuthTokenInPreferences(String authToken) {

    }
}

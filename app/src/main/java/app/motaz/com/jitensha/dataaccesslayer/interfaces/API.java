package app.motaz.com.jitensha.dataaccesslayer.interfaces;

import com.google.android.agera.Result;
import com.google.android.agera.Supplier;

import app.motaz.com.jitensha.models.AuthRequest;
import app.motaz.com.jitensha.models.AuthResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by motaz on 6/5/17.
 */

public interface API {
    @POST("auth")
    Supplier<Result<AuthResponse>> login(@Body AuthRequest authRequest);
}

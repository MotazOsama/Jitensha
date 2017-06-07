package app.motaz.com.jitensha.dataaccesslayer.RepositriesFactory;

import com.google.android.agera.Repositories;
import com.google.android.agera.Repository;
import com.google.android.agera.Result;
import com.google.android.agera.Supplier;

import java.util.concurrent.Executors;

/**
 * Created by motaz on 6/8/17.
 */

public class RepositoriesFactory<T> {
    public Repository<Result<T>> createRepository(Supplier<Result<T>> supplier) {
        return Repositories.repositoryWithInitialValue(Result.<T>absent())
                .observe()
                .onUpdatesPerLoop()
                .goTo(Executors.newSingleThreadExecutor())
                .attemptGetFrom(supplier)
                .orEnd(input -> Result.failure(input))
                .thenTransform(input -> Result.success(input))
                .compile();
    }
}

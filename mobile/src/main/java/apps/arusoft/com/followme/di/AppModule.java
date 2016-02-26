package apps.arusoft.com.followme.di;

import android.app.Application;

import com.firebase.client.Firebase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose.ramos on 25/02/2016.
 */
@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
        Firebase.setAndroidContext(application);
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }
}

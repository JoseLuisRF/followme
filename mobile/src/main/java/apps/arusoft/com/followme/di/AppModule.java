package apps.arusoft.com.followme.di;

import android.app.Application;

import com.firebase.client.Firebase;

import javax.inject.Singleton;

import apps.arusoft.com.followme.R;
import apps.arusoft.com.followme.managers.FollowMeManager;
import apps.arusoft.com.followme.managers.FollowMeManagerImpl;
import apps.arusoft.com.followme.managers.login.LoginApiManager;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jose.ramos on 25/02/2016.
 */
@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
        Firebase.setAndroidContext(application);
    }

    @Provides
    @Singleton
    public Application providesApplication() {
        return mApplication;
    }

}

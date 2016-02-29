package apps.arusoft.com.followme.di;

import android.app.Application;

import com.firebase.client.Firebase;

import javax.inject.Singleton;

import apps.arusoft.com.followme.R;
import apps.arusoft.com.followme.managers.FollowMeManager;
import apps.arusoft.com.followme.managers.FollowMeManagerImpl;
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
    public Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    public FollowMeManager getFollowMeManager() {
        return new FollowMeManagerImpl();
    }

    @Provides
    @Singleton
    public Firebase getFireBase() {
        return new Firebase(mApplication.getString(R.string.app_firebase_url));
    }

}

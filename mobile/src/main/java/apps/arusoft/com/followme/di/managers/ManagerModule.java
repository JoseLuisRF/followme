package apps.arusoft.com.followme.di.managers;

import android.app.Application;

import com.firebase.client.Firebase;

import javax.inject.Singleton;

import apps.arusoft.com.followme.R;
import apps.arusoft.com.followme.api.OnFinishCallsListener;
import apps.arusoft.com.followme.managers.FollowMeManager;
import apps.arusoft.com.followme.managers.FollowMeManagerImpl;
import apps.arusoft.com.followme.managers.login.LoginApiManager;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jose.ramos on 25/02/2016.
 */
@Module
public class ManagerModule {

    @Provides
    @Singleton
    FollowMeManager providesFollowMeManager(){
        return new FollowMeManagerImpl();
    }

    @Provides
    @Singleton
    public Firebase getFireBase(Application application) {
        return new Firebase(application.getString(R.string.app_firebase_url));
    }

    @Provides
    @Singleton
    public LoginApiManager getLoginManager(Application application) {
        return new LoginApiManager(application);
    }
}

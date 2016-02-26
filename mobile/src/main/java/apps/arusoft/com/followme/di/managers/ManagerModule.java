package apps.arusoft.com.followme.di.managers;

import javax.inject.Singleton;

import apps.arusoft.com.followme.api.OnFinishCallsListener;
import apps.arusoft.com.followme.managers.FollowMeManager;
import apps.arusoft.com.followme.managers.FollowMeManagerImpl;
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
}

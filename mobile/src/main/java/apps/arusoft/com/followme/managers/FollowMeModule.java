package apps.arusoft.com.followme.managers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose.ramos on 26/02/2016.
 */
@Module
public class FollowMeModule {

    @Provides
    @Singleton
    public FollowMeManager getFollowMeManager() {
        return new FollowMeManagerImpl();
    }
}

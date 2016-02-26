package apps.arusoft.com.followme.managers;

import apps.arusoft.com.followme.api.OnFinishCallsListener;

/**
 * Created by jose.ramos on 25/02/2016.
 */
public class FollowMeManagerImpl implements FollowMeManager {
    private OnFinishCallsListener callsListener;
    private static FollowMeManager instance;


    @Override
    public void registerUser(String username, String email, String password, String confirmPassword) {

    }
}

package apps.arusoft.com.followme.api;

import apps.arusoft.com.followme.models.Response;
import apps.arusoft.com.followme.models.User;

/**
 * Created by jose.ramos on 25/02/2016.
 */
public interface FollowMeApi {
    void signUp(User user);
    void login(String mail, String password);
}

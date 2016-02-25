package apps.arusoft.com.followme.register;

import apps.arusoft.com.followme.api.OnFinishCallsListener;
import apps.arusoft.com.followme.managers.FollowMeManager;
import apps.arusoft.com.followme.managers.FollowMeManagerImpl;
import apps.arusoft.com.followme.models.Response;

/**
 * Created by jose.ramos on 25/02/2016.
 */
public class RegisterPresenter implements OnFinishCallsListener {
    private RegisterView registerView;
    private FollowMeManager followMeManager;

    public RegisterPresenter(RegisterView registerView, FollowMeManager followMeManager){
        this.registerView = registerView;
        this.followMeManager = followMeManager;
    }

    public void signUpUser(String username, String mail, String password, String confirmPassword){
        registerView.showLoader();

    }

    @Override
    public void onFinishRegister(Response response) {
        registerView.dismissLoader();
    }


}

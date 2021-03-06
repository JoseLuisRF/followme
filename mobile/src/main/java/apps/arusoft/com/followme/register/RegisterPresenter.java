package apps.arusoft.com.followme.register;

import android.app.Fragment;

import javax.inject.Inject;

import apps.arusoft.com.followme.CustomApplication;
import apps.arusoft.com.followme.api.OnFinishCallsListener;
import apps.arusoft.com.followme.managers.FollowMeManager;
import apps.arusoft.com.followme.models.Response;
import apps.arusoft.com.followme.ui.Navigator;

/**
 * Created by jose.ramos on 25/02/2016.
 */
public class RegisterPresenter implements OnFinishCallsListener {

    @Inject
    FollowMeManager followMeManager;
    private RegisterView registerView;

    public RegisterPresenter(RegisterView registerView) {
        ((CustomApplication) ((RegisterFragment) registerView).getActivity().getApplication()).getAppComponent().inject(this);
        this.registerView = registerView;
    }

    public void signUpUser(String username, String mail, String password, String confirmPassword) {
        registerView.showLoader();
        //followMeManager.registerUser(username,mail,password,confirmPassword);

    }

    @Override
    public void onFinishRegister(Response response) {
        registerView.dismissLoader();
    }
}

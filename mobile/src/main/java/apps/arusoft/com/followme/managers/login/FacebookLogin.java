package apps.arusoft.com.followme.managers.login;

import android.app.Activity;
import android.app.Application;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;

/**
 * Created by jose.ramos on 14/03/2016.
 */
public class FacebookLogin implements Login {

    private CallbackManager callbackManager;

    public FacebookLogin(Application application){
        FacebookSdk.sdkInitialize(application);
        callbackManager = CallbackManager.Factory.create();

    }
}

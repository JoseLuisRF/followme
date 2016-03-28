package apps.arusoft.com.followme.managers.login;

import android.app.Application;

/**
 * Created by jose.ramos on 14/03/2016.
 */
public class LoginApiManager {
    private Application application;

    public LoginApiManager(Application application) {
        this.application = application;
    }

    public LoginApi getFacebookLogin() {
        return FacebookLoginApiImpl.newInstance(application);
    }

    public LoginApi getAFILogin(){
        return null;
    }
}

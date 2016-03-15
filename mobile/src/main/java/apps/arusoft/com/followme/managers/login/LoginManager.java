package apps.arusoft.com.followme.managers.login;

import android.app.Application;
import android.content.Intent;

/**
 * Created by jose.ramos on 14/03/2016.
 */
public class LoginManager {
    private Application application;

    public interface UIListener {
        void onActivityResult(int requestCode, int resultCode, Intent data);
    }

    public LoginManager(Application application) {
        this.application = application;
    }

    public Login getFacebookLogin() {
        return new FacebookLogin(application);
    }
}

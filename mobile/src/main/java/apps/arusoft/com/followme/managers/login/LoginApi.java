package apps.arusoft.com.followme.managers.login;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.view.View;

/**
 * Created by jose.ramos on 14/03/2016.
 */
public interface LoginApi {
    void onActivityResult(int requestCode, int resultCode, Intent data);
    void login(Fragment fragment);
    void login(Activity activity);
    void logout();
}

package apps.arusoft.com.followme.managers.login;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Intent;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

/**
 * Created by jose.ramos on 14/03/2016.
 */
public class FacebookLoginApiImpl implements LoginApi {

    private CallbackManager callbackManager;
    private static FacebookLoginApiImpl instance;

    public static FacebookLoginApiImpl newInstance(Application application) {
        if (instance == null) {
            instance = new FacebookLoginApiImpl(application);
        }
        return instance;
    }

    private FacebookLoginApiImpl(Application application){
        FacebookSdk.sdkInitialize(application);
        callbackManager = CallbackManager.Factory.create();
        setupLoginCallBack();
    }

    private void setupLoginCallBack(){
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void login(Fragment fragment) {
        LoginManager.getInstance().logInWithReadPermissions(fragment, Arrays.asList("public_profile", "user_friends"));
    }

    @Override
    public void login(Activity activity) {
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("public_profile", "user_friends"));
    }

    @Override
    public void logout() {
        LoginManager.getInstance().logOut();
    }

}

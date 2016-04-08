package apps.arusoft.com.followme.managers.login;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Intent;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by jose.ramos on 14/03/2016.
 */
public class FacebookLoginApiImpl implements LoginApi {

    private static final String TAG = FacebookLoginApiImpl.class.getSimpleName();
    private CallbackManager callbackManager;
    private static FacebookLoginApiImpl instance;
    private LoginListener loginListener;
    private Collection<String> FACEBOOK_PERMISSIONS = Arrays.asList("public_profile", "user_friends");

    public interface LoginListener {
        void onSuccess(Object result);

        void onCancel();

        void onError(Exception exception);
    }

//    public static FacebookLoginApiImpl newInstance(Application application, LoginListener listener) {
//        if (instance == null) {
//            instance = new FacebookLoginApiImpl(application, listener);
//        }
//        return instance;
//    }

    public FacebookLoginApiImpl(Application application, LoginListener listener) {
        Log.i(TAG, "FacebookLoginApiImpl");
        FacebookSdk.sdkInitialize(application);
        callbackManager = CallbackManager.Factory.create();
        loginListener = listener;
        setupLoginCallBack();
    }

    private void setupLoginCallBack(){
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.i(TAG, "FacebookCallback.onSuccess");
                        loginListener.onSuccess(loginResult);
                    }

                    @Override
                    public void onCancel() {
                        Log.i(TAG, "FacebookCallback.onCancel");
                        loginListener.onCancel();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Log.i(TAG, "FacebookCallback.onError");
                        loginListener.onError(exception);
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void login(Fragment fragment) {
        LoginManager.getInstance().logInWithReadPermissions(fragment, FACEBOOK_PERMISSIONS);
    }

    @Override
    public void login(Activity activity) {
        LoginManager.getInstance().logInWithReadPermissions(activity, FACEBOOK_PERMISSIONS);
    }

    public void requierePublishPermissions(Activity activity){
        LoginManager.getInstance().logInWithPublishPermissions(activity, Arrays.asList("publish_actions"));
    }

    @Override
    public void logout() {
        LoginManager.getInstance().logOut();
    }

}

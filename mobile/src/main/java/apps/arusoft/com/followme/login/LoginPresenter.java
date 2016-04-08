package apps.arusoft.com.followme.login;

import android.app.Fragment;
import android.content.Intent;
import android.util.Log;

import com.facebook.login.LoginResult;

import javax.inject.Inject;

import apps.arusoft.com.followme.CustomApplication;
import apps.arusoft.com.followme.managers.login.FacebookLoginApiImpl;
import apps.arusoft.com.followme.managers.login.LoginApi;
import apps.arusoft.com.followme.managers.login.LoginApiManager;
import apps.arusoft.com.followme.ui.Navigator;

/**
 * Created by jose.ramos on 15/03/2016.
 */
public class LoginPresenter implements FacebookLoginApiImpl.LoginListener {

    private static final String TAG = LoginPresenter.class.getSimpleName();
    @Inject
    LoginApiManager loginApiManager;
    private LoginView loginView;
    private Navigator navigator;

    public LoginPresenter(LoginView loginView) {
        ((CustomApplication) ((Fragment) loginView).getActivity().getApplication()).getAppComponent().inject(this);
        this.loginView = loginView;
        navigator = (Navigator) ((Fragment)loginView).getActivity();
    }

    public void signInFacebook() {
        loginApiManager.getFacebookLogin(this).login((Fragment) loginView);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        loginApiManager.getFacebookLogin(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSuccess(Object result) {
        Log.i(TAG, "FacebookLogin onSuccess");
        if( result != null && result instanceof  LoginResult){
            LoginResult loginResult = (LoginResult) result;

        }
        navigator.navigateToHomeFragment();
    }

    @Override
    public void onCancel() {
        Log.i(TAG, "FacebookLogin onCancel");
    }

    @Override
    public void onError(Exception exception) {
        Log.i(TAG, "FacebookLogin onError");
    }
}

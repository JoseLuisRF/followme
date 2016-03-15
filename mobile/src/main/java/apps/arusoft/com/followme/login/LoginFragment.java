package apps.arusoft.com.followme.login;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import javax.inject.Inject;

import apps.arusoft.com.followme.CustomApplication;
import apps.arusoft.com.followme.managers.login.Login;
import apps.arusoft.com.followme.managers.login.LoginManager;
import apps.arusoft.com.followme.ui.BaseFragment;
import apps.arusoft.com.followme.R;
import apps.arusoft.com.followme.ui.Navigator;

/**
 * Created by jose.ramos on 24/02/2016.
 */
public class LoginFragment extends BaseFragment {

    @Inject
    private LoginManager loginManager;
    private Login login;

    private static String TAG = LoginFragment.class.getSimpleName();
    private static LoginFragment instance;
    private Navigator navigator;

    public static Fragment newInstance() {
        if (instance == null) {
            instance = new LoginFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((CustomApplication)getActivity().getApplication()).getAppComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        navigator = (Navigator) getActivity();
        login = loginManager.getFacebookLogin();
        setupUI();

    }

    private void setupUI() {
        LoginButton loginButton = (LoginButton) getView().findViewById(R.id.login_button);
        loginButton.setFragment(this);
        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(facebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "onSuccess");
                navigator.navigateToHomeFragment();
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "onError");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "onError");
                navigator.navigateToRegisterFragment();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        facebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}

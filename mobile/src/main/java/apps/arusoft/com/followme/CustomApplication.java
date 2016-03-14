package apps.arusoft.com.followme;

import android.app.Application;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.firebase.client.Firebase;

import apps.arusoft.com.followme.di.AppComponent;
import apps.arusoft.com.followme.di.AppModule;
import apps.arusoft.com.followme.di.DaggerAppComponent;

/**
 * Created by jose.ramos on 29/02/2016.
 */
public class CustomApplication extends Application {

    private AppComponent component;
    CallbackManager facebookCallbackManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
        facebookCallbackManager = CallbackManager.Factory.create();
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

    }

    public CallbackManager getFacebookCallbackManager(){
        return facebookCallbackManager;
    }

    public AppComponent getAppComponent(){
        return component;
    }
}

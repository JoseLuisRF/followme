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

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        Firebase.setAndroidContext(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
    }

    public AppComponent getAppComponent(){
        return component;
    }
}

package apps.arusoft.com.followme;

import android.app.Application;

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
        Firebase.setAndroidContext(this);
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent(){
        return component;
    }
}

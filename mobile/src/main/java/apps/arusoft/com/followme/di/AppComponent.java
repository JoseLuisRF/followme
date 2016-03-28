package apps.arusoft.com.followme.di;

import javax.inject.Singleton;

import apps.arusoft.com.followme.MainActivity;
import apps.arusoft.com.followme.di.managers.ManagerModule;
import apps.arusoft.com.followme.login.LoginFragment;
import apps.arusoft.com.followme.login.LoginPresenter;
import apps.arusoft.com.followme.register.RegisterFragment;
import apps.arusoft.com.followme.register.RegisterPresenter;
import dagger.Component;

/**
 * Created by jose.ramos on 29/02/2016.
 */
@Singleton
@Component(modules = {AppModule.class , ManagerModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(LoginFragment fragment);

    void inject(RegisterPresenter presenter);
    void inject(LoginPresenter presenter);
}

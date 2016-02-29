package apps.arusoft.com.followme.di;

import javax.inject.Singleton;

import apps.arusoft.com.followme.MainActivity;
import apps.arusoft.com.followme.register.RegisterFragment;
import dagger.Component;

/**
 * Created by jose.ramos on 29/02/2016.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject (RegisterFragment fragment);
}

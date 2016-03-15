package apps.arusoft.com.followme;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.appevents.AppEventsLogger;
import com.firebase.client.Firebase;

import javax.inject.Inject;

import apps.arusoft.com.followme.R;
import apps.arusoft.com.followme.login.LoginFragment;
import apps.arusoft.com.followme.register.RegisterFragment;
import apps.arusoft.com.followme.ui.Navigator;

/**
 * Created by jose.ramos on 24/02/2016.
 */
public class MainActivity extends AppCompatActivity implements Navigator {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((CustomApplication)getApplication()).getAppComponent().inject(this);
        navigateToLoginFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //FB: Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //FB: Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void navigateToRegisterFragment() {
        Fragment fragment = RegisterFragment.newInstance();
        getFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
    }

    @Override
    public void navigateToLoginFragment() {
        Fragment fragment = LoginFragment.newInstance();
        getFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
    }

    @Override
    public void navigateToHomeFragment() {
        Intent intent = new Intent(this, SecondLevelActivity.class);
        startActivity(intent);
    }

}

package apps.arusoft.com.followme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.login.LoginManager;

public class SecondLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_level_activity);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LoginManager.getInstance().logOut();
    }
}

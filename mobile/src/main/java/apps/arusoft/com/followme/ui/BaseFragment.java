package apps.arusoft.com.followme.ui;

import android.app.Fragment;
import android.os.Bundle;

import com.facebook.CallbackManager;

import apps.arusoft.com.followme.CustomApplication;

/**
 * Created by jose.ramos on 14/03/2016.
 */
public class BaseFragment extends Fragment {

    private CustomApplication application;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        application = ((CustomApplication)this.getActivity().getApplication());
    }
}

package apps.arusoft.com.followme.register;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.client.Firebase;

import javax.inject.Inject;

import apps.arusoft.com.followme.CustomApplication;
import apps.arusoft.com.followme.R;

/**
 * Created by jose.ramos on 24/02/2016.
 */
public class RegisterFragment extends Fragment implements RegisterView {

    @Inject
    Firebase firebase;

    private static final String TAG = RegisterFragment.class.getSimpleName();
    private ProgressBar loader;
    private Button singUpButton;
    private RegisterPresenter registerPresenter;
    private EditText userNameEditText;
    private EditText mailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private static RegisterFragment instance;

    public static Fragment newInstance(){
        if( instance == null){
            instance = new RegisterFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((CustomApplication)getActivity().getApplication()).getAppComponent().inject(this);

//        registerPresenter = new RegisterPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);

        TextView textView = (TextView)view.findViewById(R.id.tv_message);
        textView.setText("Dependency Injection worked: " + (firebase == null ? "false" : "true"));
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        View view = getView();
        singUpButton = (Button) view.findViewById(R.id.btn_register_sign_up);
        loader = (ProgressBar) view.findViewById(R.id.pb_loader);
        userNameEditText = (EditText)view.findViewById(R.id.et_register_username);
        mailEditText = (EditText)view.findViewById(R.id.et_register_mail);
        passwordEditText = (EditText)view.findViewById(R.id.et_register_password);
        confirmPasswordEditText = (EditText)view.findViewById(R.id.et_register_confirm_password);
    }

    private void setupListeners(){
        singUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick");
                registerPresenter.signUpUser(userNameEditText.getText().toString(),
                        mailEditText.getText().toString(),
                        passwordEditText.getText().toString(),
                        confirmPasswordEditText.getText().toString());
            }
        });
    }

    @Override
    public void showLoader() {
        loader.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoader() {
        loader.setVisibility(View.INVISIBLE);
    }
}

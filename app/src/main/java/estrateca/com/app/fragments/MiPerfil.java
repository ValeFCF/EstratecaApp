package estrateca.com.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import estrateca.com.app.R;

public class MiPerfil extends Fragment {

    private ProfileTracker profileTracker;
    private AccessTokenTracker accessTokenTracker;
    private LoginButton loginButton;
    private TextView txtUser;

    public static MiPerfil newInstance(Bundle args) {
        MiPerfil fragment = new MiPerfil();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getActivity());

        currentUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mi_perfil, container, false);

        txtUser = (TextView) view.findViewById(R.id.txtUser);

        //LoginManager.getInstance().logOut();
        /*
        LoginManager.getInstance().logInWithReadPermissions(getActivity(), Arrays.asList("public_profile", "user_friends"));

        LoginManager.getInstance().registerCallback( ( (menu)getActivity() ).callbackManager ,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Log.i("registerCallback", "onSuccess");
                        AccessToken accessToken = loginResult.getAccessToken(); //

                    }

                    @Override
                    public void onCancel() {
                        // App code
                        Log.i("registerCallback", "onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Log.i("registerCallback", "onError");
                    }
                });
                */

        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("public_profile","user_friends");
        // If using in a fragment
        //loginButton.setFragment(getActivity());
        // Other app specific specialization

        // Callback registration
        loginButton.registerCallback( ( (estrateca.com.app.menu)getActivity() ).callbackManager ,
                                                            new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("registerCallback", "onSuccess");
                //AccessToken accessToken = loginResult.getAccessToken(); //
                currentUser();
            }

            @Override
            public void onCancel() {
                Log.i("registerCallback", "onCancel");
            }

            @Override
            public void onError(FacebookException exception) {
                Log.i("registerCallback", "onError");
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    private void currentUser() {
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(
                    Profile oldProfile,
                    Profile currentProfile) {
                // App code
                Log.i("currentProfile: ",currentProfile.getName() );
                txtUser.setText("Bienvenido "+currentProfile.getName());
            }
        };

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                // App code
                Log.i("currentAccessToken",currentAccessToken.getUserId() );
            }
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
        profileTracker.startTracking();
    }


}

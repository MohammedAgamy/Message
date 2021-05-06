package com.com.message;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUpFragment extends Fragment implements View.OnClickListener {

    ImageView mLogoApple ;
    Button mBtn_SignUp;
    TextView mLogIn;
    NavController navController;
    TextView mTLogin, mTDils, mCreateAcc, mForgetPass ,dont;
    EditText mEmail, mPass,mName;

    Animation push_lift_email,push_up_btn;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniView(view);
        anim();
    }

    private void iniView(View view) {
        mBtn_SignUp = view.findViewById(R.id.CreatAcc);
        mBtn_SignUp.setOnClickListener(this);
        mLogIn = view.findViewById(R.id.Signin_text);
        mLogIn.setOnClickListener(this);
        mLogoApple = view.findViewById(R.id.logo_apple_s);
        mTLogin = view.findViewById(R.id.login_text_s);
        mTDils = view.findViewById(R.id.welcome_text_S);
        mName = view.findViewById(R.id.name);
        mEmail = view.findViewById(R.id.Email_s);
        mPass = view.findViewById(R.id.password_s);
        dont = view.findViewById(R.id.dontHav);

        navController = Navigation.findNavController(view);

        push_lift_email = AnimationUtils.loadAnimation(getActivity(), R.anim.push_lift_anim);
        push_up_btn = AnimationUtils.loadAnimation(getActivity(), R.anim.push_up_anim);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Signin_text:
                navController.navigate(R.id.action_signUpFragment_to_logInFragment);

                break;
        }


    }


    private void anim() {

        mLogoApple.animate().setDuration(1000).translationY(30).start();
        mTLogin.animate().setDuration(1000).translationY(30).start();
        mTDils.animate().setDuration(1000).translationY(30).start();

        mName.setAnimation(push_lift_email);
        mEmail.setAnimation(push_lift_email);
        mPass.setAnimation(push_lift_email);

        mBtn_SignUp.setAnimation(push_up_btn);
        mLogIn.setAnimation(push_up_btn);
        dont.setAnimation(push_up_btn);



    }
}
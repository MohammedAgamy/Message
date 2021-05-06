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

public class LogInFragment extends Fragment implements View.OnClickListener {
    ImageView mLogoApple;
    Button mBtn_LogIn;
    TextView mTLogin, mTDils, mCreateAcc, mForgetPass ,dont;
    EditText mEmail, mPass;
    NavController navController;

    Animation push_lift_email,push_up_btn;


    public LogInFragment() {
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
        return inflater.inflate(R.layout.fragment_log_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iniView(view);
        anim();
    }


    private void iniView(View view) {
        mBtn_LogIn = view.findViewById(R.id.GoSignIn);
        mBtn_LogIn.setOnClickListener(this);
        mCreateAcc = view.findViewById(R.id.create_text);
        mCreateAcc.setOnClickListener(this);
        mForgetPass = view.findViewById(R.id.forgetpass);
        mForgetPass.setOnClickListener(this);
        mLogoApple = view.findViewById(R.id.logo_apple);
        mTLogin = view.findViewById(R.id.for_text);
        mTDils = view.findViewById(R.id.welcome_text_D);
        mEmail = view.findViewById(R.id.Email);
        mPass = view.findViewById(R.id.password);
        dont=view.findViewById(R.id.dontHav);

        navController = Navigation.findNavController(view);

        push_lift_email = AnimationUtils.loadAnimation(getActivity(), R.anim.push_lift_anim);
        push_up_btn = AnimationUtils.loadAnimation(getActivity(), R.anim.push_up_anim);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.create_text:
                navController.navigate(R.id.action_logInFragment_to_signUpFragment);
                break;
            case R.id.forgetpass:
                navController.navigate(R.id.action_logInFragment_to_forgetPasswordFragment2);
                break;
        }
    }

    private void anim() {

        mLogoApple.animate().setDuration(1000).translationY(50).start();
        mTLogin.animate().setDuration(1000).translationY(50).start();
        mTDils.animate().setDuration(1000).translationY(50).start();


        mEmail.setAnimation(push_lift_email);
        mPass.setAnimation(push_lift_email);

        mBtn_LogIn.setAnimation(push_up_btn);
        mCreateAcc.setAnimation(push_up_btn);
        dont.setAnimation(push_up_btn);



    }
}
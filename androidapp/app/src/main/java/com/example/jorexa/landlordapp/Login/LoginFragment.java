package com.example.jorexa.landlordapp.Login;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jorexa.landlordapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContracts.View {

    @BindView(R.id.et_email) EditText mLoginEmail;
    @BindView(R.id.et_password) EditText mLoginPassword;
    @BindView(R.id.tv_message) TextView mMessage;


    private LoginContracts.Presenter mPresenter;

    @Inject
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadLogin();
    }

    @Override
    public void setPresenter(LoginContracts.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.subscribe(this);
    }

    @Override
    public void showCustomException(String text) {

        runOnUi(() -> {
            //Toast.makeText(getContext(),
            //        text,
            //        Toast.LENGTH_LONG)
            //        .show();
            mMessage.setText(text);
        });

    }

    @OnClick(R.id.btn_login)
    public void signIn(View view) {
        String email = mLoginEmail.getText().toString();
        String password = mLoginPassword.getText().toString();
        mPresenter.signIn(email, password);
    }

    @OnClick(R.id.btn_signUp)
    public void signUp(View view) {
        mPresenter.signUp();
    }

    @Override
    public void showError(Exception e) {
        runOnUi(() ->
                Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                        .show()
        );
    }

    private void runOnUi(Runnable action) {
        getActivity()
                .runOnUiThread(action);
    }
}

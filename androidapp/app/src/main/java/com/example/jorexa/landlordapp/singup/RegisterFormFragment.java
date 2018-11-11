package com.example.jorexa.landlordapp.singup;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jorexa.landlordapp.Constants;
import com.example.jorexa.landlordapp.Login.LoginContracts;
import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.createProperty.CreatePropertyActivity;
import com.example.jorexa.landlordapp.models.LoginUser;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFormFragment extends Fragment implements SignUpContracts.View{
    @BindView(R.id.sign_up_first_name_field)
    EditText mFirstName;
    @BindView(R.id.sign_up_last_name_field)
    EditText mLastName;
    @BindView(R.id.sign_up_email_field)
    EditText mEmail;
    @BindView(R.id.sign_up_password_field)
    EditText mPassword;
    @BindView(R.id.sign_up_confirm_password_field)
    EditText mConfirmPassword;
    @BindView(R.id.sign_up_btn)
    Button mSubmitButton;
    @BindView(R.id.sign_up_error)
    TextView mErrorBox;

    private int typeSelection;
    private SignUpContracts.Presenter mPresenter;
    private LoginContracts.Navigator mNavigator;

    @Inject
    public RegisterFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_form, container, false);

        ButterKnife.bind(this, view);



        return view;
    }

    @OnClick(R.id.sign_up_btn)
    public void submitRegistration(View view){
        String firstName = String.valueOf(mFirstName.getText());
        String lastName = String.valueOf(mLastName.getText());
        String email = String.valueOf(mEmail.getText());
        String password = String.valueOf(mPassword.getText());
        String confirmPassword = String.valueOf(mConfirmPassword.getText());
        mPresenter.onSubmit(firstName, lastName, email, password, confirmPassword, typeSelection);
    }

    @Override
    public void onResume(){
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(SignUpContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showCustomException(String text) {
        runOnUi(()-> Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show());
    }

    @Override
    public void showError(Exception e) {
        runOnUi(()-> Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show());
        throw new RuntimeException(e);
    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radio_landlord:
                if (checked) {
                    typeSelection = 1;
                }
                break;
            case R.id.radio_tenant:
                if (checked) {
                    typeSelection = 2;
                }
                break;
        }
    }

    private void runOnUi(Runnable action){
        getActivity().runOnUiThread(action);
    }

    @Override
    public void displayWrongInformation(String error) {
        runOnUi(()-> Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show());
        mErrorBox.setText(error);
    }

    @Override
    public void openUserProfileActivity(LoginUser mUser) {
        runOnUi(() -> mNavigator.navigateWith(mUser));
    }


    public void setNavigator(LoginContracts.Navigator navigator) {
        mNavigator = navigator;
    }
}

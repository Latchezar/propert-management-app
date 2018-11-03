package com.example.jorexa.landlordapp.singup;


import android.app.Fragment;
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
import com.example.jorexa.landlordapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

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


        mSubmitButton.setOnClickListener(view1 -> {
            String firstName = String.valueOf(mFirstName.getText());
            String lastName = String.valueOf(mLastName.getText());
            String email = String.valueOf(mEmail.getText());
            String password = String.valueOf(mPassword.getText());
            String confirmPassword = String.valueOf(mConfirmPassword.getText());
            mPresenter.onSubmit(firstName, lastName, email, password, confirmPassword, typeSelection);
        });
        return view;
    }

    @Override
    public void setPresenter(SignUpContracts.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.subscribe(this);
    }

    @Override
    public void showCustomException(String text) {

    }

    @Override
    public void showError(Exception e) {

    }

    @Override
    public void displayWrongFirstName() {
        String text = Constants.WRONG_FIRST_NAME;
        displayWrongInformation(text);
    }

    @Override
    public void displayWrongLastName() {
        String text = Constants.WRONG_LAST_NAME;
        displayWrongInformation(text);
    }

    @Override
    public void displayWrongEmail() {
        String text = Constants.WRONG_EMAIL;
        displayWrongInformation(text);
    }

    @Override
    public void displayWrongPassword() {
        String text = Constants.WRONG_PASSWORD;
        displayWrongInformation(text);
    }

    @Override
    public void displayMissMatchPassword() {
        String text = Constants.WRONG_CONFIRM_PASSWORD;
        displayWrongInformation(text);
    }

    @Override
    public void displaySelectType() {
        String text = Constants.WRONG_TYPE;
        displayWrongInformation(text);
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

    private void displayWrongInformation(String error) {
        runOnUi(()-> Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show());
        mErrorBox.setText(error);
    }
}

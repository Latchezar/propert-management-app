package com.example.jorexa.landlordapp.singup;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jorexa.landlordapp.R;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFormFragment extends Fragment implements SignUpContracts.View{

    @Inject
    public RegisterFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_form, container, false);
    }

    @Override
    public void setPresenter(SignUpContracts.Presenter presenter) {

    }

    @Override
    public void showCustomException(String text) {

    }

    @Override
    public void showError(Exception e) {

    }
}

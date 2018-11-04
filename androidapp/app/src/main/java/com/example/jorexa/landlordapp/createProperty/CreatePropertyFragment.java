package com.example.jorexa.landlordapp.createProperty;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.LoginUser;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreatePropertyFragment extends Fragment implements CreatePropertyContracts.View{

    private CreatePropertyContracts.Presenter mPresenter;
    private LoginUser mUser;

    @Inject
    public CreatePropertyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_property, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(CreatePropertyContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showCustomException(String text) {

    }

    @Override
    public void showError(Exception e) {

    }

    @Override
    public void displayWrongInformation(String error) {

    }

    @Override
    public void setUser(LoginUser user) {
        mUser = user;
    }
}

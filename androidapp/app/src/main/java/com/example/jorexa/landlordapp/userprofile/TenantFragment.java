package com.example.jorexa.landlordapp.userprofile;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jorexa.landlordapp.Login.LoginContracts;
import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.Property;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TenantFragment extends Fragment implements UserProfileContracts.View {

    private UserProfileContracts.Presenter mPresenter;

    @Inject
    public TenantFragment() {
        // Required empty public constructor
    }

    @Override
    public void setPresenter(UserProfileContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void showCustomException(String text) {

    }

    @Override
    public void showProperties(List<Property> properties) {

    }

    @Override
    public void showError(Exception e) {

    }

    @Override
    public void showPropertyDetails(Property property) {

    }

    @Override
    public void showEmptyPropertiesList(String message) {

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        //mPresenter.loadLogin();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tenant, container, false);

        ButterKnife.bind(this, view);

        return view;
    }


}

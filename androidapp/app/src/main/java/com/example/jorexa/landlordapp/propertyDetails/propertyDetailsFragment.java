package com.example.jorexa.landlordapp.propertyDetails;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class propertyDetailsFragment extends Fragment implements propertyDetailsContracts.View {

    private propertyDetailsContracts.Presenter mPresenter;

    @Inject
    public propertyDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.getProperty();
    }

    @Override
    public void setPropertyInformation(Property property) {
        int a = 5;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_property_details, container, false);
    }

    @Override
    public void setPresenter(propertyDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    private void runOnUi(Runnable action) {
        getActivity().runOnUiThread(action);
    }
}

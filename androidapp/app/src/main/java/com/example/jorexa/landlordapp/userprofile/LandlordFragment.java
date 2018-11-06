package com.example.jorexa.landlordapp.userprofile;


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
public class LandlordFragment extends Fragment implements UserProfileContracts.View {

    private UserProfileContracts.Presenter mPresenter;

    @Inject
    public LandlordFragment() {
        // Required empty public constructor
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
        return inflater.inflate(R.layout.fragment_landlord, container, false);
    }

    @Override
    public void setPresenter(UserProfileContracts.Presenter presenter) {
        mPresenter = presenter;
    }

}

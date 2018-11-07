package com.example.jorexa.landlordapp.chat;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsContracts;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class chatFragment extends Fragment implements chatContracts.View {

    private chatContracts.Presenter mPresenter;

    @Inject
    public chatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setPresenter(chatContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume(){
        super.onResume();
        mPresenter.subscribe(this);
    }

}

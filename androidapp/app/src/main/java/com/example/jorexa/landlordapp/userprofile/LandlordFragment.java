package com.example.jorexa.landlordapp.userprofile;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jorexa.landlordapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordFragment extends Fragment implements UserProfileContracts.View {

    @BindView(R.id.tv_landlord_title)
    TextView mTitle;

    private UserProfileContracts.Presenter mPresenter;

    @Inject
    public LandlordFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_landlord, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setPresenter(UserProfileContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setTitle(String title) {
       String t = title;
       mTitle.setText(title);
    }


}

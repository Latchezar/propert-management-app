package com.example.jorexa.landlordapp.propertyDetails;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class propertyDetailsFragment extends Fragment implements propertyDetailsContracts.View {

    @BindView(R.id.tv_property_details_name)
    TextView mPropertyName;

    @BindView(R.id.tv_property_details_address)
    TextView mPropertyAddress;

    @BindView(R.id.tv_property_details_price)
    TextView mPropertyPrice;

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
        mPropertyName.setText(property.getPropertyName());
        mPropertyAddress.setText(property.getAddress());
        mPropertyPrice.setText(property.getPropertyPrice()+"");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_property_details, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setPresenter(propertyDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    private void runOnUi(Runnable action) {
        getActivity().runOnUiThread(action);
    }
}

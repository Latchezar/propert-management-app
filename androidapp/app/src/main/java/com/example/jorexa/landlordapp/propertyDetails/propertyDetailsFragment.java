package com.example.jorexa.landlordapp.propertyDetails;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.LoginUser;
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

    @BindView(R.id.tv_tenant_or_landlord)
    TextView mTenantOrLandlord;

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
    public void showError(Exception e) {
        runOnUi(()-> Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show());
        throw new RuntimeException(e);
    }

    @Override
    public void setTenantOrLandlord(LoginUser user) {
        runOnUi(() -> {
            String setText = "";
            if(user.getUserType() == 1) {
             setText += "Landlord: ";
            } else {
             setText += "Tenant: ";
            }
            setText += user.firstName+ " "+user.lastName;
            mTenantOrLandlord.setText(setText);
        });
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

    @Override
    public void showCustomException(String text) {
        runOnUi(()-> Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show());
    }

    private void runOnUi(Runnable action) {
        getActivity().runOnUiThread(action);
    }
}

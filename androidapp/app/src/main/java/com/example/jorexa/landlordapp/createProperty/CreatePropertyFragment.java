package com.example.jorexa.landlordapp.createProperty;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreatePropertyFragment extends Fragment implements CreatePropertyContracts.View {

    @BindView(R.id.new_property_name_field)
    EditText nameField;
    @BindView(R.id.new_property_price_field)
    EditText priceField;

    private CreatePropertyContracts.Presenter mPresenter;
    private int mUserID;

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
    public void setUser(int user) {
        mUserID = user;
    }

    @OnClick(R.id.new_property_button)
    public void onSubmit(View view) {
        String name = String.valueOf(nameField.getText());
        int price = Integer.parseInt(String.valueOf(priceField.getText()));
        int landlordID = mUserID;

        try {
            mPresenter.onSubmit(name, price, landlordID);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package com.example.jorexa.landlordapp.userprofile;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.Property;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordFragment extends Fragment implements UserProfileContracts.View {

    private UserProfileContracts.Navigator mNavigator;

    @BindView(R.id.lv_properties)
    ListView mPropertiesListView;

    ListView mTestLV;

    @BindView(R.id.tv_landlord_title)
    TextView mTitle;

    @Inject
    ArrayAdapter<Property> mPropertiesAdapter;

    public ArrayAdapter<String> mProperties2Adapter;

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

    @OnItemClick(R.id.lv_properties)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Property property = mPropertiesAdapter.getItem(position);
        mPresenter.selectProperty(property);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_landlord, container, false);

        ButterKnife.bind(this, view);

        //mTestLV = (ListView) view.findViewById(R.id.lv_properties);
        //mProperties2Adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1);

        //mTestLV.setAdapter(mProperties2Adapter);
        mPropertiesListView.setAdapter(mPropertiesAdapter);

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

    @Override
    public void showProperties(List<Property> properties) {

        List<String> names = properties.stream()
                .map(Property::getPropertyName)
                .collect(Collectors.toList());

       int a = 5;
        runOnUi(() -> {
            //mTitle.setText(names.get(0));
            mPropertiesAdapter.clear();
            mPropertiesAdapter.addAll(properties);
        });
    }

    @Override
    public void showPropertyDetails(Property property) {
        runOnUi(() -> mNavigator.navigateWith(property));
    }

    void setNavigator(UserProfileContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    private void runOnUi(Runnable action) {
        getActivity().runOnUiThread(action);
    }

}

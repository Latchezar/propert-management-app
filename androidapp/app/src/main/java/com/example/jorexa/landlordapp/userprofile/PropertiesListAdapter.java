package com.example.jorexa.landlordapp.userprofile;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.Property;

import javax.inject.Inject;

public class PropertiesListAdapter extends ArrayAdapter<Property> {
    @Inject
    public PropertiesListAdapter(@NonNull Context context) {
        super(context, -1);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(
                R.layout.property_item,
                parent,
                false
        );

        TextView nameTextView = view.findViewById(R.id.tv_property_name);
        TextView addressTextView = view.findViewById(R.id.tv_property_addresss);

        Property property = getItem(position);

        nameTextView.setText(property.getPropertyName());
        addressTextView.setText("Address: " + property.getAddress());

        return view;
    }
}


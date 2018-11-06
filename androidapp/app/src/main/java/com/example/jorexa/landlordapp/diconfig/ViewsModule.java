package com.example.jorexa.landlordapp.diconfig;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.jorexa.landlordapp.models.Property;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewsModule {
    @Provides
    public ArrayAdapter<Property> propertyArrayAdapter(Context context) {
        //return new PropertiesListAdapter(context);
        return null;
    }
}

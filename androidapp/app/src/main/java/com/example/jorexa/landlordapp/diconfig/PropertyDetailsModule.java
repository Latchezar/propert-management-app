package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsContracts;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsFragment;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class PropertyDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract propertyDetailsFragment propertyDetailsFragment();

    @ActivityScoped
    @Binds
    abstract propertyDetailsContracts.Presenter propertyDetailsPresenter(propertyDetailsPresenter presenter);
}

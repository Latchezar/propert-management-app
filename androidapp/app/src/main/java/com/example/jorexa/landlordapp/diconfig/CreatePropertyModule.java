package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.createProperty.CreatePropertyContracts;
import com.example.jorexa.landlordapp.createProperty.CreatePropertyFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CreatePropertyModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CreatePropertyFragment createPropertyFragment();

    @ActivityScoped
    @Binds
    abstract CreatePropertyContracts.Presenter createPropertyPresenter(CreatePropertyContracts.Presenter presenter);
}

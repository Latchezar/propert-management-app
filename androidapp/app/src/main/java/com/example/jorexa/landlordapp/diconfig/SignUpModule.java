package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.singup.RegisterFormFragment;
import com.example.jorexa.landlordapp.singup.SignUpContracts;
import com.example.jorexa.landlordapp.singup.SignUpPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SignUpModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract RegisterFormFragment registerFormFragment();

    @ActivityScoped
    @Binds
    abstract SignUpContracts.Presenter signUpPresenter(SignUpPresenter presenter);
}

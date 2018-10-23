package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.Login.LoginContracts;
import com.example.jorexa.landlordapp.Login.LoginFragment;
import com.example.jorexa.landlordapp.Login.LoginPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract LoginFragment loginFragment();

    @ActivityScoped
    @Binds
    abstract LoginContracts.Presenter taskPresenter(LoginPresenter presenter);
}

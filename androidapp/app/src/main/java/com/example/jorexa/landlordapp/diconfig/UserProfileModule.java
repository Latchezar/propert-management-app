package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.Login.LoginContracts;
import com.example.jorexa.landlordapp.Login.LoginFragment;
import com.example.jorexa.landlordapp.Login.LoginPresenter;
import com.example.jorexa.landlordapp.userprofile.LandlordFragment;
import com.example.jorexa.landlordapp.userprofile.TenantFragment;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;
import com.example.jorexa.landlordapp.userprofile.UserProfilePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class UserProfileModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract TenantFragment tenantFragment();

    @ActivityScoped
    @Binds
    abstract UserProfileContracts.Presenter taskPresenter(UserProfilePresenter presenter);
}

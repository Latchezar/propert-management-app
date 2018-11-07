package com.example.jorexa.landlordapp.diconfig;

//package com.example.android.architecture.blueprints.todoapp.di;

import com.example.jorexa.landlordapp.Login.MainActivity;
import com.example.jorexa.landlordapp.chat.chatActivity;
import com.example.jorexa.landlordapp.createProperty.CreatePropertyActivity;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsActivity;
import com.example.jorexa.landlordapp.singup.SignUpActivity;
import com.example.jorexa.landlordapp.singup.SignUpContracts;
import com.example.jorexa.landlordapp.userprofile.UserProfileActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
            modules = LoginModule.class
    )
    //abstract SuperheroesListActivity superheroesListActivity();
     //abstract MainActivity mainActivity();
    abstract MainActivity mainActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = SignUpModule.class
    )
    abstract SignUpActivity signUpActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = UserProfileModule.class
    )
    abstract UserProfileActivity userProfileActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = CreatePropertyModule.class
    )
    abstract CreatePropertyActivity createPropertyActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = PropertyDetailsModule.class
    )
    abstract propertyDetailsActivity propertyDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = ChatModule.class
    )
    abstract chatActivity chatActivity();

}
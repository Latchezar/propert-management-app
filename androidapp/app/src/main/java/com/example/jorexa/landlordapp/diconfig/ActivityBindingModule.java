package com.example.jorexa.landlordapp.diconfig;

//package com.example.android.architecture.blueprints.todoapp.di;

import com.example.jorexa.landlordapp.Login.MainActivity;
import com.example.jorexa.landlordapp.createProperty.CreatePropertyActivity;
import com.example.jorexa.landlordapp.singup.SignUpActivity;
import com.example.jorexa.landlordapp.singup.SignUpContracts;

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
            modules = CreatePropertyModule.class
    )
    abstract CreatePropertyActivity createPropertyActivity();
}
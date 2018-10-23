package com.example.jorexa.landlordapp.diconfig;

//package com.example.android.architecture.blueprints.todoapp.di;

import com.example.jorexa.landlordapp.Login.MainActivity;

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
}
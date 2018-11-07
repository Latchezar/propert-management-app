package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.chat.chatContracts;
import com.example.jorexa.landlordapp.chat.chatFragment;
import com.example.jorexa.landlordapp.chat.chatPresenter;
import com.example.jorexa.landlordapp.singup.RegisterFormFragment;
import com.example.jorexa.landlordapp.singup.SignUpContracts;
import com.example.jorexa.landlordapp.singup.SignUpPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ChatModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract chatFragment chatFragment();

    @ActivityScoped
    @Binds
    abstract chatContracts.Presenter chatPresenter(chatPresenter presenter);
}

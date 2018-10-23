package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.async.AsyncRunnerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public AsyncRunner asyncRunner() {
        return new AsyncRunnerImpl();
    }
}

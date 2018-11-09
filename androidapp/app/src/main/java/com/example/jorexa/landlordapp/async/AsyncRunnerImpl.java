package com.example.jorexa.landlordapp.async;

import android.os.AsyncTask;
import android.os.Handler;

import javax.inject.Inject;

public class AsyncRunnerImpl implements AsyncRunner {

    @Inject
    public AsyncRunnerImpl() {

    }

    @Override
    public void runInBackground(Runnable action) {
        runInBackgroundStatic(action);
    }


    private static void runInBackgroundStatic(final Runnable action) {
        //Handler handler = new Handler();
        //handler.postDelayed(() -> {
          //  new AsyncTask<Boolean, Void, Void>() {
          //      @Override
          //      protected Void doInBackground(Boolean... booleans) {
          //          action.run();
          //          return null;
          //      }
          //  }.execute(true);
        new AsyncTask<Boolean, Void, Void>() {
            @Override
            protected Void doInBackground(Boolean... booleans) {
                action.run();
                return null;
            }
        }.execute(true);
        //}, 1000);
    }
}

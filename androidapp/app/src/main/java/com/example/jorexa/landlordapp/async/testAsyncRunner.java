package com.example.jorexa.landlordapp.async;

import android.os.AsyncTask;

public class testAsyncRunner {

    public static void runInBackground(final Runnable action) {
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

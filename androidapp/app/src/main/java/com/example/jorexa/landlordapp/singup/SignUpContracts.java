package com.example.jorexa.landlordapp.singup;

public interface SignUpContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showCustomException(String text);

        void showError(Exception e);
        }

    interface Presenter {
        void subscribe(View view);

    }
}

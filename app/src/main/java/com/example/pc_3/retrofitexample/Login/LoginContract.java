package com.example.pc_3.retrofitexample.Login;

/**
 * Created by PC-3 on 09/10/2017.
 */

interface LoginContract {
    interface View {
        void showMessage(String message);

        void showProgress();

        void dismissProgress();

        void userLogged();
    }

    interface Presenter {
        void requestLogin(String user, String password);

        void userLogged();

        void showMessage(String message);
    }

    interface Model {
        void setPresenter(LoginContract.Presenter presenter);

        void requestLogin(String user, String password);
    }
}

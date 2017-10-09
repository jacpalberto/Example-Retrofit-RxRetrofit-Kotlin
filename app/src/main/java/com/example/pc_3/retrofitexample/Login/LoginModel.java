package com.example.pc_3.retrofitexample.Login;

/**
 * Created by PC-3 on 09/10/2017.
 */

class LoginModel implements LoginContract.Model {
    private LoginContract.Presenter presenter;

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestLogin(String user, String password) {

    }
}

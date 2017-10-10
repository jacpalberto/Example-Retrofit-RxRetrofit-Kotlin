package com.example.pc_3.retrofitexample.Login;

/**
 * Created by PC-3 on 09/10/2017.
 */

class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;
    private LoginContract.Model model;

    LoginPresenter(LoginContract.View view, LoginContract.Model model) {
        this.view = view;
        this.model = model;
        this.model.setPresenter(this);
    }

    @Override
    public void requestLogin(String user, String password) {
        if (user.isEmpty() && password.isEmpty()) {
            view.showMessage("user & password invalid");
            return;
        }
        view.showProgress();
        model.requestLogin(user, password);
    }

    @Override
    public void userLogged() {
        view.dismissProgress();
        view.userLogged();
    }

    @Override
    public void showMessage(String message) {
        view.dismissProgress();
        view.showMessage(message);
    }
}
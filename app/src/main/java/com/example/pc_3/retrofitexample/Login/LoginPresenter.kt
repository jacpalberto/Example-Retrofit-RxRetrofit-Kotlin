package com.example.pc_3.retrofitexample.Login

/**
 * Created by PC-3 on 09/10/2017.
 */

internal class LoginPresenter(private val view: LoginContract.View, private val model: LoginContract.Model) : LoginContract.Presenter {

    init {
        this.model.setPresenter(this)
    }

    override fun requestLogin(user: String, password: String) {
        if (user.isEmpty() && password.isEmpty()) {
            view.showMessage("user & password invalid")
            return
        }
        view.showProgress()
        model.requestLogin(user, password)
    }

    override fun userLogged() {
        view.dismissProgress()
        view.userLogged()
    }

    override fun showMessage(message: String) {
        view.dismissProgress()
        view.showMessage(message)
    }
}
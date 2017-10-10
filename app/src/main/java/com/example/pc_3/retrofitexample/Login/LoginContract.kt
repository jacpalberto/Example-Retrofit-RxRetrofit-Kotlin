package com.example.pc_3.retrofitexample.Login

/**
 * Created by PC-3 on 09/10/2017.
 */

internal interface LoginContract {
    interface View {
        fun showMessage(message: String)

        fun showProgress()

        fun dismissProgress()

        fun userLogged()
    }

    interface Presenter {
        fun requestLogin(user: String, password: String)

        fun userLogged()

        fun showMessage(message: String)
    }

    interface Model {
        fun setPresenter(presenter: LoginContract.Presenter)

        fun requestLogin(user: String, password: String)
    }
}

package com.example.pc_3.retrofitexample.Login

import com.example.pc_3.retrofitexample.BaseClient
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by PC-3 on 09/10/2017.
 */

internal class LoginModel : LoginContract.Model {
    private lateinit var presenter: LoginContract.Presenter

    override fun setPresenter(presenter: LoginContract.Presenter) {
        this.presenter = presenter
    }

    override fun requestLogin(user: String, password: String) {
        val observable = BaseClient.provideApiService().login(user, password, "", "android")
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response<ResponseBody>> {
                    override fun onComplete() {
                    }

                    override fun onNext(t: Response<ResponseBody>) {
                        if (t.isSuccessful) presenter.userLogged()
                        else presenter.showMessage("error: ${t.code()}")
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onError(e: Throwable) {
                        presenter.showMessage("error: $e")
                    }
                })
    }
}

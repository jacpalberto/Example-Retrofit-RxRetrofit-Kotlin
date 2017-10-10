package com.example.pc_3.retrofitexample.Login


import com.example.pc_3.retrofitexample.BaseClient

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
        val call = BaseClient.provideApiService().login(user, password, "", "android")
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful)
                    presenter.userLogged()
                else
                    presenter.showMessage("error: " + response.code())
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                presenter.showMessage("error: " + t.toString())
            }
        })
    }
}

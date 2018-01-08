package com.example.pc_3.retrofitexample.Github

import com.example.pc_3.retrofitexample.BaseClient
import com.example.pc_3.retrofitexample.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by PC-3 on 09/10/2017.
 */

class GithubUserInteractor : GithubUserContract.Interactor {
    private lateinit var presenter: GithubUserContract.Presenter

    override fun setPresenter(presenter: GithubUserContract.Presenter) {
        this.presenter = presenter
    }

    override fun fetchUserData(user: String) {
        val call = BaseClient.provideApiService().getUser(user)
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful)
                    response.body()?.let { presenter.userDataFound(it) }
                else
                    presenter.errorMessage(response.code())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                presenter.userDataFailure()
            }
        })
    }
}

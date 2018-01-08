package com.example.pc_3.retrofitexample.Github

import com.example.pc_3.retrofitexample.BaseClient
import com.example.pc_3.retrofitexample.User
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
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
        val observable = BaseClient.provideApiService().getUser(user)
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response<User>> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(userResponse: Response<User>) {
                        if (userResponse.isSuccessful)
                            userResponse.body()?.let { presenter.userDataFound(it) }
                        else
                            presenter.errorMessage(userResponse.code())
                    }

                    override fun onError(e: Throwable) {
                        presenter.userDataFailure()
                    }

                    override fun onComplete() {

                    }
                })
    }
}

package com.example.pc_3.retrofitexample.Login

/**
 * Created by PC-3 on 09/10/2017.
 */

class GithubUserPresenter(private val view: GithubUserContract.View,
                          private val interactor: GithubUserContract.Interactor) :
        GithubUserContract.Presenter {
    init {
        this.interactor.setPresenter(this)
    }

    override fun fetchUserData(user: String) {
        view.showProgress()
        interactor.fetchUserData(user)
    }

    override fun userDataFound(githubUser: User) {
        view.dismissProgress()
        view.showGithubUser(githubUser)
    }

    override fun userDataFailure() {
        view.dismissProgress()
        view.showErrorMessage()
    }

    override fun errorMessage(code: Int) {
        view.dismissProgress()
        view.showErrorMessage(code)
    }
}
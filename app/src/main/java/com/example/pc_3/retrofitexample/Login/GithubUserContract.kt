package com.example.pc_3.retrofitexample.Login

/**
 * Created by PC-3 on 09/10/2017.
 */
interface GithubUserContract {
    interface View {
        fun showMessage(message: String)

        fun showProgress()

        fun dismissProgress()

        fun showGithubUser(githubUser: User)

        fun showErrorMessage(code: Int)

        fun showErrorMessage()
    }

    interface Presenter {
        fun fetchUserData(user: String)

        fun userDataFound(githubUser: User)

        fun userDataFailure()

        fun errorMessage(code: Int)
    }

    interface Interactor {
        fun setPresenter(presenter: GithubUserContract.Presenter)

        fun fetchUserData(user: String)
    }
}

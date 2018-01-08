package com.example.pc_3.retrofitexample.Github

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.example.pc_3.retrofitexample.R
import com.example.pc_3.retrofitexample.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class GithubUserActivity : AppCompatActivity(), GithubUserContract.View {

    private lateinit var presenter: GithubUserContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        presenter = GithubUserPresenter(this, GithubUserInteractor())
        btnSearch.setOnClickListener {
            requestGithubUser()
            hideKeyboard()
        }
        etUsername.setOnEditorActionListener({ _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                requestGithubUser()
            }
            false
        })
    }

    private fun requestGithubUser() {
        val username = etUsername.text.toString().trim()
        if (!username.isEmpty()) presenter.fetchUserData(username)
        else showMessage(getString(R.string.empty_username))
    }

    override fun showMessage(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .create()
                .show()
    }

    override fun showProgress() {
        progressBar.show()
    }

    override fun dismissProgress() {
        progressBar.hide()
    }

    override fun showGithubUser(githubUser: User) {
        etUsername.setText("")
        with(githubUser) {
            tvName.text = login
            tvUrl.text = htmlUrl
            tvFollowers.text = getString(R.string.followers, followers.toString())
            tvRepositories.text = getString(R.string.repositories, publicRepos.toString())
            Picasso.with(this@GithubUserActivity).load(avatarUrl).into(ivProfile)
        }
    }

    override fun showErrorMessage(code: Int) {
        var message = getString(R.string.connection_error)
        if (code == 404) message = getString(R.string.user_not_found)
        showMessage(message)
    }

    override fun showErrorMessage() {
        showErrorMessage(R.string.connection_error)
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.currentFocus.windowToken, 0)
    }
}

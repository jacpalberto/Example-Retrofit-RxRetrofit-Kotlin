package com.example.pc_3.retrofitexample.Login

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.pc_3.retrofitexample.R
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        presenter = LoginPresenter(this, LoginModel())
        btnLogin!!.setOnClickListener {
            presenter.requestLogin(tvEmail.text.toString().trim(), tvPassword.text.toString().trim())
        }
    }

    override fun showMessage(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        builder.setPositiveButton(android.R.string.ok, null)
        val dialog = builder.create()
        dialog.show()
    }

    override fun showProgress() {
        progressBar.show()
    }

    override fun dismissProgress() {
        progressBar.hide()
    }

    override fun userLogged() {
        tvPassword.text.clear()
        tvEmail.text.clear()
        Toast.makeText(this, "Log in Successful", Toast.LENGTH_SHORT).show()
    }
}

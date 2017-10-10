package com.example.pc_3.retrofitexample.Login;

import android.util.Log;

import com.example.pc_3.retrofitexample.BaseClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by PC-3 on 09/10/2017.
 */

class LoginModel implements LoginContract.Model {
    private LoginContract.Presenter presenter;

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestLogin(String user, String password) {
        Call<ResponseBody> call = BaseClient.provideApiService().login(user, password, "", "android");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) presenter.userLogged();
                else presenter.showMessage("error: " + response.code());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                presenter.showMessage("error: " + t.toString());
            }
        });
    }
}

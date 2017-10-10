package com.example.pc_3.retrofitexample.Login;


import com.example.pc_3.retrofitexample.BaseClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
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
        Observable<Response<ResponseBody>> observable = BaseClient.provideApiService().login(user, password, "", "android");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<ResponseBody>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Response<ResponseBody> responseBodyResponse) {
                        if (responseBodyResponse.isSuccessful()) presenter.userLogged();
                        else presenter.showMessage("error: " + responseBodyResponse.code());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        presenter.showMessage("error: " + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

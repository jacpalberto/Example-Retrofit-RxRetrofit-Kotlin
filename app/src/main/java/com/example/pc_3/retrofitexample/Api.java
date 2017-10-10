package com.example.pc_3.retrofitexample;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by PC-3 on 09/10/2017.
 */

public interface Api {
    @FormUrlEncoded
    @POST("auth/sign_in")
    Observable<Response<ResponseBody>> login(@Field("user") String user, @Field("password") String password,
                                             @Field("device_token") String device, @Field("device_os") String android);

}
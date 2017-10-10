package com.example.pc_3.retrofitexample

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by PC-3 on 09/10/2017.
 */

interface Api {
    @FormUrlEncoded
    @POST("auth/sign_in")
    fun login(@Field("user") user: String, @Field("password") password: String,
              @Field("device_token") device: String, @Field("device_os") android: String): Observable<Response<ResponseBody>>

}
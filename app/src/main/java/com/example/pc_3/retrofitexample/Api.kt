package com.example.pc_3.retrofitexample

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by PC-3 on 09/10/2017.
 */

interface Api {
    @GET("users/{name}")
    fun getUser(@Path("name") name: String): Observable<Response<User>>
}
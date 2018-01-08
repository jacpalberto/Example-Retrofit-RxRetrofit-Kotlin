package com.example.pc_3.retrofitexample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by PC-3 on 09/10/2017.
 */

interface Api {
    @GET("users/{name}")
    fun getUser(@Path("name") name: String): Call<User>

}
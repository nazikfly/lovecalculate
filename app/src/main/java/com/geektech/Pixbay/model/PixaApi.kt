package com.geektech.Pixbay.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {

    @GET("api/")
    fun getImage(
        @Query("key")key:String ="30923667-7b36f1553e3fb8fafc1c37c20",
        @Query("q")keyWord :String,
        @Query("page") page:Int=1,
        @Query("per_page") perPage:Int=5
    ): Call<PixaModel>
}
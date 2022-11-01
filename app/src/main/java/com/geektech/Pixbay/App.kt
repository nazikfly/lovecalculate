package com.geektech.Pixbay

import android.app.Application
import com.geektech.Pixbay.model.PixaApi
import com.geektech.Pixbay.model.RetrofitService

class App:Application() {

    companion object{
        lateinit var api:PixaApi
    }

    override fun onCreate() {
        super.onCreate()
        api=RetrofitService().getApi()
    }
}
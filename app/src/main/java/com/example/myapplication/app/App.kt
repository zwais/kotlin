package com.example.myapplication.app

import android.app.Application
import com.example.myapplication.api.Api
import com.kotlinframework.net.network.RetrofitManager

class App:Application(){
    override fun onCreate() {
        super.onCreate()
        RetrofitManager.instance.init(Api.BASE_URL)
    }
}
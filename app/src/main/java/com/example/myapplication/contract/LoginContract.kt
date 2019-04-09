package com.example.myapplication.contract

import android.content.Context
import com.example.myapplication.bean.UserBean
import com.kotlinframework.net.network.IModelCallback

interface LoginContract{
    interface LoginPresenter{

        fun login(hashMap: HashMap<String,String>,context: Context)
    }

    interface ILoginModel{

        fun login(context: Context,hashMap: HashMap<String, String>,modelCallback:IModelCallback<UserBean>)


    }

    interface ILoginView{

        fun success(userBean: UserBean)
        fun failure(string: String)

    }
}
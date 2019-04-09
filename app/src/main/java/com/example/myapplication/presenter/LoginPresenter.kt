package com.example.myapplication.presenter

import android.content.Context
import com.example.myapplication.bean.UserBean
import com.example.myapplication.contract.LoginContract
import com.example.myapplication.model.LoginModel
import com.kotlinframework.net.network.IModelCallback

class LoginPresenter : LoginContract.LoginPresenter{
    lateinit var loginModel: LoginModel
    lateinit var iLoginView: LoginContract.ILoginView
    override fun login(hashMap: HashMap<String, String>, context: Context) {
        loginModel.login(context, hashMap, object : IModelCallback<UserBean> {
            override fun failure(string: String) {
                iLoginView?.failure(string)
            }

            override fun sucess(data: UserBean) {
                iLoginView?.success(data)
            }

        })
    }
     //绑定
     fun attach(iLoginView: LoginContract.ILoginView) {
         this.iLoginView = iLoginView
         loginModel = LoginModel()

     }
    //解绑

    fun detach() {
        if (iLoginView != null) {
            iLoginView == null
        }
    }
}
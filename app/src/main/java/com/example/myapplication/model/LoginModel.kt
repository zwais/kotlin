package com.example.myapplication.model

import android.content.Context
import com.example.myapplication.api.Api
import com.example.myapplication.api.UserApiService
import com.example.myapplication.bean.UserBean
import com.example.myapplication.contract.LoginContract
import com.kotlinframework.net.network.*

class LoginModel : LoginContract.ILoginModel{
    override fun login(context: Context,hashMap: HashMap<String, String>, modelCallback: IModelCallback<UserBean>) {
        RetrofitManager.instance.createService(UserApiService::class.java).longin(Api.LOGIN_URL,hashMap)
            .compose(NetScheduler.compose())
            .subscribe(object : NetResponseObserver<UserBean>(context){
                override fun success(data: UserBean) {

                    modelCallback?.sucess(data)

                }

                override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {

                    modelCallback?.failure(apiErrorModel.message)
                }

            })
    }

}
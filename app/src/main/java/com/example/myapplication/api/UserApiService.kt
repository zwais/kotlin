package com.example.myapplication.api

import com.example.myapplication.bean.UserBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

interface UserApiService{
    @POST
    @FormUrlEncoded
    fun longin(@Url string: String, @FieldMap hashMap: HashMap<String,String>):Observable<UserBean>
}
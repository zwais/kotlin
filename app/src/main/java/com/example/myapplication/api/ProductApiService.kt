package com.example.myapplication.api

import com.example.myapplication.bean.ProductEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url


interface ProductApiService{
    @GET
    fun getProducts(@Url string: String, @QueryMap params:HashMap<String,String>):Observable<ProductEntity>
}
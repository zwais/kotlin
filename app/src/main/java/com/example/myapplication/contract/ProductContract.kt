package com.example.myapplication.contract
import android.content.Context
import com.example.myapplication.bean.ProductEntity
import com.kotlinframework.net.network.IModelCallback

interface ProductContract{
    interface IProdcutPresenter{
        fun getProducts(hashMap: HashMap<String,String>,context: Context)
    }
    interface IProductModel{
        fun getProducts(context: Context,hashMap: HashMap<String, String>,modelCallback:IModelCallback<ProductEntity>)

    }

    interface IProductView{

        fun success(productEntity: ProductEntity)
        fun failure(string: String)

    }
}
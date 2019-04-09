package com.example.myapplication.presenter

import android.content.Context
import com.example.myapplication.bean.ProductEntity
import com.example.myapplication.contract.ProductContract
import com.example.myapplication.model.ProductModel
import com.kotlinframework.net.network.IModelCallback

class ProductPresenter : ProductContract.IProdcutPresenter{
    lateinit var productModel: ProductModel
    lateinit var iProductView: ProductContract.IProductView
    override fun getProducts(hashMap: HashMap<String, String>, context: Context) {
        productModel.getProducts(context,hashMap,object : IModelCallback<ProductEntity>{
            override fun failure(string: String) {
                iProductView?.failure(string)
            }

            override fun sucess(data: ProductEntity) {
                iProductView.success(data)
            }
        })
    }
   //绑定
   fun attach(iProductView: ProductContract.IProductView) {
       this.iProductView = iProductView
       productModel = ProductModel()

   }
    //解绑
    fun datach(){
        if (iProductView !=null){
            iProductView==null

        }
    }
}
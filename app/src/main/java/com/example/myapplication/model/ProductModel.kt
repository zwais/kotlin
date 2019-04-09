package com.example.myapplication.model

import android.content.Context
import com.example.myapplication.api.Api
import com.example.myapplication.api.ProductApiService
import com.example.myapplication.bean.ProductEntity
import com.example.myapplication.contract.ProductContract
import com.kotlinframework.net.network.*

class ProductModel :ProductContract.IProductModel{
    override fun getProducts(
        context: Context,
        hashMap: HashMap<String, String>,
        modelCallback: IModelCallback<ProductEntity>
    ) {
        RetrofitManager.instance.createService(ProductApiService::class.java)
            .getProducts(Api.PRODUCT_URL,hashMap)
            .compose(NetScheduler.compose())
            .subscribe(object : NetResponseObserver<ProductEntity>(context){
                override fun success(data: ProductEntity) {

                    modelCallback?.sucess(data)

                }

                override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {

                    modelCallback?.failure(apiErrorModel.message)
                }

            })

    }


}
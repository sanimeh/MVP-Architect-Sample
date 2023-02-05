package com.laces.app.sdk

import com.laces.app.sdk.api.ProductsApi
import com.laces.app.sdk.model.ProductModel
import com.laces.app.sdk.network.RetrofitBuilder
import javax.inject.Singleton

interface Sdk {
    suspend fun getProducts(): List<ProductModel>
    suspend fun getDetails(id: Int): ProductModel
}

@Singleton
class SdkImpl : Sdk {

    override suspend fun getProducts(): List<ProductModel> {
        val quotesApi = RetrofitBuilder.getInstance().create(ProductsApi::class.java)
        return quotesApi.getWrapperProduct().body()?.products!!
    }

    override suspend fun getDetails(id: Int): ProductModel {
        val quotesApi = RetrofitBuilder.getInstance().create(ProductsApi::class.java)
        return quotesApi.getDetails(id)
    }
}

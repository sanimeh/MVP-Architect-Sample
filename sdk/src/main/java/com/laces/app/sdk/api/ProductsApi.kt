package com.laces.app.sdk.api

import com.laces.app.sdk.model.ProductModel
import com.laces.app.sdk.model.WrapperProduct
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface ProductsApi {

    @GET("/products")
    suspend fun getWrapperProduct(): Response<WrapperProduct>

    @GET("/products/{id}")
    suspend fun getDetails(@Path("id") id: Int): ProductModel

}
package com.laces.app.sdk.model

import com.google.gson.annotations.SerializedName

data class WrapperProduct(

    @SerializedName("limit")
    val limit: Int,

    @SerializedName("products")
    val products: List<ProductModel>,

    @SerializedName("skip")
    val skip: Int,

    @SerializedName("total")
    val total: Int
)

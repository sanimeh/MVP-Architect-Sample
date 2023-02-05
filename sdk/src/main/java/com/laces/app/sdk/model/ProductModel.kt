package com.laces.app.sdk.model

import com.google.gson.annotations.SerializedName

data class ProductModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("brand")
    val brand: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("discountPercentage")
    val discountPercentage: Float,

    @SerializedName("images")
    val images: List<String>,

    @SerializedName("price")
    val price: Int,

    @SerializedName("rating")
    val rating: Float,

    @SerializedName("stock")
    val stock: Int,

    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("title")
    val title: String
)

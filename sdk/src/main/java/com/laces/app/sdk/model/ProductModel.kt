package com.laces.app.sdk.model

import com.google.gson.annotations.SerializedName
import kotlin.math.roundToInt

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
){
    fun getPriceBack(): String {
        return "$price €"
    }

    fun getDiscountBack(): String {
        return "${discountPercentage.roundToInt()}% OFF"
    }

    fun getOfferBack(): String {

        var value: Float = (price.toFloat() - ((discountPercentage / 100) * price.toFloat()))
        return "${value.roundToInt()} €"
    }

    fun getStockBack(): String {
        return when (stock) {
            0 -> "Sold out!"
            in 1..10 -> " Only $stock left "
            else -> "In Stock"
        }
    }

    fun inStock(): Boolean {
        return stock > 0
    }
}

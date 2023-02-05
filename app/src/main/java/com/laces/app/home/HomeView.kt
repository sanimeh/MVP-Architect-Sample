package com.laces.app.home

import com.laces.app.mvp.OccView
import com.laces.app.sdk.model.ProductModel

interface HomeView: OccView {

    fun setRecyclerData(result: List<ProductModel>)
    fun setLoading(isLoading: Boolean)
    fun setError(message: String)

}
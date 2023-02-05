package com.laces.app.details

import com.laces.app.mvp.OccView
import com.laces.app.sdk.model.ProductModel

interface DetailsView: OccView {

    fun setContent(result: ProductModel)

    fun setLoading(isLoading: Boolean)

    fun setError(message: String)
}
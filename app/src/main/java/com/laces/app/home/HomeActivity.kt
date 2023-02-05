package com.laces.app.home

import android.view.LayoutInflater
import com.laces.app.databinding.ActivityHomeBinding
import com.laces.app.mvp.OccActivity
import com.laces.app.sdk.model.ProductModel

class HomeActivity : OccActivity<ActivityHomeBinding, HomePresenter, HomeView>(),
    HomeView {

    override fun providePresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun provideBinding(layoutInflater: LayoutInflater): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun setRecyclerData(result: List<ProductModel>) {
        TODO("Not yet implemented")
    }

    override fun setLoading(isLoading: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setError(message: String) {
        TODO("Not yet implemented")
    }


}
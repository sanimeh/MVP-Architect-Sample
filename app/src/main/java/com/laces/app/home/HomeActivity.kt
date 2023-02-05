package com.laces.app.home

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import com.laces.app.databinding.ActivityHomeBinding
import com.laces.app.home.adapter.HomeAdapter
import com.laces.app.mvp.OccActivity
import com.laces.app.sdk.model.ProductModel

class HomeActivity : OccActivity<ActivityHomeBinding, HomePresenter, HomeView>(),
    HomeView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.observeProducts(this)
    }

    override fun providePresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun provideBinding(layoutInflater: LayoutInflater): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun setRecyclerData(result: List<ProductModel>) {
        binding.recyclerViewProducts.adapter = HomeAdapter(result)
    }

    override fun setLoading(isLoading: Boolean) {
        binding.progressBarHome.isVisible = isLoading
    }

    override fun setError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
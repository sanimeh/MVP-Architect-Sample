package com.laces.app.details

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import com.laces.app.databinding.ActivityDetailsBinding
import com.laces.app.details.adapter.ProductDetailsImagesAdapter
import com.laces.app.mvp.OccActivity
import com.laces.app.sdk.model.ProductModel

class DetailsActivity : OccActivity<ActivityDetailsBinding, DetailsPresenter, DetailsView>(),
    DetailsView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.observeProducts(this)
        handleClicks()
    }

    private fun handleClicks() {
        binding.toolbar.buttonBack.setOnClickListener {
            onBackPressed()
        }

        binding.layoutProductDescription.setOnClickListener {
            binding.showDescription = binding.showDescription == false
        }
    }

    override fun providePresenter(): DetailsPresenter {
        val id: Int = intent.getIntExtra("id", -1)
        return DetailsPresenter(id)
    }

    override fun provideBinding(layoutInflater: LayoutInflater): ActivityDetailsBinding {
        return ActivityDetailsBinding.inflate(layoutInflater)
    }

    override fun setContent(result: ProductModel) {
        binding.model = result
        binding.toolbar.textViewToolbar.text = result.title
        initViewPagerImages(result.images)
    }

    private fun initViewPagerImages(images: List<String>) {
        val productImagesAdapter = ProductDetailsImagesAdapter()
        binding.viewPagerImages.adapter = productImagesAdapter
        productImagesAdapter.submitList(images)
        binding.indicatorViewImages.attachTo(binding.viewPagerImages)
    }

    override fun setLoading(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
    }

    override fun setError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

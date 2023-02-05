package com.laces.app.details

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.laces.app.mvp.OccPresenter
import com.laces.app.sdk.SdkImpl
import com.laces.app.sdk.model.ProductModel
import kotlinx.coroutines.launch

class DetailsPresenter(private val productId: Int): OccPresenter<DetailsView>() {

    private val sdk = SdkImpl()

    private val _successLivaData: MutableLiveData<ProductModel> = MutableLiveData()
    private val _errorLiveData: MutableLiveData<Throwable> = MutableLiveData()
    private val _loadingLivaData: MutableLiveData<Boolean> = MutableLiveData()

    override fun onCreate() {
        super.onCreate()
        getDetails(productId)

    }

    private fun getDetails(productId: Int) {
        presenterScope.launch {
            _loadingLivaData.postValue(true)
            try {
                _successLivaData.postValue(sdk.getDetails(productId))
            } catch (e: java.lang.Exception) {
                _errorLiveData.postValue(e)
            }
            _loadingLivaData.postValue(false)
        }
    }

    fun observeProducts(lifecycleOwner: LifecycleOwner) {
        _successLivaData.observe(lifecycleOwner, ::handleSuccess)
        _loadingLivaData.observe(lifecycleOwner, ::handleLoading)
        _errorLiveData.observe(lifecycleOwner, ::handleError)
    }

    private fun handleSuccess(result: ProductModel) {
        sendToView { view -> view.setContent(result) }
    }

    private fun handleLoading(isLoading: Boolean) {
        sendToView { view ->
            view.setLoading(isLoading)
        }
    }

    private fun handleError(throwable: Throwable) {
        sendToView { view -> view.setError(throwable.message!!) }
    }
}
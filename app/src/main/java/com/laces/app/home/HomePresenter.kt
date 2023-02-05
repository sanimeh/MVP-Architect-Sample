package com.laces.app.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.laces.app.mvp.OccPresenter
import com.laces.app.sdk.SdkImpl
import com.laces.app.sdk.model.ProductModel
import kotlinx.coroutines.launch

class HomePresenter : OccPresenter<HomeView>() {

    private val sdk = SdkImpl()
    private val _successLiveData: MutableLiveData<List<ProductModel>> = MutableLiveData()
    private val _errorLiveData: MutableLiveData<Throwable> = MutableLiveData()
    private val _loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()

    override fun onCreate() {
        super.onCreate()
        getProducts()
    }

    private fun getProducts() {
        presenterScope.launch {
            _loadingLiveData.postValue(true)
            try {
                _successLiveData.postValue(sdk.getProducts())
            } catch (e: java.lang.Exception) {
                _errorLiveData.postValue(e)
            }
            _loadingLiveData.postValue(false)
        }

    }

    fun observeProducts(lifecycleOwner: LifecycleOwner) {
        _successLiveData.observe(lifecycleOwner, ::handleSuccess)
        _loadingLiveData.observe(lifecycleOwner, ::handleLoading)
        _errorLiveData.observe(lifecycleOwner, ::handleError)
    }

    private fun handleError(throwable: Throwable) {
        sendToView { view ->
            view.setError(throwable.message!!)
        }
    }

    private fun handleLoading(isLoading: Boolean) {
        sendToView { view ->
            view.setLoading(isLoading)
        }
    }

    private fun handleSuccess(products: List<ProductModel>) {
        sendToView { view ->
            view.setRecyclerData(products)
        }
    }

}
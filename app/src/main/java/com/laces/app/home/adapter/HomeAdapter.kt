package com.laces.app.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laces.app.databinding.RowProductBinding
import com.laces.app.sdk.model.ProductModel

class HomeAdapter(private val productList: List<ProductModel>, val onClickItem: (id: Int) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        layoutInflater = LayoutInflater.from(recyclerView.context)
    }

    inner class HomeViewHolder(private val binding: RowProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ProductModel) {
            binding.model = model
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(RowProductBinding.inflate(layoutInflater, parent, false))
    }


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentModel = productList[position]
        holder.bind(currentModel)
        holder.itemView.setOnClickListener {
            onClickItem(currentModel.id)
        }
    }


    override fun getItemCount() = productList.size
}
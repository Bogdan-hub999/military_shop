package com.example.military

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.military.databinding.ItemProductBinding

class ProductAdapter(
    private val products: List<Product>,
    private val onBuyClicked: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.tvName.text = product.name
            binding.tvDescription.text = product.description
            binding.tvPrice.text = "${product.price} грн"

            binding.btnBuy.setOnClickListener {
                onBuyClicked(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    // ОСЬ ТУТ БУЛА ПОМИЛКА, ТЕПЕР ВСЕ ЧІТКО:
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount() = products.size
}
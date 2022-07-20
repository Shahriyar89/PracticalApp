package com.matrix87.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matrix87.practicalapp.R
import com.matrix87.room.Product
import kotlinx.android.synthetic.main.customer_item.view.*

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    var products: List<Product>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    var onclick: ((Product) -> Unit)? = null

    inner class ProductHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.customer_item, parent, false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.itemView.title.text = products?.get(position)?.title
        holder.itemView.subtitle.text = products?.get(position)?.subtitle.toString()

        holder.itemView.setOnClickListener { onclick?.invoke(products?.get(position) ?: Product(1, "", "1", "")) }
    }

    override fun getItemCount() = products?.size ?: 0
}